package src.service;

import src.model.Dog;
import src.Message.Message;
import src.model.Person;
import src.model.Puppy;
import src.thread.AdminThread;
import src.thread.UserThread;

import java.util.ArrayList;
import java.util.Scanner;

public class PuppyService {
    private static Scanner sc;
    private static DogService dogService;
    private static ArrayList<Puppy> puppies = new ArrayList<>();

    public PuppyService(Scanner sc, DogService dogService) {
        this.sc = sc;
        this.dogService = dogService;
    }

    public void soldDog(Person person) {
        ArrayList<Dog> dogs = dogService.getDogs();

        if (dogs.isEmpty()) {
            System.out.println(Message.NO_DOG);
            return;
        }

        double property = person.getProperty();

        while (true) {
            try {
                if (property >= 2000) {
                    break;
                } else{
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException error) {
                System.out.println(Message.FALE_INPUT);
            } catch (IllegalArgumentException e) {
                System.out.println("보호자 재산이 부족합니다.");
                return;
            }
        }
        String dog_name = "";

        while (true) {
            System.out.print("구매할 동물의 이름: ");

            try {
                dog_name = sc.nextLine();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Message.NO_DOG);
                return;
            }
        }

        for (Dog dog : dogs) {
            if (dog.getName().equals(dog_name)) {
                System.out.println(Message.SUCCESS_SOLD);
                Puppy puppy = new Puppy(dog, person);
                puppies.add(puppy);
                person.addDog(puppy);
                person.withdraw(dog.getPrice());
                dogs.remove(dog);

                UserThread userThread = new UserThread(puppy);
                AdminThread adminThread = new AdminThread(puppy, userThread, this);

                adminThread.start();
                userThread.start();

                break;
            } else {
                System.out.println(Message.NO_DOG);
            }
        }
    }
    public void showPuppies() {
        if (puppies.isEmpty()) {
            System.out.println(Message.NO_DOG);
            return;
        }

        System.out.println("------------ 분양된 강아지 목록 ------------");
        for (Puppy puppy : puppies) {
            puppy.write();
            System.out.println("------------- 소유자 정보 -------------");
            puppy.getPerson().write();
            System.out.println("------------------------------------");
        }
    }
    public void returnPuppy(Puppy puppy) {
        puppies.remove(puppy);
        Dog returnDog = new Dog(puppy.getDogType(), puppy.getName(), puppy.getAge(), puppy.getGender(), puppy.getPrice(), puppy.getHealth(), puppy.getTraining());
        dogService.getDogs().add(returnDog);
        System.out.println(puppy.getName() + "를 보호소로 반환합니다.");
    }
}

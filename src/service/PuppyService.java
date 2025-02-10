package src.service;

import src.model.Dog;
import src.Message.Message;
import src.model.Person;
import src.model.Puppy;

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
                puppies.add(new Puppy(dog, person));
                person.addDog(dog);
                person.withdraw(dog.getPrice());
                dogs.remove(dog);
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
}

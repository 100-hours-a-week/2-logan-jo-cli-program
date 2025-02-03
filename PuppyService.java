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

    public void soldDog() {
        ArrayList<Dog> dogs = dogService.getDogs();

        if (dogs.isEmpty()) {
            System.out.println("보호 가능한 동물이 없습니다.");
            return;
        }

        System.out.print("보호자 이름 입력: ");
        String name = sc.nextLine();
        System.out.print("보호자 전화번호 입력: ");
        String phone = sc.nextLine();
        System.out.print("보호자 주소 입력: ");
        String address = sc.nextLine();
        System.out.print("보호자 재산 입력(단위: 만원): ");

        int property=0;

        while (true) {
            try {
                property = Integer.parseInt(sc.nextLine());
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
        Person person = new Person(name, phone, address, property);

        System.out.print("구매할 동물 이름 입력: ");
        String dog_name = sc.nextLine();

        for (Dog dog : dogs) {
            if (dog.getName().equals(dog_name)) {
                System.out.println(Message.SUCCESS_SOLD);
                puppies.add(new Puppy(dog, person));
                person.addDog(dog);
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

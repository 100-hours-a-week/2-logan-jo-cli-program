package src.service;

import src.Message.Message;
import src.model.Person;

import java.util.Scanner;

public class ModalService {
    private static Scanner sc;
    private static DogService dogService;
    private static PuppyService puppyService;
    private static PersonService personService;

    public ModalService(Scanner sc) {
        this.sc = sc;
        dogService = new DogService(sc);
        puppyService = new PuppyService(sc, dogService);
        personService = new PersonService(sc);
    }
    public void adminModal() {
        while (true) {
            System.out.println("---- 관리자 모드 ----");
            System.out.println("1. 동물 추가");
            System.out.println("2. 동물 목록");
            System.out.println("3. 동물 수정");
            System.out.println("4. 동물 삭제");
            System.out.println("5. 분양된 동물");
            System.out.println("6. 등록된 사용자");
            System.out.println("7. 종료");

            try{
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        dogService.addDog();
                        break;
                    case 2:
                        dogService.showDogs();
                        break;
                    case 3:
                        dogService.editDog();
                        break;
                    case 4:
                        dogService.deleteDog();
                        break;
                    case 5:
                        puppyService.showPuppies();
                        break;
                    case 6:
                        personService.showPersons();
                        break;
                    case 7:
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }
    }
    public void personModal() {
        while (true) {
            System.out.println("---- 사용자 모드 ----");

            while (true) {
                Person person = null;

                System.out.print("등록된 사용자 인가요? (1. 예, 2. 아니요, 3. 종료): ");
                String answer = sc.nextLine();

                try {
                    switch (Integer.parseInt(answer)) {
                        case 1:
                            person = personService.findPerson();
                            userModal(person);
                            break;
                        case 2:
                            person = personService.addPerson();
                            userModal(person);
                            break;
                        case 3:
                            return;
                        default:
                            throw new IllegalArgumentException();
                    }
                } catch (NumberFormatException e) {
                    System.out.println(Message.FALE_INPUT);
                } catch (IllegalArgumentException e) {
                    System.out.println("유저가 존재하지 않습니다.");
                }
            }
        }
    }
    public void userModal(Person person) {
        while (true) {
            System.out.println("---- 사용자 서비스 ----");

            while (true) {
                System.out.println("1. 동물 목록");
                System.out.println("2. 동물 구매");
                System.out.println("3. 입금");
                System.out.println("4. 종료");

                try {
                    int choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            dogService.showDogs();
                            break;
                        case 2:
                            puppyService.soldDog(person);
                            break;
                        case 3:
                            personService.deposit(person);
                            break;
                        case 4:
                            return;
                        default:
                            throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(Message.FALE_INPUT);
                }
            }
        }
    }
}

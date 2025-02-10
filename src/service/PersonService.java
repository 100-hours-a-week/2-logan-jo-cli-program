package src.service;

import src.Message.Message;
import src.model.Person;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonService {
    private static Scanner sc;

    private static ArrayList<Person> persons = new ArrayList<>();
    public PersonService(Scanner sc) {
        this.sc = sc;
    }
    public Person addPerson() {
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("전화번호: ");
        String phone = sc.nextLine();
        System.out.print("주소: ");
        String address = sc.nextLine();
        System.out.print("재산: ");
        int property = Integer.parseInt(sc.nextLine());
        Person person = new Person(name, phone, address, property);
        System.out.println("사람이 추가되었습니다.");

        persons.add(person);

        return person;
    }
    public Person findPerson() {
        while (true) {
            System.out.print("등록되 사용자의 이름을 말해주세요: ");
            String name = "";
            try {
                name = sc.nextLine();

                for (Person person : persons) {
                    if (person.getName().equals(name)) {
                        return person;
                    }
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }
        throw new IllegalArgumentException();
    }
    public void showPersons() {
        if (persons.isEmpty()) {
            System.out.println("등록된 사용자가 없습니다.");
            return;
        }

        for (int i=0; i<persons.size(); i++) {
            System.out.print(i + 1 + ". ");
            persons.get(i).LineWrite();
        }
    }
    public void deposit(Person person) {
        System.out.print("입금할 금액: ");
        int money = 0;

        while (true) {
            try {
                money = Integer.parseInt(sc.nextLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }

        person.deposit(money);
        System.out.println("입금이 완료되었습니다.");
    }
}

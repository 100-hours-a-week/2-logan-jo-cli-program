import enums.Gender;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Dog> dogs = new ArrayList<>();
    private static ArrayList<Puppy> puppies = new ArrayList<>();

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true){
            System.out.println("---- 유기견 보호소 관리 시스템 ----");
            System.out.println("1. 관리자 모드, 2. 사용자 모드, 3. 종료");

            try {
                int c = Integer.parseInt(sc.nextLine());

                if (c == 1) {
                    adminModal();
                } else if (c == 2) {
                    userModal();
                } else if (c == 3) {
                    System.out.println(Message.END_PROGRAM);
                    break;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }
    }
    private static void addDog() {
        String name;
        int age;
        Gender gender = null;
        String type;
        double price;
        String health;
        int training;

        System.out.print("동물 이름 입력: ");
        name = sc.nextLine().trim();

        while (true) {
            System.out.print("동물 나이 입력: ");
            try {
                age = Integer.parseInt(sc.nextLine().trim());
                if (age < 0) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (IllegalArgumentException | Error e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }
        while (true) {
            System.out.print("동물 성별 입력(1. 수컷, 2. 암컷): ");
            String genderInput = sc.nextLine().trim();

            try {
                if (genderInput.equals("1")) {
                    gender = Gender.수컷;
                    break;
                } else if (genderInput.equals("2")) {
                    gender = Gender.암컷;
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }

        System.out.print("동물 품종 입력: ");
        type = sc.nextLine().trim();

        while (true) {
            System.out.print("동물 가격 입력(단위: 만원): ");
            try {
                price = Double.parseDouble(sc.nextLine().trim());
                if (price < 0) {
                    System.out.println("가격은 0 이상이어야 합니다.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("올바른 숫자를 입력하세요.");
            }
        }
        while (true) {
            System.out.print("동물 건강 상태 입력(건강함, 돈이 조금 듬, 돈이 많이 듬): ");
            health = sc.nextLine().trim();
            try {
                if (health.equals("건강함") || health.equals("돈이 조금 듬") || health.equals("돈이 많이 듬") || health.equals("많이 아파요...")) {
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }
        while (true) {
            System.out.print("동물 훈련도 입력(0~100): ");
            try {
                training = Integer.parseInt(sc.nextLine().trim());
                if (training < 0 || training > 100) {
                    System.out.println("훈련도는 0에서 100 사이의 값이어야 합니다.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }
        dogs.add(new Dog(type, name, age, gender, price, health, training));
        System.out.println("동물이 추가되었습니다.");
    }
    private static void showDogs() {
        if (dogs.isEmpty()) {
            System.out.println(Message.NO_ANIMALS);
            return;
        }
        System.out.println("------------ 등록된 동물 목록 ------------");
        for (Dog dog : dogs) {
            dog.write();
            System.out.println("------------------------------------");
        }
    }
    private static void editDog() {
        if (dogs.isEmpty()) {
            System.out.println(Message.NO_ANIMALS);
            return;
        }

        System.out.print("수정할 동물의 이름 입력: ");
        String name = sc.nextLine();

        for (Dog dog : dogs) {
            if (dog.getName().equals(name)) {
                System.out.println("어떤 정보를 수정하시겠습니까? ");
                System.out.println("1. 이름");
                System.out.println("2. 나이");
                System.out.println("3. 성별");
                System.out.println("4. 품종");
                System.out.println("5. 가격");
                System.out.println("6. 건강 상태");
                System.out.println("7. 훈련도");

                try {
                    int choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            System.out.print("수정할 이름 입력: ");
                            String newName = sc.nextLine().trim();
                            dog.setName(newName);
                            break;
                        case 2:
                            while (true) {
                                System.out.print("수정할 나이 입력: ");
                                try {
                                    int newAge = Integer.parseInt(sc.nextLine().trim());
                                    if (newAge < 0) {
                                        System.out.println("나이는 0 이상이어야 합니다.");
                                        continue;
                                    }
                                    dog.setAge(newAge);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("올바른 숫자를 입력하세요.");
                                }
                            }
                            break;
                        case 3:
                            while (true) {
                                System.out.print("수정할 성별 입력(1. 수컷, 2. 암컷): ");
                                String genderInput = sc.nextLine().trim();
                                if (genderInput.equals("1")) {
                                    dog.setGender(Gender.수컷);
                                    break;
                                } else if (genderInput.equals("2")) {
                                    dog.setGender(Gender.암컷);
                                    break;
                                } else {
                                    System.out.println(Message.FALE_INPUT);
                                }
                            }
                            break;
                        case 4:
                            System.out.print("수정할 품종 입력: ");
                            String newSubspecies = sc.nextLine().trim();
                            dog.setDogType(newSubspecies);
                            break;
                        case 5:
                            while (true) {
                                System.out.print("수정할 가격 입력: ");
                                try {
                                    double newPrice = Double.parseDouble(sc.nextLine().trim());
                                    if (newPrice < 0) {
                                        System.out.println("가격은 0 이상이어야 합니다.");
                                        continue;
                                    }
                                    dog.setPrice(newPrice);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("올바른 숫자를 입력하세요.");
                                }
                            }
                            break;
                        case 6:
                            while (true) {
                                System.out.print("수정할 건강 상태 입력(건강함, 돈이 조금 듬, 돈이 많이 듬): ");
                                String newHealth = sc.nextLine().trim();
                                if (newHealth.equals("건강함") || newHealth.equals("돈이 조금 듬") || newHealth.equals("돈이 많이 듬") || newHealth.equals("많이 아파요...")) {
                                    dog.setHealth(newHealth);
                                    break;
                                } else {
                                    System.out.println("올바른 건강 상태를 입력하세요: 건강함, 돈이 조금 듬, 돈이 많이 듬");
                                }
                            }
                            break;

                        case 7:
                            while (true) {
                                System.out.print("수정할 훈련도 입력(0~100): ");
                                try {
                                    int newTraining = Integer.parseInt(sc.nextLine().trim());
                                    if (newTraining < 0 || newTraining > 100) {
                                        System.out.println("훈련도는 0에서 100 사이의 값이어야 합니다.");
                                        continue;
                                    }
                                    dog.setTraining(newTraining);
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("올바른 숫자를 입력하세요.");
                                }
                            }
                            break;

                        default:
                            throw new IllegalArgumentException();
                    }
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println(Message.FALE_INPUT);
                }
            } else {
                System.out.println(Message.NO_DOG);
                return;
            }
        }
    }
    private static void deleteDog() {
        if (dogs.isEmpty()) {
            System.out.println(Message.NO_ANIMALS);
            return;
        }

        System.out.print("삭제할 동물의 이름 입력: ");
        String name = sc.nextLine();

        for (int i = 0; i < dogs.size(); i++) {
            if (dogs.get(i).getName().equals(name)) {
                dogs.remove(i);
                System.out.println("강아지가 삭제되었습니다.");
                return;
            }
        }
        System.out.println(Message.NO_DOG);
    }
    private static void soldDog() {
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
    private static void showPuppies() {
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

    private static void adminModal() {
        while (true) {
            System.out.println("---- 관리자 모드 ----");
            System.out.println("1. 동물 추가");
            System.out.println("2. 동물 목록");
            System.out.println("3. 동물 수정");
            System.out.println("4. 동물 삭제");
            System.out.println("5. 분양된 동물");
            System.out.println("6. 종료");

            try{
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        addDog();
                        break;
                    case 2:
                        showDogs();
                        break;
                    case 3:
                        editDog();
                        break;
                    case 4:
                        deleteDog();
                        break;
                    case 5:
                        showPuppies();
                        break;
                    case 6:
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }
    }

    private static void userModal() {
        while (true) {
            System.out.println("---- 사용자 모드 ----");
            System.out.println("1. 동물 목록");
            System.out.println("2. 동물 구매");
            System.out.println("3. 종료");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        showDogs();
                        break;
                    case 2:
                        soldDog();
                        break;
                    case 3:
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


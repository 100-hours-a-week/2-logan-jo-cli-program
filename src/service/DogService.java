package src.service;

import src.enums.Gender;
import src.model.Dog;
import src.Message.Message;

import java.util.ArrayList;
import java.util.Scanner;

public class DogService {
    private static Scanner sc;
    private static ArrayList<Dog> dogs = new ArrayList<>();

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    public DogService(Scanner sc) {
        this.sc = sc;
    }

    public void addDog() {
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
    public void showDogs() {
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
    public void editDog() {
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
    public void deleteDog() {
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
}

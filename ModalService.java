import java.util.Scanner;

public class ModalService {
    private static Scanner sc;
    private static DogService dogService;
    private static PuppyService puppyService;

    public ModalService(Scanner sc) {
        this.sc = sc;
        this.dogService = new DogService(sc);
        this.puppyService = new PuppyService(sc, dogService);
    }
    public void adminModal() {
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
                        return;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException e) {
                System.out.println(Message.FALE_INPUT);
            }
        }
    }
    public void userModal() {
        while (true) {
            System.out.println("---- 사용자 모드 ----");
            System.out.println("1. 동물 목록");
            System.out.println("2. 동물 구매");
            System.out.println("3. 종료");

            try {

                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {
                    case 1:
                        dogService.showDogs();
                        break;
                    case 2:
                        puppyService.soldDog();
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

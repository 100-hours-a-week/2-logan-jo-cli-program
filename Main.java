import enums.Gender;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static ModalService modalService = new ModalService(sc);

    public static void main(String[] args) {
        while (true) {
            System.out.println("---- 유기견 보호소 관리 시스템 ----");
            System.out.println("1. 관리자 모드, 2. 사용자 모드, 3. 종료");

            try {
                int c = Integer.parseInt(sc.nextLine());

                if (c == 1) {
                    modalService.adminModal();
                } else if (c == 2) {
                    modalService.userModal();
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
}


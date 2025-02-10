package src.thread;

import src.model.Person;
import src.model.Puppy;
import src.service.PuppyService;

public class AdminThread extends Thread {
    private Puppy puppy;
    private UserThread userThread;
    private static PuppyService puppyService;
    private volatile boolean stopThread = false;

    public AdminThread(Puppy puppy, UserThread userThread, PuppyService puppyService) {
        this.puppy = puppy;
        this.userThread = userThread;
        this.puppyService = puppyService;
    }

    @Override
    public void run() {
        Person person = puppy.getPerson();

        for (int i = 1; i <= 4; i++) {
            try {
                Thread.sleep(2100);
                if (stopThread) break;

                System.out.println("[관리자] " + i + "주차 " + person.getName() + "의 주간 점검결과");

                if (person.getProperty() < 2000) {
                    System.out.println("[관리자] 아이를 키울 자격이 부족합니다. 애완동물을 반환합니다.");
                    stopThread = true;
                    userThread.interrupt();
                    puppyService.returnPuppy(puppy);
                    break;
                }

                if (puppy.getTraining() <= 0) {
                    System.out.println("[관리자] 훈련도가 너무 낮아 위협의 우려가 있습니다. 애완동물을 반환합니다.");
                    stopThread = true;
                    userThread.interrupt();
                    puppyService.returnPuppy(puppy);
                    break;
                }
            } catch (InterruptedException e) {
                System.out.println("[관리자] 1달 감시 스레드 중단");
                return;
            }
        }
    }
}

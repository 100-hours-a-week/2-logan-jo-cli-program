package src.thread;

import src.model.Puppy;
import java.util.Random;

public class UserThread extends Thread {
    private Puppy puppy;
    private volatile boolean stopThread = false;

    public UserThread(Puppy puppy) {
        this.puppy = puppy;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 4; i++) {
                if (stopThread) break;

                Thread.sleep(2000);
                System.out.println("[사용자] " + i + "주차 " + puppy.getName() + "의 주간 점검결과");
                weeklyCheck();
            }
        } catch (InterruptedException e) {
            System.out.println("[사용자] 1달 양육 보고서 스레드 종료");
        }
    }

    public void weeklyCheck() {
        Random random = new Random();
        double money = puppy.getPerson().getProperty() - puppy.getPrice();
        int training = puppy.getTraining() + random.nextInt(21) - 10;

        System.out.println(puppy.getPerson().getName()+" 잔여 양육비: " + money + ", 훈련도: " + training);

        puppy.getPerson().setProperty(money);
        puppy.setTraining(training);
    }
}
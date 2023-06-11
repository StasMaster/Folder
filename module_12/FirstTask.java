package module_12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class FirstTask {
//    private static long startTime;
//    private static ScheduledExecutorService scheduler;
//
//    public static void main(String[] args) {
//        startTime = System.currentTimeMillis(); // Запоминаем время начала сессии
//
//        scheduler = Executors.newScheduledThreadPool(2);
//
//        // Запускаем задачи
//        scheduler.scheduleAtFixedRate(TimeCounterTask, 0, 1, TimeUnit.SECONDS);
//        scheduler.scheduleAtFixedRate(MessageTask, 5, 5, TimeUnit.SECONDS);
//    }
//
//    private static Runnable TimeCounterTask = new Runnable() {
//        private int count = 0;
//
//        @Override
//        public void run() {
//            System.out.println("Поток_1: Прошло " + count + " секунд");
//            count++;
//        }
//    };
//
//    private static Runnable MessageTask = new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("Поток_2: Прошло 5 секунд");
//        }
//    };

    private static long startTime;
    private static ScheduledExecutorService scheduler;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis(); // Запоминаем время начала сессии

        scheduler = Executors.newScheduledThreadPool(2);

        // Запускаем задачи
        scheduler.scheduleAtFixedRate(() -> {
            int count = (int) ((System.currentTimeMillis() - startTime) / 1000);
            System.out.println("Поток_1: Прошло " + count + " секунд");
        }, 0, 1, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Поток_2: Прошло 5 секунд");
        }, 5, 5, TimeUnit.SECONDS);
    }
}
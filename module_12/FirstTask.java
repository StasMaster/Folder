package module_12;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FirstTask {
    private static long startTime;
    private static ScheduledExecutorService scheduler;

    public static void main(String[] args) {
        startTime = System.currentTimeMillis();

        scheduler = Executors.newScheduledThreadPool(2);

        scheduler.scheduleAtFixedRate(() -> {
            int count = (int) ((System.currentTimeMillis() - startTime) / 1000);
            System.out.println("Поток_1: Прошло " + count + " секунд");
        }, 0, 1, TimeUnit.SECONDS);

        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("Поток_2: Прошло 5 секунд");
        }, 5, 5, TimeUnit.SECONDS);
    }
}

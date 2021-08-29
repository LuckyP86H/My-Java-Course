import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class CountDownLatchTest {

    private static int THREAD_COUNT = 10;

    @Test
    public void testCountDownLatch() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            Executor executor = new Executor() {
                public void execute(Runnable command) {
                    new Thread(command).start();

                }
            };
            executor.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "到达会议室");
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "说：开会！");
    }

    @Test
    public void testConcurrency() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new Runnable() {
                public void run() {
                    try {
                        countDownLatch.await();
                        System.out.println(Thread.currentThread().getName() + "到达终点！");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.println(Thread.currentThread().getName() + "说：各就各位，预备...");
        Thread.sleep(1000);
        System.out.println("跑！");
        countDownLatch.countDown();
    }
}
import org.junit.Test;
import java.util.concurrent.*;

public class MainThreadTest {

    //region 1、sleepTest
    @Test
    public void sleepTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        new Thread(new Runnable() {
            public void run() {
                int result = sum();
                System.out.println("Async time is ：" + result);
            }
        }).start();
        Thread.sleep(100);
        System.out.println("Usage time：" + (System.currentTimeMillis() - start - 100) + " ms");
    }

    //region 2、countDownLatchTest
    @Test
    public void countDownLatchTest() throws InterruptedException {
        long start = System.currentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            public void run() {
                int result = sum();
                System.out.println("The async is ：" + result);
                countDownLatch.countDown();
            }
        }).start();
        countDownLatch.await();
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
    }
}
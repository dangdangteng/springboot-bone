package lock;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author baiyang
 * @date 2020/8/28
 */
public class RLock {

    private static final Logger log = LoggerFactory.getLogger(RLock.class);

    private static ReentrantLock reentrantLock = new ReentrantLock();

    private static class Test extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(10000);
                System.out.println("---- test ----");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Test s = new Test();
        new Thread(s).start();
        Executors.newFixedThreadPool(1000).submit(() -> {
            try {
                boolean b = reentrantLock.tryLock(5L, TimeUnit.SECONDS);
                if (b) {
                    getMessage();
                }
            } catch (InterruptedException e) {
                log.warn(e.toString());
                Thread.currentThread().interrupt();
            } finally {
                System.out.println("释放锁");
                reentrantLock.unlock();
            }
        });
    }

    private static void getMessage() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("打印，如果超时，打印不出来的");
    }
}

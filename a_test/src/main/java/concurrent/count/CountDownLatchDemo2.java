package concurrent.count;

import java.util.concurrent.CountDownLatch;

/**
 * @author baiyang
 * @date 2020/12/30
 */
public class CountDownLatchDemo2 {

    private static final int COUNT = 1;

    private static final CountDownLatch COUNT_DOWN_LATCH = new CountDownLatch(COUNT);

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("------- 等待执行" + Thread.currentThread().getName());
                    COUNT_DOWN_LATCH.await();
                    System.out.println("------- 已经执行" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("------- 等待执行" + Thread.currentThread().getName());
                    COUNT_DOWN_LATCH.await();
                    System.out.println("------- 已经执行" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                System.out.println("-------" + Thread.currentThread().getName());
                COUNT_DOWN_LATCH.countDown();
                System.out.println("-------" + Thread.currentThread().getName());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("------- 等待执行" + Thread.currentThread().getName());
                    COUNT_DOWN_LATCH.await();
                    System.out.println("------- 已经执行" + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

}

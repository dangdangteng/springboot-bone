package concurrent.count;

import java.util.concurrent.CountDownLatch;

/**
 * @author baiyang
 * @date 2020/12/30
 */
public class CountDownLatchDemo {
    /**
     * 当 count 计数 为0 才执行下面逻辑
     *
     *  当你启动了一个线程，你需要等它执行结束， 此时，CountDownLatch也许是一个很好的选择
     *
     *  当你启动很多线程，你需要这些线程等到通知 后才真正开始，CountDownLatch也许是一个很 好的选择。
     */

    private static int COUNT = 5;

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(COUNT);
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    countDownLatch.countDown();
                    System.out.println("还有" + countDownLatch.getCount() + "未被消耗");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ;
        }.start();
        new Thread() {
            @Override
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    countDownLatch.countDown();
                    System.out.println("还有" + countDownLatch.getCount() + "未被消耗");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            ;
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            // 计数器 != 0 进入等待
            countDownLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

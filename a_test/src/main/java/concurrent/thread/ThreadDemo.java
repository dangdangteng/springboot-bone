package concurrent.thread;

/**
 * @author baiyang
 * @date 2020/12/28
 */
public class ThreadDemo {
    /*
    现在有 T1、T2、T3 三个线程，
    你怎样保证 T2 在 T1 执行完后执行，
    T3 在 T2 执行完后执 行?

    考察点join()
     */

    public static void main(String[] args) {
        Thread t1 = new MyThread("线程1");
        Thread t2 = new MyThread("线程2");
        Thread t3 = new MyThread("线程3");

        Thread tt1 = new MyThread("线程1-----");
        Thread tt2 = new MyThread("线程2-----");
        Thread tt3 = new MyThread("线程3-----");

        try {
            //t1先启动
            t1.start();
            t1.join();
            //t2
            t2.start();
            t2.join();
            //t3
            t3.start();
            t3.join();
            System.out.println("-----------");
            tt1.start();
            tt2.start();
            tt3.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

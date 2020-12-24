package concurrent.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author baiyang
 * @date 2020/12/24
 */
public class MyBlockQueueDemo1 {

    //        a.await();
    // 未锁就直接执行await、signal、siganlAll会抛异常
    // 一个lock 可以创建多个condition
    private final Lock lock = new ReentrantLock();
    private final Condition a = lock.newCondition();
    private final Condition b = lock.newCondition();

    private final Queue<Object> objects = new LinkedList<>();

    private final Integer maxSize = 10;

    /**
     * 要执行await操作，必须先取得该Condition的锁。 执行await操作之后，锁会释放。 被唤醒之前，需要先获得锁
     *
     * @return
     * @throws InterruptedException
     */

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            if (objects.size() == 0) {
                a.await();
            }
            if (objects.size() == maxSize) {
                b.signalAll();
            }
            return objects.poll();
        } finally {
            lock.unlock();
        }
    }

    public void offer(Object o) throws InterruptedException {
        lock.lock();
        try {
            if (objects.size() == 0) {
                a.signalAll();
            }
            if (objects.size() == maxSize) {
                b.await();
            }
            objects.add(o);
        } finally {
            lock.unlock();
        }
    }
}

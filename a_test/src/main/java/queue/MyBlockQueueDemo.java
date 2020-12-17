package queue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: yang
 * 2020/12/10
 */
public class MyBlockQueueDemo {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition a = lock.newCondition();
//        a.await();//未锁就直接执行await、signal、siganlAll会抛异常
    }
}

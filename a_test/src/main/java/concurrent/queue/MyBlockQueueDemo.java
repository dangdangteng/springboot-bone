package concurrent.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: yang
 * 2020/12/10
 */
public class MyBlockQueueDemo {

    private final Object var1 = new Object();
    private final Object var2 = new Object();
    private final Queue<Object> list = new LinkedList<>();
    private final Integer maxSize = 10;

    /**
     * 分别对var1 & var2 进行枷锁
     *
     * @param o
     * @throws InterruptedException
     */
    public void offer(Object o) throws InterruptedException {
        synchronized (var1) {
            if (list.size() == 0) {
                var1.notifyAll();
            }
            synchronized (var2) {
                if (list.size() == maxSize) {
                    var2.wait();
                }
                list.add(o);
            }
        }
    }

    public Object take() throws InterruptedException {
        synchronized (var1) {
            if (list.size() == 0) {
                var1.wait();
            }
            synchronized (var2) {
                if (list.size() == maxSize) {
                    var2.notifyAll();
                }
                return list.poll();
            }
        }
    }
}

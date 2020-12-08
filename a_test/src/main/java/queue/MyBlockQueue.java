package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: yang
 * 2020/12/8
 */
public class MyBlockQueue {

    /**
     * 未取得锁就直接执行wait、notfiy、notifyAll会抛异常
     */

    private Object object = new Object();
    private Queue<Object> myQueue = new LinkedList<>();

    public void offer(Object o){
        synchronized (object){
            if (myQueue.size() == 0){
                object.notifyAll();
            }
            myQueue.add(o);
        }
    }

    public Object take() throws InterruptedException{
        synchronized (object){
            if (myQueue.size() == 0){
                object.wait();
            }
            return myQueue.poll();
        }
    }

    public int size(){
        return myQueue.size();
    }
}

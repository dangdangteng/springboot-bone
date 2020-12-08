package queue.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import queue.MyBlockQueue;

/**
 * @author: yang
 * 2020/12/8
 */
public class MyBlockQueueTest {

    private static final Logger log = LoggerFactory.getLogger(MyBlockQueueTest.class);

    public static void main(String[] args) throws InterruptedException{
        MyBlockQueue myBlockQueue = new MyBlockQueue();
        for (int i=0 ;i <10 ;i++){
            myBlockQueue.offer(i);
        }
        log.info("Queue Size:{}",myBlockQueue.size());
        log.info("Queue message:{}",myBlockQueue.take());
        log.info("Queue Size:{}",myBlockQueue.size());
        log.info("Queue message:{}",myBlockQueue.take());
        log.info("Queue Size:{}",myBlockQueue.size());

    }
}

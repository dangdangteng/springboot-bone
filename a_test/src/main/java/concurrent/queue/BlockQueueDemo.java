package concurrent.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author: yang
 * 2020/12/8
 */
public class BlockQueueDemo {
    /**
     * 阻塞队列 获取通过take(), 或者poll(1, TimeUnit.SECONDS)
     *
     * 在BlockingQueue中，要使用put和take，而非offer和poll。如果 要使用offer和poll，也是要使用带等待时间参数的offer和poll
     */

    private static final Logger log = LoggerFactory.getLogger(BlockQueueDemo.class);

    private static final BlockingQueue<Object> BLOCKING_QUEUE = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) throws InterruptedException {
        R r = new R();
        Thread thread = new Thread(r, "thread-baiyang");
        thread.start();
        Thread.sleep(10000);
        BLOCKING_QUEUE.poll(1, TimeUnit.SECONDS);
        while (true){
            log.info("BLOCKING_QUEUE:{},BLOCKING_QUEUE size:{}",BLOCKING_QUEUE.take(),BLOCKING_QUEUE.size());
        }
    }

    static class R implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                try {
                    BLOCKING_QUEUE.put("----" + i);
                }catch (Exception e){
                    log.warn("BLOCKING_QUEUE: {}",e.toString());
                }
            }
        }
    }

}

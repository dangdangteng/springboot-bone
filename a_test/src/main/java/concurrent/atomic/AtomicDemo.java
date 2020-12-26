package concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baiyang
 * @date 2020/12/24
 */
public class AtomicDemo {
    /**
     * 由硬件提供原子操作指令实现的。在非激烈竞争的情况下，开
     * 销更小，速度更快。Java.util.concurrent中实现的原子操作类
     * 包括: AtomicBoolean、AtomicInteger、AtomicLong、AtomicReference
     */
    private AtomicInteger integer = new AtomicInteger();

    public Integer get(){
        return integer.get();
    }

    public void increment(){
        integer.incrementAndGet();
    }

    class IncreInteger{
        private volatile Integer min = 0;

        public synchronized void increment(){
            min ++;
        }

        public Integer getMin(){
            return min;
        }
    }
}

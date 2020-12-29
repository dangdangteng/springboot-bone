package concurrent.atomic.lockfree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author baiyang
 * @date 2020/12/26
 */
public class LFDemo1 {
    /**
     * lock free 算法不需要加锁 只需3部分组成
     */
    private AtomicInteger atomicInteger = new AtomicInteger();

    public void setAtomicInteger(int value) {
        // 1 for or while 循环
        for (; ; ) {
            int counter = atomicInteger.get();
            if (value > counter){
                //2 cas compareandset
                if (atomicInteger.compareAndSet(counter,value)){
                    //3 break
                    break;
                }else {
                    continue;
                }
            }else {
                break;
            }
        }
    }

    public Integer getAtomic(){
        return atomicInteger.get();
    }
}

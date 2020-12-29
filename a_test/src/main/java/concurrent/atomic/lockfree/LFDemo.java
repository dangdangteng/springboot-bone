package concurrent.atomic.lockfree;

/**
 * @author baiyang
 * @date 2020/12/26
 */
public class LFDemo {
    private volatile Integer max = 0;

    public synchronized void set(int value){
        if (value > max){
            max = value;
        }
    }

    public Integer getMax(){
        return max;
    }
}

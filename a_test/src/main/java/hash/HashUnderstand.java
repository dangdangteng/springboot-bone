package hash;

/**
 * @author baiyang
 * @date 2020/9/9
 */
public class HashUnderstand {

    /**
     * hashcode 不是指向内存地址
     * @param args
     */
    public static void main(String[] args) {
        String a = "我就想试试";
//        System.out.println(a.hashCode());
        int hash = -1856715117;
        if (a.hashCode() == hash){
            System.out.println("hash ==");
//          打印内存位置
            System.out.println(System.identityHashCode(a));
//          打印内存位置
            System.out.println(System.identityHashCode(hash));
        }
    }
}

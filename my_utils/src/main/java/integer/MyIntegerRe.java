package integer;

/**
 * @author baiyang
 * @date 2020/9/9
 */
public class MyIntegerRe {

    /*
    对于 Integer var = ? 在-128 至 127 范围内的赋值，
    Integer 对象是在 IntegerCache.cache 产生，会复用已有对象，
    这个区间内的 Integer 值可以直接使用==进行 判断，但是这个区间之外的所有数据，
    都会在堆上产生，并不会复用已有对象，这是一个大坑， 推荐使用 equals 方法进行判断
     */

    public static void main(String[] args) {
        Integer var_1 = 100;
        Integer var_2 = 100;
        Integer var_3 = 1000;
        Integer var_4 = 1000;
        if (var_1 == var_2){
            System.out.println("1 = 2");
        }
        if (var_3 == var_4){
            System.out.println("3 = 4");
        }
    }
}

package stream;

import java.util.stream.Stream;

/**
 * @author baiyang
 * @date 2020/9/22
 */
public class StreamTest {

    public static void main(String[] args) {
        //对象转流
        Stream.of();

        Stream.generate(()-> "test").limit(5).forEach(System.out::println);
    }

}

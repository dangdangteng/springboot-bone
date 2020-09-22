package map;

import java.util.HashMap;
import java.util.Map;

/**
 * @author baiyang
 * @date 2020/9/21
 */
public class MapToStream {

    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap(16);
        map.put(1, "test");
        map.entrySet().stream().map(s -> s.getKey() + ":" + s.getValue()).forEach(System.out::println);
    }
}

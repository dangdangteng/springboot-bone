package stream;

import stream.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author baiyang
 * @date 2020/12/17
 */
public class ListToMapStream {
    /**
     * ## stream 流转换问题
     *
     * ```
     * Map<String, String> map = list.stream().collect(Collectors.toMap(s -> s[2], s -> s[1], (oldValue,newValue)->newValue)));
     * ```
     *
     * //出现重复时，存放最后一次的value,此处可以根据需求自行处理；
     * @param args
     */

    public static void main(String[] args) {
        List<UserEntity> list = new ArrayList();
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setName("test");
        UserEntity userEntity1 = new UserEntity();
        userEntity1.setId(1L);
        userEntity1.setName("nihao");
        list.add(userEntity);
        list.add(userEntity1);
        Map<Long, String> collect = list.stream().collect(Collectors.toMap(UserEntity::getId, UserEntity::getName,(o,n)->n));
        System.out.println(collect);
    }

}

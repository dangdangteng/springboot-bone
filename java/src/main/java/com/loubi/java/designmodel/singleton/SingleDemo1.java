package com.loubi.java.designmodel.singleton;

/**
 * @author baiyang
 * @date 2020/12/18
 */
public class SingleDemo1 {
    private static SingleDemo1 singleDemo1;
    public static SingleDemo1 getInstance(){
        if (singleDemo1 == null){
            singleDemo1 = new SingleDemo1();
        }
        return singleDemo1;
    }
}

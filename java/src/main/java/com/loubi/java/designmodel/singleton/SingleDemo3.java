package com.loubi.java.designmodel.singleton;

/**
 * @author baiyang
 * @date 2020/12/18
 */
public class SingleDemo3 {

    private static SingleDemo3 singleDemo3;

    public static synchronized SingleDemo3 getInstance(){
        if (singleDemo3 == null){
            singleDemo3 = new SingleDemo3();
        }
        return singleDemo3;
    }

}

package com.loubi.java.designmodel.singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author baiyang
 * @date 2020/12/18
 */
public class SingleDemo {

    private static Logger log = LoggerFactory.getLogger(SingleDemo.class);

    private static SingleDemo singleDemo = new SingleDemo();

    public static SingleDemo getInstance(){
        log.info("single is getInstance()");
        if (singleDemo != null){
            return singleDemo;
        }
        return singleDemo;
    }

    public static void create(){
        System.out.println("-----");
    }

    public SingleDemo() {
        System.out.println("single is create!");
    }
}

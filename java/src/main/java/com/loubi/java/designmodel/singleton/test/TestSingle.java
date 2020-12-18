package com.loubi.java.designmodel.singleton.test;


import com.loubi.java.designmodel.singleton.SingleDemo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author baiyang
 * @date 2020/12/18
 */
public class TestSingle {

    private static final Logger log = LoggerFactory.getLogger(TestSingle.class);

    @Test
    private void test1(){
        SingleDemo.create();
    }

}

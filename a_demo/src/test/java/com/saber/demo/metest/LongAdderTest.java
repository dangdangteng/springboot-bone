package com.saber.demo.metest;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author baiyang
 * @date 2020/8/26
 */
public class LongAdderTest {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        System.out.println(longAdder);
    }
}

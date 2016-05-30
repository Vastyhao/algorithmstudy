package com.vastyhao.algorithmstudy.util;

/**
 * 用于测试Util类
 * Created by Vastyhao on 2016/5/30.
 */
public class UtilTest {

    public static void main(String[] args) {
        int[] input = InputUtil.createIntInput(20, 0, 100);
        PrintUtil.printIntArray(input, "Test InputUtil#createIntInput");
    }
}

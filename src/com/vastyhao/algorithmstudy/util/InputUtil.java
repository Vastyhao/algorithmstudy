package com.vastyhao.algorithmstudy.util;

/**
 * 输入工具类
 * Created by Vastyhao on 2016/5/30.
 */
public class InputUtil {

    /**
     * 制造一个int数组作为输入
     * @param amount 数组中数字的数量
     * @param min    最小值
     * @param max    最大值
     * @return       int数组
     */
    public static int[] createIntInput(int amount, int min, int max) {
        int[] a = new int[amount];
        for (int i = 0; i < amount; i++) {
            a[i] = (int) (min + (Math.random() * (max - min)));
        }
        return a;
    }

    /**
     * 获取一个随机数
     * @param min 最小值
     * @param max 最大值
     * @return 范围内的一个随机数
     */
    public static int createRandom(int min, int max) {
        int[] random = createIntInput(1, min, max);
        return random[0];
    }
}

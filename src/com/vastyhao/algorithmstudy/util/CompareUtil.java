package com.vastyhao.algorithmstudy.util;

import com.vastyhao.algorithmstudy.sort.BubbleSort;

/**
 * 比较工具类
 * Created by Vastyhao on 2016/6/2.
 */
public class CompareUtil {

    /**
     * 获取一串数组中最大的一个
     * @param array 数组
     * @return      最大的一个
     */
    public static int getBiggestInt(int[] array) {
        int[] a = array.clone();
        BubbleSort.sortIntArrayDesc(a);
        return a[0];
    }
}

package com.vastyhao.algorithmstudy.sort;

/**
 * 冒泡排序
 * Created by Vastyhao on 2016/5/30.
 */
public class BubbleSort {

    /**
     * 冒泡排序int数组,降序输出
     * @param arr int数组输入
     */
    public static void sortIntArrayDesc(int arr[]) {
        int temp;
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1;  j < length; j++) {
                if (arr[i] < arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}

package com.vastyhao.algorithmstudy.bookdemo.dsaa;


import com.vastyhao.algorithmstudy.sort.BubbleSort;
import com.vastyhao.algorithmstudy.util.InputUtil;
import com.vastyhao.algorithmstudy.util.PrintUtil;


/**
 * 数据结构与算法分析， 引论， 相关demo
 * 问题描述：
 * 一、给一堆数， 然后找到其中第k大的数。 书中给了两种思路，作者认为这两个都在一定大小的输入后，变得非常慢。
 * 1. 将这k个数做排序， 返回第k个。
 * 2. 将给一个k大小的数组，然后一个一个过，比第k个大的，放到合适的地方，同时挤出最小的一个。
 *
 * Created by Vastyhao on 2016/5/30.
 */
public class Chapter0 {

    public static void main(String[] args) {
        int[] inputArray = InputUtil.createIntInput(10, 1, 10);
        int[] cloneInput1 = inputArray.clone();
        int outputBySort = retrieveBiggestKBySort(cloneInput1, 5);
        PrintUtil.printIntArray(cloneInput1, "cloneInput1 should be sorted");
        PrintUtil.println("" + outputBySort, "排序方式得到的第k大的数");
        int[] cloneInput2 = inputArray.clone();
        PrintUtil.printIntArray(cloneInput2, "cloneInput2");
    }

    /**
     * 通过冒泡排序获取第k大的数
     * @param arr 输入数组
     * @return    第k大的数
     */
    private static int retrieveBiggestKBySort(int arr[], int k) {
        BubbleSort.sortIntArrayDesc(arr);
        return arr[k-1];
    }

    private static int retrieveBiggestKByBuffer(int arr[], int k) {
        int[] buffer = new int[k];
        //读入前k个
        for (int i = 0; i < k; i++) {
            buffer[i] = arr[i];
        }
        //冒泡排序前k个
        BubbleSort.sortIntArrayDesc(buffer);
        //比里面大的进入到合适的位置，并出去一个最小的
        //TODO ADD IMPL
        return arr[k];
    }

}

package com.vastyhao.algorithmstudy.bookdemo.dsaa;


import com.vastyhao.algorithmstudy.sort.BubbleSort;
import com.vastyhao.algorithmstudy.util.InputUtil;
import com.vastyhao.algorithmstudy.util.PrintUtil;


/**
 * 数据结构与算法分析， 引论， 相关demo
 *
 * 问题描述：
 * 一、给一堆数， 然后找到其中第k大的数。 书中给了两种思路，作者认为这两个都在一定大小的输入后，变得非常慢。
 * 1. 将这m个数做排序， 返回第k个。
 * 2. 将给一个m大小的数组，然后一个一个过，比第m个大的，放到合适的地方，同时挤出最小的一个。
 * 实现起来感觉没有本质区别， 因为第二个在做k个buffer的时候需要排序， 做后面插入的时候，依然需要排序。
 * 而这两种方式在巨大的输入量和k值较大的时候，都非常慢。 作者说明，在第七章的时候来解决这个问题。
 *
 * 二、 在一个n * m的字母方格中找英文单词（有一个对应的字典）。字母的方向可以是对角线，水平线，竖直线上的任何方向。
 * 解法1. 对字典中 的每一个单词，去遍历每一个有序的三元数组(行、列、方向)，看看是否有这个单词。    8 * n * m * q ???
 * 解法2. 差不多， 考虑四元数组(行、列、方向、字符个数)，看看这个单词是不是在字典中； 如果字典中最大的单词长度已知，
 *       可以缩短点速度。 （个人认为， 实际上是一样的， 单词固定，遍历图表和 图表固定一个， 遍历字典 都是一样的。。。。 只是多了一维而已）
 *这两个方法，在字典很大、 图表也很大的情况下，同样也很耗费时间。
 *
 * Created by Vastyhao on 2016/5/30.
 */
public class Chapter1 {

    public static void main(String[] args) {
        executeMBiggest();
    }

    private static void executeMBiggest() {
        int[] inputArray = InputUtil.createIntInput(10, 1, 10);
        int[] cloneInput1 = inputArray.clone();
        int[] cloneInput2 = inputArray.clone();
        int outputBySort = retrieveBiggestMBySort(cloneInput1, 5);
        int outputByKBuffer = retrieveBiggestMByBuffer(cloneInput2, 5);

        PrintUtil.printIntArray(inputArray, "原数组");
        PrintUtil.println("" + outputBySort, "排序方式结果");
        PrintUtil.println("" + outputByKBuffer, "m长度数组缓存方式结果");
    }

    /**
     * 通过冒泡排序获取第m大的数
     * @param arr 输入数组
     * @param m   需要第几大
     * @return    第m大的数
     */
    private static int retrieveBiggestMBySort(int arr[], int m) {
        BubbleSort.sortIntArrayDesc(arr);
        return arr[m-1];
    }

    /**
     * 通过设置m长度的数组来做计算
     * @param arr   原数组
     * @param m     需要第几大
     * @return      第m大的数
     */
    private static int retrieveBiggestMByBuffer(int arr[], int m) {
        int[] buffer = new int[m];
        //读入前k个
        for (int i = 0; i < m; i++) {
            buffer[i] = arr[i];
        }
        //冒泡排序前m个
        BubbleSort.sortIntArrayDesc(buffer);
        //比里面大的进入到合适的位置，并出去一个最小的
        for (int i = m; i < arr.length; i++) {
            if (arr[i] > buffer[m-1]) {
                for (int j = 0; j < m; j++) {
                    if (arr[i] > arr[j]) {
                        for (int k = m - 1; k > j; k--) {
                            arr[k] = arr[k-1];
                        }
                        arr[j] = arr[i];
                    }
                }
            }
        }
        return arr[m];
    }

}

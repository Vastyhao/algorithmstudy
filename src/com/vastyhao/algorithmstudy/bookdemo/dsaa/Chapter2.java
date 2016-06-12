package com.vastyhao.algorithmstudy.bookdemo.dsaa;

import com.vastyhao.algorithmstudy.sort.BubbleSort;
import com.vastyhao.algorithmstudy.util.CompareUtil;
import com.vastyhao.algorithmstudy.util.InputUtil;
import com.vastyhao.algorithmstudy.util.PrintUtil;

/**
 * 第二章  算法分析
 * 主要评估:
 * 1. 如何估计一个程序的运行时间
 * 2. 如何将一个程序的运行时间从天降到秒
 * 3. 粗心使用递归的后果
 * 4. 将一个数自乘得到其幂，以及求两个数的最小公因数的非常有效的方法
 *
 * 题目一： 给定一串整数（可能为负）A1, A2, A3, A4...., 求 从i加到k的 最大值。
 *         例如： -2， 11， -4， 13， -2，-5    最大值为   2 ~ 4   20
 *
 * Created by Vastyhao on 2016/5/31.
 */
public class Chapter2 {

    public static void main(String[] args) {
        int[] input = InputUtil.createIntInput(1000, -1000, 1000);
        PrintUtil.printIntArray(input, "用于求最大子序列输入");

        //用于最大子序列
        int[] copyInput1 = input.clone();
        int[] copyInput2 = input.clone();
        int[] copyInput3 = input.clone();
        int[] copyInput4 = input.clone();

        PrintUtil.printCurrentSystemMills();
        PrintUtil.println("" + maxSubSum1(copyInput1), "采用3次循环，依次计算， 的方式求得的最大值");
        PrintUtil.printCurrentSystemMills();
        PrintUtil.println("" + maxSubSum2(copyInput2), "改进3次循环，每次计算子串长度为之前的一个更小子串，加上一个最新的一个数字， 变成两次循环");
        PrintUtil.printCurrentSystemMills();
        PrintUtil.println("" + maxSubSumRec(copyInput3, 0, copyInput3.length - 1), "递归左边右边中间， 获取结果");
        PrintUtil.printCurrentSystemMills();
        PrintUtil.println("" + maxSubSum4(copyInput4), "直接遍历，得到的结果");
        PrintUtil.printCurrentSystemMills();

        //用于折半查找
        int[] binarySearchArray = InputUtil.createIntInput(10, -10, 10);
        int searchNum = InputUtil.createRandom(-10, 10);
        BubbleSort.sortIntArrayDesc(binarySearchArray);
        PrintUtil.printIntArray(binarySearchArray, "折半查找输入, 在里面查找数字： " + searchNum);
        PrintUtil.println("查找出来索引" + binarySearch(binarySearchArray, searchNum), "折半查找结果为");
    }

    /**
     * 采用挨次计算子序列和的方式， 来比较，3次for循环。
     * @param input 输入
     * @return 最大值
     */
    public static int maxSubSum1(int[] input) {
        int maxSum = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = i; j < input.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += input[k];
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 这是对上面的算法的一个改进： 上面这个算法的 很多序列的计算是重复的， 比如 1~5的计算 可以是 1~4 + 5而不需要重新计算。
     *
     * @param input
     * @return
     */
    public static int maxSubSum2(int[] input) {
        int maxSum = 0;
        for (int i = 0; i < input.length; i++) {
            int sum = 0;
            for (int j = i; j < input.length; j++) {
                sum += input[j];
                if (maxSum < sum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }

    /**
     * 使用递归，求得input数组中的 left开始 到 right结束 最大的子序列和
     * @param input   输入
     * @param left    开始索引
     * @param right   结束索引
     * @return        left开始到right 中的最大子序列
     */
    public static int maxSubSumRec(int[] input, int left, int right) {
        //base case
        if (left == right) {
            return input[left] > 0 ? input[left] : 0;
        }
        int center = (left + right) / 2;
        int leftMaxSum = maxSubSumRec(input, left, center);
        int rightMaxSum = maxSubSumRec(input, center + 1, right);
        int maxCenterLeftSum = 0;
        int centerLeftSum = 0;
        for (int i = center; i >= left; i--) {
            centerLeftSum += input[i];
            if (centerLeftSum > maxCenterLeftSum) {
                maxCenterLeftSum = centerLeftSum;
            }
        }
        int maxCenterRightSum = 0;
        int centerRightSum = 0;
        for (int i = center + 1; i <= right; i++) {
            centerRightSum += input[i];
            if (centerRightSum > maxCenterRightSum) {
                maxCenterRightSum = centerRightSum;
            }
        }
        int centerMaxSum = maxCenterLeftSum + maxCenterRightSum;
        return CompareUtil.getBiggestInt(new int[] {leftMaxSum, rightMaxSum, centerMaxSum});
    }

    /**
     * 可以考虑如下的因素：
     * 1. 如果a[i]为负数，那么这个数，不可能是最大子序列的开头
     * 2. 如果一串子串为负数，那么这个子串，不可能为最大子序列的开头，
     * 3. 如果推进过程中，a[i] ~ a[j-1] 不为负数， a[i] ~ a[j]为负数，那么可以 直接从a[j+1] 开始推进。
     *    因为从a[i] ~ a[p]必然为正数， 所以 a[p+1] ~ a[j]必然为负数。
     * @param input 输入
     * @return      最大值
     */
    public static int maxSubSum4(int[] input) {
        int maxSum = 0;
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
            if (sum > 0) {
                if (sum > maxSum) {
                    maxSum = sum;
                }
            } else {
                sum = 0;
            }
        }
        return maxSum;
    }

    /**
     * 折半查找：给定已经排序的数组和一个数字，如果已经存在在这个数组中，那么返回索引。否则返回-1
     * @param descArray 排序好的数组
     * @param num       数字
     * @return          序列
     */
    public static int binarySearch(int[] descArray, int num) {
        int left = 0;
        int right = descArray.length - 1;
        int compare = (left + right) / 2;
        while (left <= right) {
            if (descArray[compare] == num) {
                return compare;
            } else if (descArray[compare] < num) {
                right = compare - 1;
            } else {  //descArray[compare] > num
                left = compare + 1;
            }
            compare = (left + right) / 2;
        }
        return -1;
    }
}

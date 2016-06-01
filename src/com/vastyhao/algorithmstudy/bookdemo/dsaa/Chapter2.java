package com.vastyhao.algorithmstudy.bookdemo.dsaa;

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
        int[] input = InputUtil.createIntInput(20, -20, 20);
        PrintUtil.printIntArray(input, "用于求最大子序列输入");

        int[] copyInput1 = input.clone();
        int[] copyInput2 = input.clone();
        int[] copyInput3 = input.clone();
        int[] copyInput4 = input.clone();

        PrintUtil.println("" + maxSubSum1(copyInput1), "采用3次循环，依次计算， 的方式求得的最大值");
        PrintUtil.println("" + maxSubSum2(copyInput2), "改进3次循环，每次计算子串长度为之前的一个更小子串，加上一个最新的一个数字， 变成两次循环");
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
}

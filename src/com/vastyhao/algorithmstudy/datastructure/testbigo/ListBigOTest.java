package com.vastyhao.algorithmstudy.datastructure.testbigo;

import com.vastyhao.algorithmstudy.util.InputUtil;
import com.vastyhao.algorithmstudy.util.PrintUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 表的大O（时间复杂度）测试
 * Created by Vastyhao on 2016/6/16.
 */
public class ListBigOTest {

    public static void main(String[] args) {
        deleteEvenNum();
    }

    /**
     * 题目为： 从一个表中删除掉所有偶数， 例如 1,2,4,5,3,2,5  ; 执行完以后，会是 1,5,3,5。
     * 这里采用两种策略： 1. ArrayList， N平方的复杂度  2. LinkedList的迭代器方案， N的复杂度
     */
    private static void deleteEvenNum() {

        Integer[] input1 = InputUtil.createIntegerInput(10000, 1, 10);
        Integer[] input2 = InputUtil.createIntegerInput(20000, 1, 10);
        Integer[] input4 = InputUtil.createIntegerInput(40000, 1, 10);
        ArrayList<Integer> arrayList1 = InputUtil.asArrayList(input1);
        ArrayList<Integer> arrayList2 = InputUtil.asArrayList(input2);
        ArrayList<Integer> arrayList4 = InputUtil.asArrayList(input4);
        LinkedList<Integer> linkedList1 = InputUtil.asLinkedList(input1);
        LinkedList<Integer> linkedList2 = InputUtil.asLinkedList(input2);
        LinkedList<Integer> linkedList4 = InputUtil.asLinkedList(input4);

        deleteEvenNumByArrayList(arrayList1);
        deleteEvenNumByLinkedList(linkedList1);

        deleteEvenNumByArrayList(arrayList2);
        deleteEvenNumByLinkedList(linkedList2);

        deleteEvenNumByArrayList(arrayList4);
        deleteEvenNumByLinkedList(linkedList4);
    }

    private static void deleteEvenNumByArrayList(ArrayList<Integer> inputList) {
        int initSize = inputList.size();
        long startMillis = System.currentTimeMillis();
        for (int i = 0; i < inputList.size(); ) {
            if (inputList.get(i) % 2 == 0) {
                inputList.remove(i);
            } else {
                i++;
            }
        }
        PrintUtil.printPassedMillis("deleteEvenNumByArrayList 结束执行, 初始大小为" + initSize, startMillis);
        PrintUtil.println("" + inputList.size(), "deleteEvenNumByArrayList结束后的大小");
    }

    private static void deleteEvenNumByLinkedList(LinkedList<Integer> inputList) {
        int initSize = inputList.size();
        long startMillis = System.currentTimeMillis();
        Iterator it = inputList.iterator();
        while(it.hasNext()) {
            Integer e = (Integer) it.next();
            if (e % 2 == 0) {
                it.remove();
            }
        }
        PrintUtil.printPassedMillis("deleteEvenNumByLinkedList 结束执行, 初始大小为" + initSize, startMillis);
        PrintUtil.println("" + inputList.size(), "deleteEvenNumByArrayList结束后的大小");
    }


}

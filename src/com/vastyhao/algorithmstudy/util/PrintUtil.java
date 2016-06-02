package com.vastyhao.algorithmstudy.util;

/**
 * 打印Util
 * Created by Vastyhao on 2016/5/30.
 */
public class PrintUtil {


    /**
     * 打印一个String到控制台
     * @param s String
     */
    public static void println(String s) {
        System.out.println(s);
    }

    public static void println(String s, String tag) {
        println("");
        println("<------------------Begin print TAG ： " + tag + "------------------------>");
        println(s);
        println("<--------------------END print TAG ： " + tag + "------------------------>");
    }

    /**
     * 打印一个int数组
     * @param a    int数组
     * @param tag  该数组的tag
     */
    public static void printIntArray(int a[], String tag) {
        println("");
        println("<------------------Begin print int array ： " + tag + "------------------------>");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if (i < a.length - 1) {
                sb.append(", ");
            }
        }
        println(sb.toString());
        println("<-------------------End print int array ： " + tag + "------------------------>");
    }

    public static void printCurrentSystemMills() {
        println("现在的时间为： " + System.currentTimeMillis());
    }
}

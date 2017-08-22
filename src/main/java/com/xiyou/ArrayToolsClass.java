package com.xiyou;

/**
 * 数组工具类
 *
 * @author cc
 * @create 2017-08-22-10:48
 */

public class ArrayToolsClass {
    public static void swap(int[] array , int i , int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void reverse (int[] array , int left , int right){
        if (left > right){
            System.out.println("参数有误！");
        }
        for (int i = left , j = right ; i < j ; i++ , j--) {
            swap(array, i, j);
        }
    }
    public static void PrintArray (int[] array){
        for (int number : array){
            System.out.print(number + " ");
        }
        System.out.println();
    }
}

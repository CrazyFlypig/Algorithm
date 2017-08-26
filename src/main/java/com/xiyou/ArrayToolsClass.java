package com.xiyou;

import java.util.Random;

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
    public static boolean CheckInvalidArray(int[] numbers,int length){
        boolean flag = false;
        if (numbers == null || length <= 0){
            flag = true;
        }
        return flag;
    }
    public static int getRandom (int min, int max){
        Random random = new Random();
        int result = random.nextInt(max)%(max-min+1) + min;
        return result;
    }
}

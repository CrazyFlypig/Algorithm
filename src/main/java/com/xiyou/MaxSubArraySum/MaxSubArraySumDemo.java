package com.xiyou.MaxSubArraySum;

/**
 * 最大字段和
 *
 * @author cc
 * @create 2017-08-22-15:35
 *  给定由n个整数（包括负整数）组成的序列a[1],a[2],...,a[n]，求该序列形如 a[i],a[i+1],...,a[j]的字段和的最大值。
 */

public class MaxSubArraySumDemo {
    public static void main(String[] args) {
        int[] data = {-2,-11,-4,-13,-5,-2};
        int[] data1 = {1,-2,3,10,-4,7,2,-5};
//        int result = MathWay(data);
        int result = DPWay(data);
        System.out.println(result);
    }
    /**
     * 如果现在数字是负数并且此时的子数组和大于之前的子数组和。则保存此时数据。
     * 继续累加子数组求和
     * 如果累加之后的和小于0，则舍弃之前的子数组。将此时的元素作为子数组起始。
     *
     * 如果需要记录下标值，则存在问题。
     * @param array
     * @return
     */
    public static int MathWay(int[] array) {
        if (array==null || array.length <= 0){
            return Integer.MIN_VALUE;
        }
        int sum = 0;
        int max = array[0];
        for (int i = 0 ; i < array.length ; i++){
            if (sum < 0){
                sum = array[i];
            }else {
                sum += array[i];
            }
            if (sum > max){
                max =sum;
            }
        }
        return max;
    }

    /**
     *  动态规划法
     * @param array
     * @param length
     * @return
     */
    public static int DPWay(int[] array){
        if (array==null || array.length <= 0){
            return Integer.MIN_VALUE;
        }
        int max = array[0];
        int sum = 0;
        for (int i = 0 ; i < array.length ; i++){
            if (sum > 0){
                sum += array[i];
            }else {
                sum = array[i];
            }
            if (sum > max){
                max = sum;
            }
        }
        return max;
    }
}

package com.xiyou.KnapsackProblem;

/**
 * 0-1背包问题
 *
 *  问题描述：给定一组物品，每种物品都有自己的重量和价格，在限定的总重量内，我们如何选择，才能使得物品的总价格最高。
 * @author cc
 * @create 2017-08-23-16:54
 */

public class Knapsack_0_1 {
    public static void main(String[] args) {
        int[] weight = {5, 3, 2, 10, 4, 8};
        int[] value = {4, 8, 15, 1, 6, 3};
        int n = weight.length;
        int C = 20;
        int out = DPGetMaxValue(n-1,weight,value,C);
        System.out.println(out);
    }

    /**
     *  动态规划解决0-1背包问题：
     *      将n个物品作为n个阶段，第n阶段的最大值就等于第n-1阶段最大值加上第n的阶段的决策值，依次向前迭代，直至第一阶段，返回第一阶段的决策值。
     */
    public static int DPGetMaxValue(int n , int[] w , int[] v , int c){
        int maxV1 , maxV2;
        int out;
        if (n == 0){
            if (c < w[n])
                out = 0;
            else out = v[n];
            return out;
        }
        maxV1 = maxV2 = DPGetMaxValue(n-1,w,v,c);
        if (c >= w[n])
            maxV2 = v[n] + DPGetMaxValue(n-1,w,v,c - w[n]);
        if (maxV1 >= maxV2)
            out = maxV1;
        else out = maxV2;
        return out;
    }
}

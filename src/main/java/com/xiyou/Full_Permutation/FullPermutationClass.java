package com.xiyou.Full_Permutation;

import com.xiyou.ArrayToolsClass;

/**
 * 全排列
 *
 * @author cc
 * @create 2017-08-22-10:40
 */

public class FullPermutationClass {
    public static int count = 0;
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9};
        int length = array.length;
        long start = System.currentTimeMillis();
        RecursionGet(array,length);
        System.out.println(System.currentTimeMillis()-start);
        System.out.println(count);

    }
    /**
     * 假设有n个元素的数组：
     *      先固定数组首位，将后n-1个元素依次与第一个元素交换。每次求后n-1个元素的全排列。
     *  递归调用此过程，边界条件为当 n-1 = 1 时，输出并返回。
     *  问题：
     *  1. 若i从left+1开始 且 只使用递归后的交换，理论可行，但因为 i = right 时交换完成后会跳出循环，所以解决了这个问题就可以正常使用。
     *  2. 递归之后的swap()函数的作用： 为了使数组返回初始状态，避免递归过程中的元素重复交换。
     *  例：1，2，3的过程{1，2，3}，{1，3，2}，（交换0，1）{3，1，2}，{3，2，1}，（交换0，2）{1，3，2}，{1，2，3}。一个交换，存在错误。
     *
     * @param array
     * @param length
     */
    public static void RecursionGet (int[] array , int length){
        PermRecursion(array,0,length-1);
    }
    public static void PermRecursion (int[] array , int left , int right){
        if (right < left){
            return;
        }
        if (left == right){
            ArrayToolsClass.PrintArray(array);
            count++;
        }
        int i;
        for (i = left ; i <= right ; i++){
            ArrayToolsClass.swap(array,i,left);
            PermRecursion(array,left+1,right);
            ArrayToolsClass.swap(array,left,i);
        }
    }

    /**
     * 字典序法
     * 字典序，就是将元素按照字典的顺序（a-z, 1-9）进行排列。以字典的顺序作为比较的依据，可以比较出两个串的大小。
     * 例；1，2，3的字典序是{1，2，3}，{1，3，2}，{2，1，3}，{2，3，1}，{3，1，2}，{3，2，1}
     * 算法步骤：
     *      1. 从排列右端开始，找出第一个比右边相邻数字小的数字的序号，记作j。注意数组越界问题。
     *      2. 如果 j <= -1 ，则说明排列已是最大串，退出循环。
     *      3. 找出（n,j)中最右边的元素大于data[j]的数字,下标记作k。
     *      4. 交换j,k的值。
     *      5. 逆秩j后面的数组。
     *      6. 输出数组。
     *   循环上述步骤，直至排列变有序。
     * @param array
     * @param length
     */
    public static void DictionSequence(int[] array , int length){
        ArrayToolsClass.PrintArray(array);
        count++;
        int j,k;
        boolean flag = true;
        while (flag){
            flag = false;
            for (j = length-2 ; j >= 0 && array[j] >= array[j+1] ; j--);
            if ( j > -1){
                for (k = length-1 ; k > j && array[k] <= array[j] ; k--);
                flag = true;
                ArrayToolsClass.swap(array , j , k);
                if (j+1 < length){
                    ArrayToolsClass.reverse(array,j+1,length-1);
                }
                ArrayToolsClass.PrintArray(array);
                count++;
            }
        }
    }
}

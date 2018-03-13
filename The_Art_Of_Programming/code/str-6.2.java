/**
     *  字典序法
     *  思路：首先获取一个字符串的最小字典序（即按升序排列字符数组），然后从右向左找出第一个非升序元素，如data[i]<data[i+1].
     *      然后找出其右边和它相差最小的较大值，交换二者位置，然后反转非升序元素后面的序列。循环上述过程直至字符串为
     *      最大字典序串。
     * @param str
     */
    public static void calcAllPermutation(char[] str){
        boolean flag = true;
        //获取最小字典序，并打印它
        Arrays.sort(str);
        printStr(str);
        System.out.println();
        while (flag){
            flag = false;
            int left,right;
            left = right = 0;
            //查找非升序元素
            for (int i = str.length-1 ; i > 0 ; i--){
                if (str[i] > str[i-1]){
                    left = i-1;
                    break;
                }
            }
            //查找须交换元素
            for (int i = str.length-1 ; i > left ; i--){
                if (str[i] > str[left]){
                    right = i;
                    break;
                }
            }
            //交换、反转
            if (left < right){
                flag = true;
                swap(str, left, right);
                reverse(str, left+1, str.length-1);
                printStr(str);
                System.out.println();
            }
        }
    }
    public static void printStr(char[] str){
        for (char c: str){
            System.out.print(c + " ");
        }
    }
    public static void swap(char[] str, int i, int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
    public static void reverse(char[] str, int start, int end){
        for (int i=start, j=end ; i < j ; i++, j--){
            swap(str, i, j);
        }
    }
}
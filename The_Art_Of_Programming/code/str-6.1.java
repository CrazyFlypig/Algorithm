 /**
     *  递归求解全排列
     *      思路：固定第一个字符，求解剩余字符串的全排列。递归结束条件：固定到最后一个字符串时，输出结果
     * @param str 目标字符串
     * @param start 字符串起始位置
     * @param end 字符串结束位置
     */
    public static void calcAllPermutation(char[] str, int start, int end){
        if (str == null || start > end || end < 1){
            return;
        }
        if (start == end){
            printStr(str);
            System.out.println();
        }else {
            for (int i = start ; i <= end ; i++){
                swap(str, start, i);
                calcAllPermutation(str, start+1, end);
                swap(str, start, i);
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
}
public class Main  {
    public static void main(String[] args) {
       String str = "12212321";
       char[] chars = str.toCharArray();
       int length = str.length();
       int result = longestPalindrome(str);
       System.out.println(result);
    }

    /**
     *  解法一
     *      复杂在于区分字符串个数的奇偶。时间复杂度：O(n^2)
     * @param chars 输入字符数组
     * @param length 字符数组长度
     * @return 最长回文字串长度
     */
    public static int longestPalindrome(char[] chars, int length){
        int max,c;
        max = 0;
        c = 0;
        if (chars == null || length < 1){
            return max;
        }
        for (int i = 0 ; i < length ; i++){
            if (length%2 == 1){
                //奇数个字符串
                for (int j = 0 ; i-j > 0 && i+j < length ; j++){
                    if (chars[i-j] != chars[i+j])
                        break;
                    c = j * 2 + 1;
                }
            }else {
                //偶数个字符串
                for (int j = 0 ; i-j > 0 && i+j+1 < length ; j++){
                    if (chars[i-j] != chars[i+j+1])
                        break;
                    c = j * 2 + 2;
                }
                if (max == 0){
                    max = 1;
                }
            }
            if (max < c){
                max = c;
            }
        }
        return max;
    }

    /**
     *  解法二
     *  空间复杂度：O(n)
     *  时间复杂度：由于内层的循环只对尚未匹配的部分进行，因此对于每一个字符而言，只会进行一次，因此时间复杂度是O(n)。
     *
     *  int[] palindromeValue：存放新字符串以对应位置为中心的回文串半径
     *  int maxRight：回文串的最右边界
     *  int pos：以maxRight为回文最右端的回文串中心
     *  int max：最长回文串的字符数
     *  int c：当前回文串的半径
     */
    public static int longestPalindrome(String str){
        char[] oldStr = str.toCharArray();
        int odlLength = oldStr.length;
        //构造奇数个字符串
        char[] newStr = new char[odlLength + odlLength + 2];
        int newLength = newStr.length;
        newStr[0] = '$';
        int num = 0;
        for (int i = 1 ; i < newLength ; i++){
            if (i%2 == 1)
                newStr[i] = '#';
            else newStr[i] = oldStr[num++];
        }
        //P[i]-1正好是原字符串中回文串的总长度
        int[] palindromeValue = new int[newStr.length];
        int pos, maxRight, max, c;
        pos = maxRight = max = c = 0;
        for (int i = 1 ; i < newLength ; i++){
            //i在max的右边，则便开始从i的两边找起
            if (i > maxRight){
                for (int j = 0 ; i-j > 0 && i+j < newLength ; j++){
                    if (newStr[i-j] != newStr[i+j])
                        break;
                    c = j + 1;
                    maxRight = i + j;
                }
                pos = i;
                palindromeValue[i] = c;
            }else {
                int n = i - (i-pos)*2;
                c = Math.min(palindromeValue[n], maxRight-i+1);//之前存在理解有误
                for (int j = c ; i-j>0 && i+j<newLength ; j++){
                    if (newStr[i-j] != newStr[i+j])
                        break;
                    c = j + 1;
                    if (i+j > maxRight){
                        maxRight = i+j;
                        pos = i;
                    }
                }
                palindromeValue[i] = c;
            }
        }
        for (int item : palindromeValue){
            if (max < item)
                max = item;
        }
        return max-1;
    }
}
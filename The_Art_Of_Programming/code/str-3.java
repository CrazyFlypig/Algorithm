public class Main  {
    public static void main(String[] args) {
       String str = "123458966564656";
       int result = stringToInt(str);
        System.out.println(result);
    }
    /**
     * sign用来处理数字的正负，当为正时sign > 0，当为负时sign < 0
     * n存放最终转换后的结果
     * c表示当前数字
     *
     * @param str 需要进行转换的字符串
     * @return number
     */
    public static int stringToInt(String str){
        int sign = 1;
        int c = 1;
        int n ,i;
        int num = Integer.MAX_VALUE;
        //判断是否空指针异常
        if (str == null || str.equals("")){
            System.out.println("输入字符串有误！");
            System.exit(-1);
        }
        //判断是否为负，更改最值
        if (str.startsWith("-")){
            str = str.substring(1, str.length());
            sign = -1;
            c = -1;
            num = Integer.MIN_VALUE;
        }
        char[] chars = str.toCharArray();
        c *= chars[0] - '0';
        for (i = 1 ; i < chars.length ; i++){
            c = c*10 + (chars[i]- '0')*sign;
            if ((sign > 0 && c > num/10) || (sign < 0 && c < num/10)){
                break;
            }
        }
        if (i == chars.length){
            n = c;
        }else
            n = num;
        return n;
    }
}
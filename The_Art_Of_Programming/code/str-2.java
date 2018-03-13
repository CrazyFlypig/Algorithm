public class Main  {
    public static void main(String[] args) {
        String str1 = "abcdef";
        String str2 = "ce";
        boolean flag = stringContain(str1, str2);
        System.out.println(flag);
    }
    public static boolean stringContain(String str1, String str2){
        char[] strA = str1.toCharArray();
        char[] strB = str2.toCharArray();
        int hash = 0;
        //a|=b的意思就是把a和b按位或然后赋值给a
        for (char c : strA){
            hash |= (1 << (c - 'A'));
        }
        for (char c : strB){
            if ((hash & (1 << (c - 'A'))) == 0)
                return false;
        }
        return true;
    }
}
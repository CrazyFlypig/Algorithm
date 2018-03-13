public class Main  {
    public static void main(String[] args) {
        String str = "abcdefgh";
        str = reverseString(str, 5);
        System.out.println(str + " ");
    }
    public static String reverseString(String str, int num){
        String part1 = str.substring(0, num);
        String part2 = str.substring(num, str.length());
        part1 = reverseString(part1);
        part2 = reverseString(part2);
        str = reverseString(part1 + part2);
        return str;
    }
    public static String reverseString(String str){
        char[] chars = str.toCharArray();
        for (int i = 0, j = chars.length-1 ; i < j ; i++, j--){
            char tmp = chars[i];
            chars[i] = chars[j];
            chars[j] = tmp;
        }
        return new String(chars);
    }
}
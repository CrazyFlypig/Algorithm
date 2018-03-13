 /**
     *  在字符串中删除特定的字符
     * @param sourceStr 源字符串
     * @param targetStr 目标字符串
     * @return 删除后的字符串
     */
    public static String deleteChar(String sourceStr, String targetStr){
        char[] sourceChars = sourceStr.toCharArray();
        char[] targetChars = targetStr.toCharArray();
        Set<Character> characterSet = new HashSet<>();
        //先头指针和主力指针
        int pfast,pslow;
        pfast = pslow = 0;
        for (char c: targetChars){
            characterSet.add(c);
        }
        while (pfast < sourceChars.length){
            if (!characterSet.contains(sourceChars[pfast])){
                sourceChars[pslow] = sourceChars[pfast];
                pslow++;
            }
            pfast++;
        }
        return String.valueOf(sourceChars, 0, pslow);
    }
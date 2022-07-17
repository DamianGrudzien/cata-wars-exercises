public class Kata_5 {
    public static void main(String[] args) {
 //       System.out.println(reverseWords("Word"));
 System.out.println(reverseWords("ehT  kciuq nworb xof spmuj revo eht yzal .god"));
//        System.out.println(reverseWords("Test"));
        System.out.println(reverseWords("      "));
    }

//    public static String reverseWordsStream(final String words) {
//        String reverseWords="";
//        StringBuilder newWords = new StringBuilder().append(words.split(" "));
//        List<StringBuilder> newList =  Stream.of(newWords)
//                .map(word -> word.reverse())
//                .toList();
//        return reversedWords;
//    }

    public static String reverseWords(final String original)
    {
        if(original.isEmpty()){
            return "";
        }
        String reverse = "";
        String tempString = "";
        String tempSpaces = "";

        char[] originalChars = original.toCharArray();
        char previousChar = originalChars[0];
        if(previousChar==' '){
            tempSpaces = " ";
        }
        else{
            tempString += previousChar;
        }

        for(int i = 1;i < originalChars.length+1;i++){
            if(originalChars.length==i){
                if(previousChar == ' '){
                    reverse+= tempSpaces;
                }
                else {
                    reverse += reverseWord(tempString);
                }
            }
            else if(originalChars[i] == ' '){
                if(previousChar == ' '){
                    tempSpaces+=" ";
                }
                else {
                    reverse+= reverseWord(tempString);
                    tempString="";
                    tempSpaces+=" ";
                }
                previousChar = originalChars[i];
            }
            else{
                if(previousChar != ' '){
                    tempString += originalChars[i];
                    previousChar = originalChars[i];
                }
                else {
                    reverse += tempSpaces;
                    tempSpaces = "";
                    tempString += originalChars[i];
                    previousChar = originalChars[i];
                }
            }
        }
        return reverse;

    }

    private static String reverseWord(String string) {
        int length = string.length();
        char[] chars = string.toCharArray();
        for(int i=0; i<length/2; i++) {
            char toReplace = chars[length-1-i];
            chars[length-1-i] = chars[i];
            chars[i] = toReplace;
        }
        string="";
        for(char c : chars){
            string += c;
        }
        return string;
    }


}

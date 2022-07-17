import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Kata_4 {
    public static void main(String[] args) {

        System.out.println("The same amount of XO: xxxooo is: " + XO.getXO("xosdaaxo"));
        System.out.println(noSpace("8aaa aaa aa"));
        System.out.println(camelCase("someStrinGsomeDeD"));
//        System.out.println(filterList(Arrays.asList(new Object[]{1,2,"a","b","2"})));
        String someString = "1231a23";

        boolean isNumeric = someString.chars().allMatch( Character::isDigit );
        System.out.println(isNumeric);
        System.out.println(countBits(12));
        System.out.println(reverseWords("ehT kciuq nworb xof spmuj revo eht yzal .god"));
        System.out.println(reverseWords("god"));
        System.out.println(reverseWords("elbuod  decaps  sdrow"));
        System.out.println(reverseWords("   "));
    }

    public class XO {

        public static boolean getXO (String str) {
//            int X=0;
//            int O=0;
//            String[] stringOfText = str.toUpperCase().replace("[^XO]","").split("");
//            for (String letter: stringOfText){
//                if(letter.equals("X")) X++;
//                else if(letter.equals("O")) O++;
//            }
//            return X==O;
            str.toLowerCase().chars().filter(value -> value == 'x').count();
            return str.toLowerCase().replace("o","").length() == str.replace("x","").length();
        }
    }

    public class ClassScore {
        public static boolean betterThanAverage(int[] classPoints, int yourPoints) {

            return  Arrays.stream(classPoints).average().orElse(0) < yourPoints;
        }
    }
    public static String noSpace(final String x) {
        return x.replace("\s","");    }

    public static String camelCase(String input) {

        List<String> letters = input
                .chars()
                .mapToObj(Character::toString)
                .collect(Collectors.toList());
        letters.replaceAll(value -> Character.isUpperCase(value.charAt(0)) ? " " + value :  value);
        return String.join("", letters);
//        return input.replaceAll("([A-Z])", " $1");
    }

//    public static List filterList(final List list) {
//
//
//        List checkIfLetter = (List) list.stream().filter(value ->).collect(Collectors.toList());
//        System.out.println(checkIfLetter);
//        return checkIfLetter;
//    }

    public static char getGrade(int s1, int s2, int s3) {

        int average = IntStream.of(s1, s2, s3).sum() / 3;
        return getGradeChar(average);
    }

    private static char getGradeChar(int average) {
        if(average>=90&&average<=100)  return 'A';
        else if (average>=80&&average<90) return 'B';
        else if (average>=70&&average<80) return 'C';
        else if (average>=60&&average<70) return 'D';
        else if (average>=0&&average<60) return 'F';
        else  {
            return ' ';
        }
    }
    public static String abbrevName(String name) {
        return Arrays.stream(name.split(" "))
                .map(value -> value.toUpperCase().substring(0,1))
                .collect(Collectors.joining(""));
    }

    public static int getCount(String str) {
        int vowelsCount = 0;
        if(isNullEmpty(str)) return 0;
        String match = "aeiou";
        vowelsCount = (int) Arrays.stream(str.split(""))
                .filter(Objects::nonNull)
                .filter(val -> val.length()!=0)
                .filter(match::contains)
                .count();

        return vowelsCount;
    }
    public static boolean isNullEmpty(String str){
        return str == null || str.length() == 0;
    }
    public static int countBits(int n){
        return Integer.toBinaryString(10).replace("0","").length();
    }

    public static boolean isSquare(int n) {
        int x = (int) Math.round(Math.sqrt(n));
        return x * x == n; // fix me!
    }
    public static String reverseWords(final String original)
    {
        String[] words = original.split("\\s+");
        String[] spaces = original.split("\\S+");
        StringBuilder stringFinal = new StringBuilder();
        if(words.length==0) return original;
        boolean isFirst = true;
        for(int i = 0; i < words.length; i++){
            StringBuilder stringToReverse = new StringBuilder(words[i]);
            if (isFirst){
                stringFinal.append(stringToReverse.reverse());
                isFirst = false;
                continue;
            }
            stringFinal.append(spaces[i]);
            stringFinal.append(stringToReverse.reverse());
        }
        return stringFinal.toString();
    }
}

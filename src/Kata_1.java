import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Kata_1 {
    public static void main(String[] args) {
//        String pangram1 = "The quick brown fox jumpsSSSSSSSSS over the lazy dog.";
//        PangramChecker pc = new PangramChecker();
//        System.out.println(pc.check(pangram1));

//        System.out.printf("Should return true: %s%n",TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
//        System.out.printf("Should return false: %s%n", TenMinWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
//        System.out.printf("Should return false: %s%n", TenMinWalk.isValid(new char[] {'w'}));
//        System.out.printf("Should return false: %s%n", TenMinWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));

//        Boolean[] array1 = {true,  true,  true,  false,
//                true,  true,  true,  true ,
//                true,  false, true,  false,
//                true,  false, false, true ,
//                true,  true,  true,  true ,
//                false, false, true,  true };
//
//        System.out.printf("There are %d sheeps in total: %s", 17, new Counter().countSheeps(array1));

        test(1);
        test(2,2);
        test(2,3,4,3);

    }


    public static void test(Integer a){
        System.out.println("test");
    }

    public static void test(Integer a, Integer b){
        System.out.println("test");
    }
    public static void test(Integer a, Integer b, Integer c){
        System.out.println("test");
    }
    public static void test(Integer... test){
        System.out.println("test");
    }


}
class Bio {
    public String dnaToRna(String dna) {
        dna = Optional.ofNullable(dna)
                .filter(dnaString -> dnaString.length()>0)
                .map(value -> value.replace('T','U'))
                .orElse("");

        return dna;  // Do your magic!
    }
}

class GrassHopper {

    public static int summation(int n) {
        int sumOfInt =0;
        for(int i=1;i<=n;i++){
            sumOfInt+=i;
        }
        return sumOfInt;
    }
}

class TwoToOne {

    public static String longest (String s1, String s2) {
        s1 = s1+s2;
        return s1.chars()
                .distinct()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        //        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
//        return Arrays.stream(s1.split(""))
//                .distinct()
//                .sorted()
//                .collect(Collectors.joining());
    }
}

class Solution {
    public static String repeatStr(final int repeat, final String string) {
        return string.repeat(repeat);
    }
}

class PangramChecker {
    public boolean check(String sentence){
        CharSequence charSequence = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return  charSequence.equals( sentence
                .toUpperCase()
                .replaceAll("[^A-Za-z]","")
                .chars()
                .filter(Objects::nonNull)
                .sorted()
                .distinct()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString());
//        sentence.contains();
//        Arrays.stream(sentence.split("\s"))
//                .filter()
    }
}

class TenMinWalk {
    public static boolean isValid(char[] walk) {
        // Insert brilliant code here
        return walk.length == 10 && returnToPoint(walk);
    }

    private static boolean returnToPoint(char[] walk) {
        int w=0;
        int n=0;
        int s=0;
        int e=0;
        for(char side: walk){
            if(side == 'w'){
                w++;
            } else if(side == 'e'){
                e++;
            } else if(side == 's'){
                s++;
            } else if(side == 'n'){
                n++;
            }
        }
        System.out.println(w);
        System.out.println(n);
        System.out.println(s);
        System.out.println(e);
        return (s-n) == 0 && (w-e)==0;
    }
}

class Counter {
    public int countSheeps(Boolean[] arrayOfSheeps) {
        long trueValue = Stream.of(arrayOfSheeps)
                .filter(value ->  !Optional.ofNullable(value).isEmpty())
                .filter(value -> value == true)
                .count();

        return (int) trueValue;
    }
}

class Maps {
    public static int[] map(int[] arr) {
        IntStream.of(arr).map(value -> value*2).toArray();
        return Arrays.stream(arr).map(value -> value*2).toArray();
    }
}




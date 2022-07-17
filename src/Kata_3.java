import java.util.*;
import java.util.stream.*;

public class Kata_3 {
    public static void main(String[] args) {
//        //DNA STRAND test
//        System.out.printf("TTTT -> AAAA = %s%n", DnaStrand.makeComplement("AAAA"));
//        System.out.printf(" \"\" -> \"\" = %s%n", DnaStrand.makeComplement(""));
//        System.out.printf("TAACG -> ATTGC = %s%n", DnaStrand.makeComplement("ATTGC"));
//        System.out.printf("CATA -> GTAT = %s%n", DnaStrand.makeComplement("GTAT"));

        //Number to sum
//
//      System.out.printf("%d , %d -> %s%n",1,10,SumDigPower.sumDigPow(50L,150L));
//      System.out.printf("%d , %d -> %s%n",1,10,SumDigPower.sumDigPowv2(50L,150L));
//      System.out.println(12345%10+ " " +12345/10 +" "+ 1234%10+ " " +1234/10 );
//      System.out.println(Kata.findShort("bitcoin take over the world maybe who knows perhaps"));
//      System.out.println(Kata.expandedForm(13));
//      System.out.println(Kata.expandedForm(70304));
//
      //DB Linear

//      int testDBLinear = 30;
//      System.out.println("Test: "+testDBLinear + "  is:" + DoubleLinear.dblLinear(testDBLinear));
        System.out.println(Kata2.validSpacing("Hello World"));
        System.out.println(Kata2.validSpacing(" Hello World"));

    }
    class SumDigPower {
        private static List<Long> sumDigPow(long a, long b) {
            List<Long> finalList = new ArrayList<>();
            long currentDigit = a;

            for(long i = a; i<=b;i++) {
                long sum = 0L;
                long copyOfDigit = currentDigit;
                Deque<Long> digitsList = new ArrayDeque<>();
                while (currentDigit > 0) {
                    digitsList.addFirst(currentDigit % 10);
                    currentDigit /= 10;
                }
                int size = digitsList.size();
                for (int j = 0; j < size; j++) {
                    sum = sum + (long) Math.pow(digitsList.pollFirst(), j+1);

                }
                if (sum == copyOfDigit) {
                    finalList.add(copyOfDigit);
                }
                currentDigit = copyOfDigit+1;
                sum=0l;
            }

            System.out.println(finalList);

            return finalList;
            }
        public static List<Long> sumDigPowv2(long a, long b) {
            IntStream.rangeClosed(1,20)
                    .filter(i -> isValidV2(i))
                    .boxed()
                    .collect(Collectors.toList());
            return LongStream.rangeClosed(a, b)
                    .filter(i -> isValid(i))
                    .boxed()
                    .collect(Collectors.toList());
        }
        private static boolean isValidV2(long x){
            String value = Long.toString(x);
            return  IntStream.range(0,value.length())
                    .mapToDouble(i -> Math.pow(Character.getNumericValue(value.charAt(i)) , i + 1))
                    .sum() == x;
        }
        private static boolean isValid(long x){
            String value = Long.toString(x);
            return IntStream.range(0, value.length())
                    .mapToDouble(i -> Math.pow(Character.getNumericValue(value.charAt(i)), i + 1))
                    .sum() == x;
        }
    }

    class DnaStrand {
        public static String makeComplement(String dna) {

            return  Arrays.stream(Optional.ofNullable(dna)
                            .filter(size -> size.length()>0)
                            .orElse("").split(""))
                    .filter(len -> len.length()>0)
                    .map(DnaStrand::replaceChar)
                    .collect(Collectors.joining());
        }
        public static String replaceChar(String charValue) {
            if(charValue.equals("A")){return "T";}
            else if(charValue.equals("T")){return "A";}
            else if(charValue.equals("G")){return "C";}
            else if(charValue.equals("C")){return "G";}
            else {return "";}
        }
    }

    class Kata {
        public static int findShort(String s) {
            return Stream.of(s.split(" "))
                    .mapToInt(String::length)
                    .min()
                    .getAsInt();
        }
        public static String expandedForm(int num)
        {
            CharSequence test = " + ";
            String number = Integer.toString(num);
            return IntStream.rangeClosed(0,number.length()-1)
                    .mapToObj(value -> String.valueOf(bigNumberMaker(value,number)))
                    .filter(value -> !value.equals("0"))
                    .collect(Collectors.joining(" + "));
        }
        public static long bigNumberMaker(int value, String number) {
            double a =  Math.pow(10, number.length() - value - 1);
            long v = Character.getNumericValue(number.charAt(value));
            return (long) (v*a);
        }
    }

    class DoubleLinear {

        public static int dblLinear (int n) {
            List<Integer> setForU = new ArrayList<>();
            Deque<Integer> setOfLeftElement = new ArrayDeque<>();
            int currentNumber = 1;

            for(int i=1; i<n;i++){
                int y = 2 * currentNumber + 1;
                int z = 3 * currentNumber + 1;
                setForU.add(currentNumber);
                setForU.add(y);
                setForU.add(z);
                setOfLeftElement.add(y);
                setOfLeftElement.add(z);
                setOfLeftElement = setOfLeftElement.stream().sorted().collect(Collectors.toCollection(ArrayDeque::new));
                currentNumber = setOfLeftElement.pollFirst();
            }
            int size = setOfLeftElement.size();
            System.out.println(size);
            System.out.println(setOfLeftElement);
            for(int i=0; i<size;i++){
                int y = 2 * currentNumber + 1;
                int z = 3 * currentNumber + 1;
                setForU.add(y);
                setForU.add(z);
                setOfLeftElement = setOfLeftElement.stream().sorted().collect(Collectors.toCollection(ArrayDeque::new));
                currentNumber = setOfLeftElement.pollFirst();
            }
            System.out.println(setForU);
            System.out.println(setForU.stream().count());
            setForU = setForU.stream().distinct().sorted().collect(Collectors.toCollection(ArrayList::new));
            System.out.println(setForU);
//            System.out.println(setOfLeftElement);
            System.out.println(setForU.stream().count());
            return (int) setForU.stream().count();
//
//            List<Double> yList = IntStream.rangeClosed(1, n)
//                    .mapToDouble(value -> (2 * value) + 1)
//                    .boxed()
//                    .toList();
//            System.out.println(yList);
//            List<Double> zList = IntStream.rangeClosed(1, n)
//                    .mapToDouble(value -> (3 * value) + 1)
//                    .boxed()
//                    .toList();
//            System.out.println(zList);
//            List<Double> finalList = new ArrayList<>();
//            finalList.add(1.0);
//            finalList.addAll(Stream.of(zList, yList).flatMap(Collection::stream)
//                    .distinct()
//                    .sorted()
//                    .toList());
//            System.out.println(finalList);
//            yList.addAll(zList);
//            long size = yList.stream().distinct().count();
//            return 22;
        }
    }

    class Bio {
        public String dnaToRna(String dna) {
            return IntStream.rangeClosed(0,dna.length()-1)
                    .mapToObj(value -> doMagic(value,dna))
                    .collect(Collectors.joining());
        }

        private String doMagic(int value, String dna) {
            String stringMagic = String.valueOf(Character.getNumericValue(dna.charAt(value)));
            switch (stringMagic.toUpperCase()) {
                case "T": stringMagic = "U";
                case "U": stringMagic = "T";
            }
            return stringMagic;
        }
    }

    public class Kata2 {

        public static boolean validSpacing(String s) {
            int numberOfWords = s.trim().split("[ ]+").length;
            String allSpaces = s.replaceAll("[a-zA-Z]","");

            return (numberOfWords == allSpaces.length() + 1) || (allSpaces.length() == 0);
        }
    }

}

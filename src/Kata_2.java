import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Kata_2 {
    public static void main(String[] args) {
        byte s = 0x0011;
        System.out.println(Byte.toUnsignedInt(s));
        System.out.println(BinaryArrayToNumber.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,0,0,1))));
        System.out.println(BinaryArrayToNumber.ConvertBinaryArrayToInt(new ArrayList<>(Arrays.asList(0,0,1,0))));
        System.out.println(ByteBuffer.wrap(new byte[]{0,0,0,1}));
//        System.out.println(new BigInteger(s).intValue());
    }


}
class BinaryArrayToNumber{

    public static int ConvertBinaryArrayToInt(List<Integer> binary){

        byte[] binaryArray = new byte[binary.size()];
        Iterator<Integer> iterator = binary.iterator();
        int index = 0;
        while(iterator.hasNext()){
            Integer i = iterator.next();
          binaryArray[index++] = i.byteValue();
        }
        System.out.println(Arrays.toString(binaryArray));
        int n=0;
        for(byte b: binaryArray){
            n = 10*n + (b-'0');
        }
//        StringBuilder binaryString = new StringBuilder();
//        for(byte i : binaryArray) binaryString.append(i);
        ByteBuffer bytes = ByteBuffer.wrap(binaryArray);
        return bytes.getInt();


        //byte binaryNumber = Byte.parseByte(binaryArray.toString());
//        return Integer.parseInt(binaryArray.toString());
    }
}
package co.book.exercises.bynary;

import java.util.logging.Logger;

/**
 *
 * :::::::::I- Logical bit shift:::::::::
 * 1)  Left  = 1 one movement to le Left
 * 2)  Right  = 1 one movement to le right
 * 1011 -->
 * 0101 Result --> Most significant bit is zero and least-significant bit is loss
 * BitShit of 3
 * 1011
 * 0101 step 1
 * 0010 step 2
 * 0001 Result
 *
 * :::::::::II- Arithmetic bit shift:::::::::
 * 1)  Left  = 1
 * 2)  Right = 1
 */
public class BitShift {

    public static int logicalRightBitShift(String binary, int shiftTimes){
        try{
            //int binShifted = binary >> shiftTimes;
            System.out.println("Input number is "+Integer.parseInt(binary, 2));
            int binShifted = Integer.parseInt(binary, 2);
            return binShifted >> shiftTimes;
        }catch (NumberFormatException e ){
            System.out.println("Error transformando el string "+binary);
            System.out.println(e.getMessage());
            return 0;
        }

    }

    public static int arithmeticRightBitShift(String binary, int shiftTimes){
        ///int binShifted = binary >>> shiftTimes;
        int binShifted = Integer.parseInt(binary, 2);
        return binShifted >>> shiftTimes;
    }

    public static void main(String[] args) {
        System.out.println("::::::::::::::Logical:::::::::::::");
        System.out.println(logicalRightBitShift("1011",1));//5
        System.out.println(logicalRightBitShift("1011",3));//1
        System.out.println("::::::::::::::Arithmetic:::::::::::::");
        System.out.println(arithmeticRightBitShift("1011",1));
        System.out.println(arithmeticRightBitShift("1011",3));
        System.out.println(Integer.toBinaryString(11));
        System.out.println(Integer.toBinaryString(5));
    }
}

package algo_ds.session1_intro;


public class Algo01 {

    public static void printArr( int[]  intArrays){
        for (int i = 0 ; i < intArrays.length; i++){
            System.out.println(intArrays[i]);
        }

    }

    /**
     * Rules:
     * 1- Only pick one ball at a time.
     * 2- Before picking up another ball, you need to drop the existing ball-in-hand, in an empty basket.
     * 3- You have to start from left most basket and arrange the balls moving towards the RIGHT.
     * 4- You can use a stick to keep track of the sorted part.
     *
     *
     * My Analysis
     * Input array [10,2,8,6]
     * basket : _
     *
     * Iteration 		input Arr cursor		basket
     * 0				[*10,2,8,6]				10
     * 1				[10,*2,8,6]				2   if(2<10)	then swap from [10,2,8,6] to [2,10,8,6]
     * 2				[2,10,*8,6]				8   if(8<10)	then swap from [2,10,8,6] to [2,8,10,6]
     * 3				[2,10,8,*6]				6   if(6<10)	then swap from [2,10,8,6] to [2,8,6,10]
     *
     *
     * Iteration 		input Arr stick		basket
     * 0				[*10,2,1]				10			I if(2<10 and 2<1)	then swap from [10,2,8,6] to [2,10,8,6]
     * 1				[2,*10,8,6]				8   		if(8<10) and 8<6 ) --> No  then
     * Given 8>6 							then swap from [2,10,8,6]to [2,6,8,6]
     * 1				[2,*10,8,6]				6
     *
     *
     * @return
     */
    public static int[] orderOne( int[]  intArrays){
        int basket = 0;
        int sortedPartPos = 0;
        for(int i = 0 ; i< intArrays.length; i++){
            int val = i+1;
            if(val>=intArrays.length){
                break;
            }

            if(intArrays[i] > intArrays[i+1]){
                basket = intArrays[i+1];
                intArrays[i+1] = intArrays[i];
                intArrays[i] = basket;
            }

            for(int j = i ; j >0; j -- ){
                if(intArrays[j] < intArrays[j-1]){
                    basket = intArrays[j];
                    intArrays[j] = intArrays[j-1];
                    intArrays[j-1] = basket;
                }
            }

        }
        return intArrays;
    }

    public static void main(String ... args) {
        //printArr(orderOne( new int[]{4,3,2,1}));
       printArr(orderOne( new int[]{10,2,8,6,7,3}));
    }
}

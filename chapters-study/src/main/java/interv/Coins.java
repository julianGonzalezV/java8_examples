package interv;

import java.util.Arrays;

public class Coins {

    private static int PARTICIPANTS = 3;

    public static int maxCoins(int[] piles) {
        System.out.println("::::::maxCoins::::::::");
        if(piles.length % PARTICIPANTS != 0){
            return 0;
        }
        Arrays.sort(piles);
        int[] pilesNormalized = Arrays.copyOfRange(piles,piles.length-PARTICIPANTS,piles.length);

        int sumOfSecond = 0;

        for(int i =0; i < pilesNormalized.length; i+=2){
            sumOfSecond += pilesNormalized[i];
        }

        return sumOfSecond;
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2,4,1,2,7,8}));
    }
}

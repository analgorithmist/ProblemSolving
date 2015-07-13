import java.util.*;
public class CoinExchangePractice {

    public int minCoins(int[] v, int sum){
        if(v==null||v.length==0)
            throw new IllegalArgumentException("coins array is empty or null");
        int[] bestCount = new int[sum+1];
        Arrays.fill(bestCount,Integer.MAX_VALUE);
        bestCount[0]=0;
        for(int i=1;i<=sum;i++){
            for(int j=0;j<v.length&&v[j]<=i;j++){
               bestCount[i]=Math.min(bestCount[i],(bestCount[(i-v[j])]+1));
            }
        }

        if(bestCount[sum]!=Integer.MAX_VALUE)
            return bestCount[sum];
         return -1;
    }


    public void test(){
        int[] v = {1,3,5};
        System.out.println(minCoins(v,11));
        System.out.println(minCoins(v,10));
        System.out.println(minCoins(v,18));
    }

    public static void main(String[] args){
        CoinExchangePractice c = new CoinExchangePractice();
        c.test();
    }
}

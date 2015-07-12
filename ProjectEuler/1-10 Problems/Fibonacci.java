/**
 * Created by sunil.kksubramanyam on 7/12/15.
 */
import lib.*;
import java.io.*;
import java.util.StringTokenizer;
import java.math.*;

public class Fibonacci {

    //take care of the integer overflows and stuff
    public static BigInteger findFib(BigInteger n){
        BigInteger f0= BigInteger.ONE;
        BigInteger f1=BigInteger.ONE;
        BigInteger f2=BigInteger.ZERO;
        BigInteger sum = BigInteger.ZERO;
        while((f1.add(f0)).compareTo(n)<0){
            f2=f1.add(f0);
            if(f2.mod(BigInteger.valueOf(2)).compareTo(BigInteger.ZERO)==0) sum=sum.add(f2);
            f0=f1.add(BigInteger.ZERO);
            f1=f2.add(BigInteger.ZERO);
        }
        return sum;
    }

    public static void main(String[] args){
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int T = in.nextInt();
        while(T--!=0){
            BigInteger n = new BigInteger(in.next()); //convert String to BigInteger using constructor. For comparsions use compareTo
            BigInteger result = findFib(n);
            out.println(result);
        }
        out.close();
    }
}





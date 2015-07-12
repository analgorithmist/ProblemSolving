import lib.*;
import java.io.*;
import java.util.StringTokenizer;

public class Multiples3 {

    public static long sum(long v){
        return v*(v+1)/2;
    }

    public static void main(String[] args){
         InputReader in = new InputReader(System.in);
         PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
         int T = in.nextInt();
         while(T--!=0){
             long n = (long)in.nextInt();
             n-=1;
             long result = sum(n/3)*3+sum(n/5)*5-sum(n/15)*15;
             out.println(result);
         }
        out.close();
    }

}




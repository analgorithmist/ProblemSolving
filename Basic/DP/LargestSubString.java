import java.util.*;

public class LargestSubString{

    public static void largestSubString(String str){
        if(str==null || str.length()==0)
            throw new IllegalArgumentException("string doesnt have any characters or string is null, check the input");
        boolean[] used = new boolean[256];
        int gMax = 0, gs = -1 , ge = -1, start=0, end = -1;
        int count = 0;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(used[c]){
                Arrays.fill(used,false);
                start=i;
                end = i;
                count=1;
            }
            else{
                count++;
                end = i;
            }
            if(count>gMax){
                gs = start;
                ge = end;
                gMax=count;
            }
            used[c]=true;
        }
        System.out.println("Result");
        for(int i=gs;i<=ge;i++)
            System.out.print(str.charAt(i));
        System.out.println();
    }

    public static void main(String[] args){
        String str= "geeksforgeeks";
        String str1 ="ABDEFGABEF";
        largestSubString(str1);
    }
}
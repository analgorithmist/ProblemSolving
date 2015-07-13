public class LargestIncreasingSubsequence{

    public static void lis(int[] arr){
        if(arr==null || arr.length==0)
           throw new IllegalArgumentException("Either array is null or length is zero");
        int[] count = new int[arr.length];
        int[] parent = new int[arr.length];
        count[0]=1; parent[0]=0;
        for(int i=0;i<arr.length;i++){
            count[i]=1; parent[i]=i; //missed this code was throwing out of the bounds of exception.
            for(int j=0;j<i;j++){
                int c = count[j] + 1;
                if(c>=count[i]&&arr[j]<arr[i]){
                    parent[i]=j;
                    count[i]=c;
                }
            }
        }

        int maxIndex = -1; int maxCount = Integer.MIN_VALUE;
        for(int i=0;i<count.length;i++){
            if(count[i]>maxCount){
                maxCount = count[i];
                maxIndex = i;
            }
        }

        int[] result = new int[maxCount];
        int k = 0;
        int prevI=-1;
        for(int i=maxIndex;i!=prevI;i=parent[i]){
            result[k++]=arr[i];
            prevI=i;
        }
        System.out.println("result");
        for(int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        System.out.println();
        System.out.println("maxlength:"+ maxCount);

    }

    public static void main(String[] args){
        int[] testArray1 = { 100,10, 22, 9, 33, 21, 50, 41, 60 };
        int[] testArray2 = {};
        int[] testArray3 ={-1};
        lis(testArray1);
    }
}
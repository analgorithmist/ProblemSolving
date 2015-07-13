public class MaxContiguousSubsequence{
	
    public static void maxSubSeq(int[] arr){
    	int start = -1, end = -1,gstart=-1,gend=-1, currMax = Integer.MIN_VALUE, globalMax = Integer.MIN_VALUE;
    	for(int i=0;i<arr.length;i++){
    		int v = arr[i];
    		if(v> currMax+v){
    			currMax = v;
    			start = i;
    			end = i;
    		}
    		else{
    			currMax += v;
    		    end = i; 	
    		}
    		if(currMax>globalMax){
    			globalMax = currMax;
    			gstart = start;
    			gend = end;

    		}
    	}
    	System.out.println("start:"+gstart+"end:"+gend+"maxsubseqsum:"+globalMax);
    }
	public static void main(String[] args){
		int[] testArray = {6,-7,2,4,-6,3,2,5,-4};
		maxSubSeq(testArray);
	}

}

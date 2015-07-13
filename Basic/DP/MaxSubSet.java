import java.util.*;
public class MaxSubSet {
        public ArrayList<Integer> maxset(ArrayList<Integer> A) {
            int maxSum = Integer.MIN_VALUE;
            ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
            int current = -1;
            ArrayList<Integer> a=null;
            boolean isMaxSum = false;
            for(int i:A){
                if(current==-1){
                    a= new ArrayList<Integer>();
                    current = 0;

                }

                if(i<0){
                    current=-1;
                    if(isMaxSum){
                        result.add(a);
                        isMaxSum = false;
                    }

                    continue;
                }
                else{
                    current += i;
                    a.add(i);
                    if(current>=maxSum){
                        isMaxSum = true;
                        maxSum = current;
                        //result.add(a);
                    }
                }

            }

            if(isMaxSum)
                result.add(a);

            int res = -1;
            int min = Integer.MIN_VALUE;
            //public boolean
            for(int i=0;i<result.size();i++){
                if(min<result.get(i).size()){
                    res = i;
                    min = result.get(i).size();
                }
            }
            if(res!=-1)
                return result.get(res);
            else
                return new ArrayList<Integer>();
        }
    public void test(){
        ArrayList<Integer> a1 = new ArrayList<Integer>();
        a1.add(756898537);
        a1.add(-1);
        a1.add(-1);
        a1.add(-1);
        a1.add(1424268980);
        ArrayList<Integer> a = maxset(a1);
        System.out.println(a);
    }
    public static void main(String[] args){
       MaxSubSet m = new MaxSubSet();
        m.test();
    }

}


/**
 *

 class Solution {
 public:

 vector<int> maxset(vector<int> Vec) {
 int N = Vec.size();

 long long mx_sum = 0;
 long long cur_sum = 0;
 int mx_range_left = -1;
 int mx_range_right = -1;
 int cur_range_left = 0;
 int cur_range_right = 0;

 while(cur_range_right < N) {
 if(Vec[cur_range_right] < 0) {
 cur_range_left = cur_range_right + 1;
 cur_sum = 0;
 } else {
 cur_sum += (long long)Vec[cur_range_right];
 if(cur_sum > mx_sum) {
 mx_sum = cur_sum;
 mx_range_left = cur_range_left;
 mx_range_right = cur_range_right + 1;
 } else if(cur_sum == mx_sum) {
 if(cur_range_right + 1 - cur_range_left > mx_range_right - mx_range_left) {
 mx_range_left = cur_range_left;
 mx_range_right = cur_range_right + 1;
 }
 }
 }
 cur_range_right++;
 }
 vector<int> ans;
 if(mx_range_left == -1 || mx_range_right == -1)
 return ans;

 for(int i = mx_range_left; i < mx_range_right; ++i)
 ans.push_back(Vec[i]);
 return ans;
 }
 };


 */

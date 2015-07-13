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
 InterviewBit Beta

 Chat
 Puzzles
 338
 50
 sk1wizkid

 Dashboard Arrays Maxset

 MAXSET

 Find out the maximum sub-array of non negative numbers from an array.
 The sub-array should be continuous. That is, a sub-array created by choosing the second and fourth element and skipping the third element is invalid.

 Maximum sub-array is defined in terms of the sum of the elements in the sub-array. Sub-array A is greater than sub-array B if sum(A) > sum(B).

 Example:

 A : [1, 2, 5, -7, 2, 3]
 The two sub-arrays are [1, 2, 5] [2, 3].
 The answer is [1, 2, 5] as its sum is larger than [2, 3]

 NOTE: If there is a tie, then compare with segment's length and return segment which has maximum length
 NOTE 2: If there is still a tie, then return the segment with minimum starting index
 Notes

 00 : 39 : 49
 Current Possible Score: 0
 Max Score: 150

 Compilation
 Correctness
 Wrong Answer. Your program's output doesn't match the expected output. You can try testing your code with custom input and try putting debug statements in your code.
 Your submission failed for the following input:
 A : [ 756898537, -1973594324, -2038664370, -184803526, 1424268980 ]
 Your function returned the following :
 756898537
 The expected returned value :
 1424268980
 Make sure you are not printing values inside your function

 Time Limit: 14 Sec Memory Limit: 50 MB

 Hints

 Hint 1
 Solution Approach
 Complete Solution

 Similar Problems

 WAVE

 606 successful submissions.
 Stuck?
 Find your friends who have solved this problem.
 Connect with facebook
 This thread is for people who have not yet solved the problem. Please do not post solutions here.
 Join us on IRC at #interviewbit on freenode for bugs, help or suggestions.

 About Us FAQ Contact Us Terms Privacy Policy

 Like Us Follow Us Email

 We are in beta! We would love to hear your feedback.
 Access Hint

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

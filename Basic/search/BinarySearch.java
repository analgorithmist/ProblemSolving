/**
 * Created by sunil.kksubramanyam on 7/5/15.
 */
public class BinarySearch {

    //Problem1: Basic Iterative solution. Uses half the search space, hence log n.
    // just use java.util.Arrays.binarySearch(arr,key); gives the index.
    public int binarySearchIterative(int[] arr, int low, int high, int key){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]==key)
                return mid;
            else if(key<arr[mid])
                high = mid -1;
            else
                low = mid + 1;
        }
        return -1;
    }

    //problem 2: Basic recursive solution. Comparitively inefficient solution than 1. Space complexity here is O(log n) becasuse of using the recursive statck.
    public int binarySearchRecursive(int[] arr, int low, int high, int  key){
        if(low>high) return -1;
        int mid = low + (high-low)/2;
        if(arr[mid]==key)
            return mid;
        else if(key<arr[mid]) return binarySearchRecursive(arr,low,mid-1,key);
        else return binarySearchRecursive(arr,mid+1,high,key);
    }

    //Problem 3: Find the start index of the target example: [6,6,6,6,6,6,6] should return zero.
    public int binarySearchLowIndex(int[] arr, int low, int high, int key){

        while(low<high){
            int mid = low + (high-low)/2;
            if(key<=arr[mid]){
                high=mid;
            }
            else
                low=mid+1;
        }

        if(arr[low]==key)
            return low;
        else
            return -1;
    }

    //problem 4: Find the end index of the target example:[6,6,6,6,6,6,6] return 6
    //running into infinite loop for this code. should not use low<=high, here it is low<high
    public int binarySearchHighIndex(int[] arr, int low, int high, int key){
        while(low<high){
            int mid = (int)Math.ceil(low+(high-low)/(double)2.0);//Notice this 2.0 and the need for getting the upper limit. For above problem we should get floor, by default it is floor anyways.
                                                                 //assume an array at index 13 value is 4 and at 14 value is 9. you go into an infinite loop. low is not increasing, high is not being modified.
            if(key>=arr[mid])
                low = mid;
            else
                high = mid-1;
        }
        if(arr[high]==key)
            return high;
        else
            return -1;
    }

    //problem 5: Find the number of duplicate elements in sorted array of target. Ex: [1,2,4,4,4,4,4,4,9]. Target: 4 result: 5
    public int findDuplicateCount(int[] arr, int low, int high, int key){
        return (binarySearchHighIndex(arr,low,high,key)-binarySearchLowIndex(arr,low,high,key))+1;
    }

    //problem 6: binary search on a rotated array.
    //consider the example 10,11,12,13,14,15,0,1,2. Key =1
    public int binarySearchRotated(int[] arr, int low, int high, int key){
        while(low<=high){
            int mid = high + (low-high)/2;
            if(arr[mid]==key)
                return mid;
            if(arr[low]<=arr[mid]){
               if(key<arr[mid]&&key>arr[low])
                   high = mid - 1;
                else
                   low = mid + 1;
            }
            else{
                if(key>mid&&arr[mid]<=arr[high])
                    low = mid+1;
                else high = mid -1;
            }

        }
        return -1;
    }

    //problem 7: find the minimum element in sorted and rotated array.
    //ex: 7 8 0 1 2 3 4 5 6
    public int binarySearchRotatedMinimum(int[] arr, int low, int high){
        if(arr.length==0)
            throw new IllegalArgumentException("array cannot be empty!! :P"); //need to add this otherwise you will get IndexOutofBoundsException
        while(low<high){
            int mid = low + (high-low)/2;
            //ex: 7 8 0 1 2 3 4 5 6
            if(mid!=0&&arr[mid]<=arr[high]){//without equals not working on array with duplicate values.
                if(arr[mid-1]<=arr[mid])
                    high = mid-1;
                else
                    return mid;
            }
            //ex: 10 11 12 13 14 15 16 0 1 2
            else if(mid!=high-1&&arr[mid]>arr[high]){
                if(arr[mid+1]<arr[mid])
                     return mid+1;
                else
                    low = mid+1;
            }
        }
         return arr[0];//careful for this case.
    }





    public void test(){
        int[] arr1 = {1,2,3,4,5,6,7};
        System.out.println(binarySearchIterative(arr1, 0, arr1.length - 1, 10));
        System.out.println(binarySearchRecursive(arr1, 0, arr1.length - 1, 6));//missed arr.length-1, used arr.length instead, case failed.
        int[] arr2 = {1,4,4,4,4,4,4,4,4,4,4,4,4,4,9};
        System.out.println(binarySearchLowIndex(arr2, 0, arr2.length - 1, 4));
        System.out.println(binarySearchHighIndex(arr2, 0, arr2.length - 1, 4));
        System.out.println(findDuplicateCount(arr2, 0, arr2.length - 1, 4));
        int[] arr3 = {10,11,12,13,14,15,0,1,2,};
        System.out.println(binarySearchRotated(arr3,0,arr3.length-1,1));
        int[] arr4= {7,8,0,1,2,3,4,5,6};

        System.out.println(binarySearchRotatedMinimum(arr4,0,arr4.length-1));
        System.out.println(binarySearchRotatedMinimum(arr3,0,arr3.length-1));
        System.out.println(binarySearchRotatedMinimum(arr1,0,arr1.length-1));
        System.out.println(binarySearchRotatedMinimum(arr2,0,arr2.length-1));
        //whether your code works for duplicates?

    }

    public static void main(String[] args){
        BinarySearch b = new BinarySearch();
        b.test();
    }
}

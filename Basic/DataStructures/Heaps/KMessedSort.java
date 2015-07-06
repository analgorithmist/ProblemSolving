package Heaps;
import java.util.*;

public class KMessedSort {

    //time complexity O(nlogk)
    public void printSortedArray(int[] arr, int k){

        if(k>arr.length)
            throw new IllegalArgumentException("k cannot be greater than array length");
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++)
            pq.add(arr[i]);

        for(int i=k;i<arr.length;i++){
            pq.add(arr[i]);
            arr[i-k]=pq.remove();
        }

        for(int i=arr.length-k;i<arr.length;i++)
            arr[i]=pq.remove();

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }


    public void test(){
        int[] arr ={4,2,6,1,5,3,7,8,9};
        int k = 3;
        printSortedArray(arr,k);
    }

    public static void main(String[] args){
        KMessedSort k = new KMessedSort();
        k.test();
    }

}

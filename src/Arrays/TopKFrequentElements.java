package Arrays;
import java.util.*;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> hash=new HashMap<>();
        for(int num:nums){
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b) -> hash.get(b) - hash.get(a));
        pq.addAll(hash.keySet());
        int[] arr=new int[k];
        for(int i=0;i<k;i++){
            arr[i]=pq.remove();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1={-1,-1},arr2={1,1,1,2,2,3};
        int k1=1,k2=2;
        System.out.println(Arrays.toString(topKFrequent(arr1,k1)));//[-1]
        System.out.println(Arrays.toString(topKFrequent(arr2,k2)));//[1, 2]
    }
}

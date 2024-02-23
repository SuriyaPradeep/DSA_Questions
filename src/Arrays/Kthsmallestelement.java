package Arrays;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kthsmallestelement {
    //kth Smallest using quick select
    public static int kthSmallest(int[] arr, int left, int right, int k) {
        int pos = partition(arr, left, right);
        if (pos  == k )
            return arr[pos-1];
        if (pos > k )
            return kthSmallest(arr, left, pos - 1, k);
        return kthSmallest(arr, pos + 1, right, k );
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int pIndex = left;
        for (int i = left; i < right; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, pIndex++);
            }
        }
        swap(arr, pIndex, right);
        return pIndex;
    }
    //kth Smallest using max heap
    public static int kthSmallestHeap(int[] nums,int k) {
        PriorityQueue<Integer> max_pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            max_pq.add(num);
            if(max_pq.size()>k){
                max_pq.remove();
            }
        }
        return max_pq.remove();
    }
    public static void main(String[] args) {
        int[] arr1={ 7, 10, 4, 20, 15};
        System.out.println(kthSmallest(arr1,0,4,4));
        int[] arr2={7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallest(arr2,0,5,3));
        System.out.println(kthSmallestHeap(arr1,4));
        System.out.println(kthSmallestHeap(arr2,3));
    }
}

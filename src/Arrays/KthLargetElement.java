package Arrays;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
/*
Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class KthLargetElement {
    /*
    Solve Using First Sorting the array then return length-k
     */
    public int findKthLargestSort(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
    /*Find Kth Largest element using Quick Select
     */
    public int findKthLargestQuick(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length-1, nums.length-k);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        int pIndex = new Random().nextInt(right - left + 1) + left;
        pIndex = partition(nums, left, right, pIndex);
        if (pIndex == k) return nums[k];
        else if (pIndex < k) return quickSelect(nums, pIndex+1, right, k);
        return quickSelect(nums, left, pIndex-1, k);
    }
    private int partition(int[] nums, int left, int right, int pIndex) {
        int pivot = nums[pIndex];
        swap(nums, pIndex, right);
        pIndex = left;

        for (int i=left; i<=right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, pIndex++);
            }
        }
        return pIndex - 1;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    /*
    Using Min Heap
     */
    public int findKthLargestHeap(int[] nums, int k) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        /*
        Add elements to MinHeap
         */
        for (int n : nums) {
            minHeap.add(n);
            if (minHeap.size() > k) {//If Size of the heap larger than k then remove
                minHeap.remove();//It removes smallest value
            }
        }
        return minHeap.remove();//The Smallest value after loop is the largest Kth Element
    }

    public static void main(String[] args) {
        KthLargetElement LE=new KthLargetElement();
        int[] arr={3,2,1,5,6,4};
        System.out.println(LE.findKthLargestSort(arr,2));
        System.out.println(LE.findKthLargestQuick(arr,2));
        System.out.println(LE.findKthLargestHeap(arr,2));
    }
}

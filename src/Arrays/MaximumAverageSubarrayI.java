package Arrays;
/*
You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 */
public class MaximumAverageSubarrayI {
    public static double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        double sum=0;
        for(int i=0;i<k;i++){
            sum+=nums[i];
        }
        double max_avg=sum/k;
        for(int i=k;i<n;i++){
            sum+=nums[i]-nums[i-k];
            max_avg=Math.max(max_avg,sum/k);
        }
        return max_avg;
    }

    public static void main(String[] args) {
        int[] arr1={1,12,-5,-6,50,3},arr2={5};
        int k1=4,k2=1;
        System.out.println(findMaxAverage(arr1,k1));//12.75
        System.out.println(findMaxAverage(arr2,k2));//5
    }
}

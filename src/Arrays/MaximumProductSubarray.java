package Arrays;
/*
Given an integer array nums, find a subarray that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        //Initialize max,min ans to value zeroth index of the array
        int max=nums[0],min=nums[0],ans=nums[0],n=nums.length;
        for(int i=1;i<n;i++){//Start a loop from i=1 that runs till i<n
            //Set temp=max to not affect min after max is changed in a iteration
            int temp=max;
            //Find Max such that in array [2,3,-2,4]
            //First Iteration be like
            //Max=Math.Max(6,6,3)=6
            //Min=Math.Min(6,6,3)=3
            //Second Iteration
            //Max=Math.Max(-12,-6,-2)=-2
            //Min=Math.Min(-12,-6,-2)=-12 so on....
            max=Math.max(Math.max(max*nums[i],min*nums[i]),nums[i]);
            min=Math.min(Math.min(temp*nums[i],min*nums[i]),nums[i]);
            if(max>ans){
                ans=max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1={2,3,-2,4};
        int[] arr2={2};
        int[] arr3={-2,0,-1};
        System.out.println(maxProduct(arr1));//6
        System.out.println(maxProduct(arr2));//2
        System.out.println(maxProduct(arr3));//0
    }
}

package Arrays;
/*
Given an integer array nums, find the sub-array with the largest sum, and return its sum.
 */
public class MaximumSubArray {
    //Can be solved using Kadane's Algorithm.
    /* Initialize 2 int max where its is equal to Integer.MIN_VALUE and
    max_here which keeps track of sum.
    Start a loop of n where it is length of array
    Add max_here and a[i]
    if max_here is greater than max them max=max_here
    if max_here<0 max_here=0*/
    private static int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE,max_here=0;
        for(int i=0;i<nums.length;i++){
            max_here+=nums[i];
            if(max_here>max){
                max=max_here;
            }
            if(max_here<0){
                max_here=0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,};
        System.out.println(maxSubArray(arr));//OP:6
    }
}

package Arrays;
/*
Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
A subarray is a contiguous part of the array.
 */
public class BinarySubarraysWithSum {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums,goal)-helper(nums,goal-1);
    }
    private static int helper(int[] nums,int goal){
        if(goal<0){
            return 0;
        }
        int curSum=0,l=0,res=0;
        for(int r=0;r<nums.length;r++){
            curSum+=nums[r];
            while (curSum>goal){
                curSum-=nums[l++];
            }
            res+=r-l+1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr1={1,0,1,0,1},arr2={0,0,0,0,0};
        int goal1=2,goal2=0;
        System.out.println(numSubarraysWithSum(arr1,goal1));//4
        System.out.println(numSubarraysWithSum(arr2,goal2));//15
        System.out.println(numSubarraysWithSum(arr2,goal1));//0
    }
}

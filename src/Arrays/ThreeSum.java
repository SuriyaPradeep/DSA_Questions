package Arrays;
/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
 */
import java.util.*;
public class ThreeSum {
    /*
    Solving it in O(n^2) similar to 2 pointer
    Here we first sort the array then keep one point fixed and find two point left and right
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> indices=new HashSet<>();//Use hashset to get unique values
        //Doesn't accept duplicate value
        Arrays.sort(nums);
        int n= nums.length;
        for(int i=0;i<n-3 && nums[i]<=0;){
            int left=i+1,right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==0){
                    indices.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    while (left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                } else if (sum>0) {
                    right--;
                    while (left<right && nums[right]==nums[right+1]){
                        right--;
                    }
                }else{
                    left++;
                    while (left<right && nums[left]==nums[left-1]){
                        left++;
                    }
                }
            }
            i++;
            while (i<n-2 && nums[i]==nums[i-1]){
                i++;
            }
        }
        return new ArrayList<>(indices);//Return hashset as array list
    }

    public static void main(String[] args) {
        int[] arr={-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));//[[-1, -1, 2], [-1, 0, 1]]
    }
}

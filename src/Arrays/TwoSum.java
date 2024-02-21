package Arrays;

import java.util.Arrays;
import java.util.HashMap;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
 */
public class TwoSum {
    //Two sum using hash map
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hash=new HashMap<>();//Create a hashmap for integer and integer
        for(int i=0;i<nums.length;i++){//Loop through the array
            int compliment=target-nums[i];//Find compliment i.e target-nums[i]
            //So if there is any element same as compliment in the hash return the key's index
            //with current index
            if(hash.containsKey(compliment)){
                return new int[]{hash.get(compliment),i};
            }else{//If not then add the number and index to hashmap
                hash.put(nums[i],i);
            }
        }//If no two sum is found throw an error that there is no compliment
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] arr1={2,7,11,15};
        int target1=9;
        System.out.println(Arrays.toString(twoSum(arr1,target1)));//[0,1]
        int[] arr2={3,2,4};
        int target2=6;
        System.out.println(Arrays.toString(twoSum(arr2,target2)));//[1,2]
    }
}

package Arrays;

import java.util.HashMap;

/*
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 */
public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        int maxLen=0,zeroCounts=0,oneCounts=0,n=nums.length;
        HashMap<Integer,Integer> hash=new HashMap<>();
        hash.put(0,-1);
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zeroCounts++;
            }else{
                oneCounts++;
            }
            int diff=oneCounts-zeroCounts;
            if(hash.containsKey(diff)){
                maxLen=Math.max(maxLen,i-hash.get(diff));
            }else{
                hash.put(diff,i);
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        int[] arr1={0,1},arr2={1,0,1},arr3={1,1,1,0,0,0,1,0,0,0};
        System.out.println(findMaxLength(arr1));//2
        System.out.println(findMaxLength(arr2));//2
        System.out.println(findMaxLength(arr3));//8
    }
}

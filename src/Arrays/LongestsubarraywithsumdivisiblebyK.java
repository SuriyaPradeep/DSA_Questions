package Arrays;

import java.util.HashMap;

/*
Given an arr[] containing n integers and a positive integer k. The problem is to find the longest subarray’s length with the sum of the elements divisible by the given value k.

Examples:
Input: arr[] = {2, 7, 6, 1, 4, 5}, k = 3
Output: 4
Explanation: The subarray is {7, 6, 1, 4} with sum 18, which is divisible by 3.
 */
public class LongestsubarraywithsumdivisiblebyK {
    private static int longestSubarrWthSumDivByK(int[] nums,int k){
        /*
        initialize an hashmap
        Go through elements in array and calculate the sum
        Check double modulus on sum
        If the mod is 0, it means the cumulative sum up to the current index is divisible by k. In this case, update max to i + 1, indicating that the entire subarray up to index i satisfies the condition.
        If the mod is not 0, it means the cumulative sum is not divisible by k. Check if this mod value is present in the hash.
        If the mod value is not present in the hash, store it along with its corresponding index i.
        If the mod value is already present in the hash, it means there is a subarray with a sum divisible by k. Calculate the length of this subarray as i - hash.get(mod) and update max if it's greater than the current max.
         */
        int max=0,sum=0,n=nums.length;
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=nums[i];
            //Using double Mod to tackle negative integers
            int mod=((sum%k)+k)%k;
            if(mod==0){
                max=i+1;
            }else if(!hash.containsKey(mod)){
                hash.put(mod,i);
            }else{
                max=Math.max(max,i-hash.get(mod));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1={ 2, 7, 6, 1, 4, 5 };
        int k1=3;
        System.out.println(longestSubarrWthSumDivByK(arr1,k1));//4
        int[] arr2={-2, 2, -5, 12, -11, -1, 7};
        int k2=3;
        System.out.println(longestSubarrWthSumDivByK(arr2,k2));//5
    }
}

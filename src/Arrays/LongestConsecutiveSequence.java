package Arrays;

import java.util.HashSet;
import java.util.Set;

/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive1(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int longest=0;
        for(int num:nums){
            set.add(num);
        }
        for(int num : nums) {
            int left = num - 1;
            int right = num + 1;
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            longest = Math.max(longest,right - left - 1);
            if(set.isEmpty())
                return longest;//save time if there are items in nums, but no item in hashset.
        }
        return longest;
    }
    public static int longestConsecutive2(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int longest=0;
        for(int num:nums){
            set.add(num);
        }
        for(int num:nums){
            //Check for start of sequence
            if(!set.contains(num-1)){
                int length=1;
                while (set.contains(num+length)){
                    length++;
                }
                longest=Math.max(longest,length);
            }
        }
        return longest;
    }
    public static void main(String[] args) {
        int[] arr1={100,4,200,1,3,2},arr2={0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive1(arr1));//4
        System.out.println(longestConsecutive1(arr2));//9
        System.out.println(longestConsecutive2(arr1));//4
        System.out.println(longestConsecutive2(arr2));//9
    }
}

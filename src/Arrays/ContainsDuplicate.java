package Arrays;

import java.util.HashMap;

/*Given an integer array nums, return true if any value appears at least twice in the array,
and return false if every element is distinct.*/
public class ContainsDuplicate {
    /*We can Use hashmap to solve this problem in O(n)
    In for each loop through array nums
    Hashmap<Integer,Integer>={number in array:how many time seen}
    If hashmap already contains key of the array return true
    Else we add the element to hashmap and increase its seen by 1.
    */
    private static  boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hash=new HashMap<>();
        for (int num : nums) {
            if (hash.containsKey(num)) {
                return true;
            }
            hash.put(num, hash.getOrDefault(num, 0) + 1);
            //getOrDefault returns value of key if key exits otherwise returns a default value.
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,1};
        System.out.println(containsDuplicate(arr));
    }
}

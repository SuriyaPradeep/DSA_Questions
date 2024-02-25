package Arrays;

import java.util.Arrays;

public class LargestNumberformedfromanArray {
    private static String printLargest(String[] arr) {
        Arrays.sort(arr,(a,b)->(b+a).compareTo((a+b)));
        /*
        (a,b)->(b+a).compareTo((a+b)) It sorts the array in descending order
        If b + a is lexicographically less than a + b, it means that b should come before a in the sorted array. Therefore, b is considered smaller, and the comparison returns a negative integer.
If b + a is lexicographically greater than a + b, it means that b should come after a in the sorted array. Therefore, b is considered larger, and the comparison returns a positive integer.
If b + a is lexicographically equal to a + b, the two strings are considered equal, and the comparison returns zero.
         */
        StringBuilder ans= new StringBuilder();
        for(String str:arr){
            ans.append(str);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String[] arr1={"3", "30", "34", "5", "9"};
        String[] arr2={"54", "546", "548", "60"};
        System.out.println(printLargest(arr1));//9534330
        /*
        Explanation:
        Given numbers are  {"3", "30", "34", "5", "9"}, the arrangement "9534330" gives the largest value.
         */
        System.out.println(printLargest(arr2));//6054854654
    }
}

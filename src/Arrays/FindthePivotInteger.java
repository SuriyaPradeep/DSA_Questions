package Arrays;
/*
Given a positive integer n, find the pivot integer x such that:
The sum of all elements between 1 and x inclusively equals the sum of all elements between x and n inclusively.
Return the pivot integer x. If no such integer exists, return -1. It is guaranteed that there will be at most one pivot index for the given input.
Example 1:
Input: n = 8
Output: 6
Explanation: 6 is the pivot integer since: 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21.
 */

public class FindthePivotInteger {
    public static int pivotInteger1(int n) {
        double x=Math.sqrt(((double)(n * (n + 1)) /2));
        if(x%1!=0){
            return -1;
        }
        return (int)x;
    }
    public static int pivotInteger2(int n){
        int[] prefix_sum=new int[n+1];
        for(int i=1;i<=n;i++){
            prefix_sum[i]=prefix_sum[i-1]+i;
        }
        for(int i=1;i<=n;i++){
            if(prefix_sum[i]==prefix_sum[n]-prefix_sum[i-1]){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int n1=8,n2=1,n3=4;
        System.out.println(pivotInteger1(n1));//6
        System.out.println(pivotInteger1(n2));//1
        System.out.println(pivotInteger1(n3));//-1
        System.out.println(pivotInteger2(n1));//6
        System.out.println(pivotInteger2(n2));//1
        System.out.println(pivotInteger2(n3));//-1
    }
}

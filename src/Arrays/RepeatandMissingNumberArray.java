package Arrays;

import java.util.Arrays;
import java.util.HashMap;
/*
You are given a read only array of n integers from 1 to n.
Each integer appears exactly once except A which appears twice and B which is missing.
Return A and B.
 */
public class RepeatandMissingNumberArray {
    /*
    Solving Using Hashing it take O(n) time and space complexity
    here lets initialize a hash of<Integer,Integer>
    Loop through elements in the array add them to hash such as[index value:number of times seen]
    if you encounter element which is already in hash add that to index 0 of array you want to return
    Start a second loop after 1st one here check if i+1 is in hash such as i=0 i<n
    if i+1 is not present add i+1 to index 1 of array you want to return break the loop
    return the array with duplicate and missing value.
    Use this for read only array
     */
    public static int[] repeatedNumber1(final int[] A) {
        int[] arr=new int[2];
        int n=A.length;
        HashMap<Integer,Integer> hash=new HashMap<>();
        for(int num:A){
            if(hash.containsKey(num)){
                arr[0]=num;
            }
            hash.put(num,hash.getOrDefault(num,0)+1);
        }
        for(int i=0;i<n;i++){
            if(!hash.containsKey(i+1)){
                arr[1]=i+1;
                break;
            }
        }
        return arr;
    }
    /*
    If you can change elements array you can use this
    Time complexity O(n) and space complexity of O(1) not hash table is required
    Here we change the index value of elements already visited
    Start a for loop of i=0 i<n
    int index=Math.abs(A[i])-1
        Eg: if A[0] is 3 then index will be 2
        check if(A[index]<=0) Change A[index]=-A[index]
        if A[index]<0 then index is already visited so element is duplicate
      Start a new loop check if A[index] is >0 then that index in not visited as it is not present
      then index + 1 is missing value
      Eg in first loop if there is no 4 then A[3] is never made negative so it will be missing value
     */
    public static int[] repeatedNumber2(int[] A){
        int[] arr=new int[2];
        int n=A.length;
        for(int i=0;i<n;i++){
            int index=Math.abs(A[i])-1;
            if(A[index]>=0){
                A[index]=-A[index];
            }else {
                arr[0]=index+1;
            }
        }
        for(int i=0;i<n;i++){
            if(A[i]>0){
                arr[1]=i+1;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={3,2,5,1,3};
        System.out.println(Arrays.toString(repeatedNumber1(arr)));
        System.out.println(Arrays.toString(repeatedNumber2(arr)));
    }
}

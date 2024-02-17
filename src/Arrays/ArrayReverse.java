package Arrays;

import java.util.Arrays;

/*Reverse an given array*/
public class ArrayReverse {
    //Reversing array using a aux array
    private static int[] arrayReverse(int[] arr){
        int n= arr.length;
        int[] arrRev=new int[n];
        for(int i=0;i< n;i++){
            arrRev[i]=arr[n-i-1];
        }
        return arrRev;
    }
    //Inplace reversing of the array by swapping end and start pointer of the array.
    // And increasing start by 1 and decreasing start by 1 and repeat until start<end.
    private static int[] arrayReverseInplace(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start++]=arr[end];
            arr[end--]=temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(arrayReverse(arr)));
        arr=arrayReverse(arr);
        System.out.println(Arrays.toString(arrayReverseInplace(arr)));
    }
}

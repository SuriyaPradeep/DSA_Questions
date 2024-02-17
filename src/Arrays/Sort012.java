/*Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.*/
import java.util.Arrays;

public class Sort012 {
    public static void sort012(int a[], int n)
    {
        /*Here we maintain 3 pointer low,mid,high
        initialize low=mid=0 and high to n-1
        now loop through array until mid>high
        if a[mid]==0 swap mid and low index and increase them by 1
        if a[mid]==1 increase mid by 1
        if a[mid]==2 swap high with mid and decrease high by 1*/
        int lo=0,mid=0,high=n-1;
        while(mid<=high){
            if(a[mid]==0){
                swap(a,mid++,lo++);
            }else if(a[mid]==1){
                mid++;
            }else{
                swap(a,mid,high--);
            }
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr={0,2, 1, 2, 0};
        sort012(arr,5);
        System.out.println(Arrays.toString(arr));
    }
}

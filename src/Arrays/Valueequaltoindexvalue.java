package Arrays;
/*
Given an array Arr of N positive integers.
Your task is to find the elements whose value is equal to that of its index value ( Consider 1-based indexing ).
 */
import java.util.ArrayList;

public class Valueequaltoindexvalue {
    static ArrayList<Integer> valueEqualToIndex(int arr[], int n) {
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            //if index and value are same add them to list
            //i.e. in index 1(0) value is 1
            if(arr[i]==i+1){
                list.add(arr[i]);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int N = 6;
        int[] Arr = {15, 2, 45, 4, 12, 7};
        System.out.println(valueEqualToIndex(Arr,N));
    }
}

package Arrays;

/*
Print Elements in Array Without using Loop
*/
public class Print1ToNWithoutLoop {
    public static void printNos(int[] arr,int N)
    {
        //Recursion calls function until n>0
        if(N>0){
            printNos(arr,N-1);
        }
        System.out.print(arr[N]+" ");
    }

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        printNos(arr, arr.length-1);
    }
}

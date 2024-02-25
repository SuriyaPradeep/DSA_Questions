package Arrays;

import java.util.Arrays;

/*
Given two numbers say a and b, mark the multiples of 2 and 5 between a and b using less than O(|b – a|) space and output each of the multiples.

Note : We have to mark the multiples i.e save (key, value) pairs in memory such that each key either have value as 1 or 0 representing as multiple of 2 or 5 or not respectively.
 */
public class Spaceoptimizationusingbitmanipulations {
    private static void multiples(int a,int b){
        int size=Math.abs(b-a)+1;
        int[] arr=new int[size];
        for(int i=a;i<=b;i++){
            if(i%2==0 || i%5==0){
                arr[i-a]=1;
            }
        }
        System.out.println("MULTIPLES of 2 and 5:");
        for(int i=0;i<size;i++){
            if(arr[i]==1){
                System.out.print((i+a)+" ");
            }
        }

    }
    private static boolean checkbit(int array[], int index)
    {
        int val = array[index >> 5] & (1 << (index & 31));
        if (val == 0)
            return false;
        return true;
    }

    // Sets value of bit for corresponding index
    private static void setbit(int array[], int index)
    {
        array[index >> 5] |= (1 << (index & 31));
    }
    private static void multiplesBit(int a,int b){
        int size = Math.abs(b-a);
        // Size that will be used is actual_size/32
        // ceil is used to initialize the array with
        // positive number
        size = (int)Math.ceil((double)size / 32);
        System.out.println(size);
        // Array is dynamically initialized as
        // we are calculating size at run time
        int[] array = new int[size];

        // Iterate through every index from a to b and
        // call setbit() if it is a multiple of 2 or 5
        for (int i = a; i <= b; i++)
            if (i % 2 == 0 || i % 5 == 0)
                setbit(array, i - a);
        System.out.println("MULTIPLES of 2 and 5:");
        for (int i = a; i <= b; i++)
            if (checkbit(array, i - a))
                System.out.print(i + " ");
    }
    public static void main(String[] args) {
        //multiples(2,10);
        //System.out.println();
        multiplesBit(2,10);
    }
}

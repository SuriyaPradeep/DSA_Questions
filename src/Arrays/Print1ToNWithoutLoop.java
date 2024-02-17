/*
Print numbers from 1 to N without the help of loops.
 */
public class Print1ToNWithoutLoop {
    public static void printNos(int N)
    {
        //Recursion calls function until n==1
        if(N>1){
            printNos(N-1);
        }
        System.out.print(N+" ");
    }

    public static void main(String[] args) {
        printNos(10);
    }
}

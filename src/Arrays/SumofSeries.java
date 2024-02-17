/*Write a program to find the sum of the given series 1+2+3+ . . . . . .(N terms)*/
public class SumofSeries {
    public static long seriesSum(int n) {
        //SUM of series formula=(n*(n+1))/2
        return ((long)n*((long)n+1))/2;
    }

    public static void main(String[] args) {
        System.out.println(seriesSum(5));
    }
}

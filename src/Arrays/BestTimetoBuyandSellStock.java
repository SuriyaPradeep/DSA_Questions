package Arrays;
/*You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/
public class BestTimetoBuyandSellStock {
    /*Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.*/

    /*To Solve this in O(n)
    Lets initialize 3 variable max_profit which will hold the maximum profit we can earn
    profit which hold profit for each iteration
    lowestPrice it will be the lowest number in the array during iteration at starting initialize it to MAX_VALUE
    In the for loop where i=0 and runs till i<arr.length
        if prices[i] is less than lowestPrice then lowestPrice=prices[i]
        profit=prices[i]-lowestPrice
        if profit is greater than maxProfit then maxProfit=profit
     After loop ending return max_profit

     */
    private static int maxProfit(int[] prices) {
        int maxProfit=0,profit=0,lowestPrice=Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<lowestPrice){
                lowestPrice=prices[i];
            }
            profit=prices[i]-lowestPrice;
            if(profit>maxProfit){
                maxProfit=profit;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args){
        int[] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));//5
    }
}

package Arrays;

import java.util.Arrays;
import java.util.Stack;

/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        int[] ans=new int[n];
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
                int index=stack.pop();
                ans[index]=i-index;
            }
            stack.push(i);
        }
        return ans;
    }
    public static int[] dailyTemperaturesOptimized(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        int highest = temperatures[n-1];
        for(int i=n-2; i>=0; i--){
            int temp = temperatures[i];
            if(temp >= highest)
                highest = temp;
            else{
                int j = i+1;
                while(temperatures[j] <= temp)
                    j = j + ans[j];
                ans[i] = j - i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr1={30,60,90},arr2={30,40,50,60},arr3={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(arr1)));//[1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(arr2)));//[1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperatures(arr3)));//[1,1,4,2,1,1,0,0]
        System.out.println(Arrays.toString(dailyTemperaturesOptimized(arr1)));//[1,1,0]
        System.out.println(Arrays.toString(dailyTemperaturesOptimized(arr2)));//[1,1,1,0]
        System.out.println(Arrays.toString(dailyTemperaturesOptimized(arr3)));//[1,1,4,2,1,1,0,0]
    }
}

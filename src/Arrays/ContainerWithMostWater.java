package Arrays;
/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container, such that the container contains the most water.
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
 */
public class ContainerWithMostWater {
    //Set left and right pointers loop through until left<right
    //To calculate area=take min of(arr[left] and arr[right]) then multiply it with (right-left)
    //if it is greater than previous are make it max area
    //increase left and right if  they are less or equal to min of(arr[left] and arr[right])
    public static int maxArea(int[] height) {
        int water=0,n= height.length,left=0,right=n-1;
        while (left<right){
            int h=Math.min(height[left],height[right]);
            water=Math.max((right-left)*h,water);
            while (left<right && height[left]<=h){
                left++;
            }
            while (left<right && height[right]<=h){
                right--;
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(arr));//49
    }
}

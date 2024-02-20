package Arrays;
/*
Given n non-negative integers representing an elevation map where the width of each bar is 1,
compute how much water it can trap after raining.

Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
In this case, 6 units of rain water (blue section) are being trapped.
 */
public class TrappingRainWater {
    private static int trap(int[] height){
        //We set two pointers left=0 and right=n-1
        //Set leftMax and rightMax such that arr[left] and arr[right]
        int left=0,right= height.length-1,water=0;
        int leftMax=height[left],rightMax=height[right];
        while(left<right){// loop runs till left<right
            if(leftMax<rightMax){//if leftMax is smaller than rightMax
                left++;//Increase left
                //if leftMax<height[left] change leftMax=height[left]
                //Else water+=leftMax-height[left]
                if(leftMax<height[left]){
                    leftMax=height[left];
                }else{
                    water+=leftMax-height[left];
                }
            }else {
                //decrease right
                //if rightMax<height[right] change rightMax=height[right]
                //Else water+=rightMax-height[right]
                right--;
                if(rightMax<height[right]){
                    rightMax=height[right];
                }else{
                    water+=rightMax-height[right];
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        int[] arr={4,2,0,3,2,5};
        System.out.println(trap(arr));//9
    }
}

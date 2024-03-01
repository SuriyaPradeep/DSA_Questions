package Strings;

import java.util.Arrays;

/*
Write a function that reverses a string. The input string is given as an array of characters s.
You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int l=0,r=s.length-1;
        while(l<r){
            char temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] str={'h','e','l','l','o'};
        reverseString(str);
        System.out.println(Arrays.toString(str));//olleh

    }
}

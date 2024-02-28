package Strings;
/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestRepeatingCharacterReplacement {
    public static int characterReplacement(String s, int k) {
        int left=0,max=0,mostFreq=0,n=s.length();
        int[] letterFrequency=new int[26];
        for(int right=0;right<n;right++){
            letterFrequency[s.charAt(right)-'A']++;
            mostFreq=Math.max(mostFreq,letterFrequency[s.charAt(right)-'A']);
            int letterChange=(right-left+1)-mostFreq;
            if(letterChange>k){
                letterFrequency[s.charAt(left)-'A']--;
                left++;
            }
            max=Math.max(max,right - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        String s1="ABAB",s2="AABABBA";
        int k1=2,k2=1;
        System.out.println(characterReplacement(s1,k1));//4
        System.out.println(characterReplacement(s2,k2));//4
    }
}

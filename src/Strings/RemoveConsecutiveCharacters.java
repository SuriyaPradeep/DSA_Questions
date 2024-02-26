package Strings;
/*
Given a string S. For each index i(1<=i<=N-1), erase it if s[i] is equal to s[i-1] in the string.
Example 1:
Input:
S = aabb
Output:  ab
Explanation: 'a' at 2nd position is
appearing 2nd time consecutively.
 */
public class RemoveConsecutiveCharacters {
    public static String removeConsecutiveCharacter(String S){
        int n=S.length();
        StringBuilder s= new StringBuilder();
        for(int i=0;i<n;i++){
            if(i+1<n && S.charAt(i)==S.charAt(i+1)){
                continue;
            }
            s.append(S.charAt(i));
        }
        return s.toString();
    }

    public static void main(String[] args) {
        String s1="aabb",s2="aabaa";
        System.out.println(removeConsecutiveCharacter(s1));//ab
        System.out.println(removeConsecutiveCharacter(s2));//aba
    }
}

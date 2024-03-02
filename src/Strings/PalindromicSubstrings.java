package Strings;
/*Given a string s, return the number of palindromic substrings in it.
A string is a palindrome when it reads the same backward as forward.
A substring is a contiguous sequence of characters within the string.
 */
public class PalindromicSubstrings {
    public static int countSubstrings(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int count=0;
        for(int i=0;i<s.length();i++){
            count+=palindrome(s,i,i);//odd
            count+=palindrome(s,i,i+1);//even
        }
        return count;
    }
    private static int palindrome(String s,int l,int r){
        int count=0;
        while ((l>=0 && r<s.length())&& s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s1="abc",s2="aaa";
        System.out.println(countSubstrings(s1));//3
        System.out.println(countSubstrings(s2));//6
    }
}

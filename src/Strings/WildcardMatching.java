package Strings;

import java.util.Arrays;

/*
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).
 */
public class WildcardMatching {
    public static boolean isMatch1(String s, String p) {
        int m=s.length(),n=p.length();
        boolean[][] matching=new boolean[m+1][n+1];//By default all false
        matching[0][0]=true;
        for(int j=1;j<=n;j++){
            if(p.charAt(j-1)=='*'){
                matching[0][j]=true;
            }else{
                break;
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(p.charAt(j-1)=='*'){
                    matching[i][j]=matching[i-1][j]||matching[i][j-1];
                }else{
                    matching[i][j]=matching[i-1][j-1]&&(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?');
                }
            }
        }
        print2D(matching);
        return matching[m][n];
    }
    private static void print2D(boolean arr[][]) {
        // Loop through all rows
        for (boolean[] row : arr)
            // converting each row as string
            // and then printing in a separate line
            System.out.println(Arrays.toString(row));
    }
    public static boolean isMatch2(String str, String pattern) {
        int p=0,s=0,startIdx=-1,lastMatch=-1;
        while(s<str.length()){
            // advancing both pointers
            if(p<pattern.length() && (str.charAt(s)==pattern.charAt(p) || pattern.charAt(p)=='?')){
                s++;
                p++;
            }
            // * found, only advancing pattern pointer
            else if(p<pattern.length() && pattern.charAt(p)=='*'){
                startIdx=p;
                lastMatch=s;
                p++;
            }
            // last pattern pointer was *, advancing string pointer
            else if(startIdx!=-1){
                p=startIdx+1;
                lastMatch++;
                s=lastMatch;
            }
            //current pattern pointer is not star, last patter pointer was not *
            //characters do not match
            else{
                return false;
            }
        }//check for remaining characters in pattern
        while (p < pattern.length() && pattern.charAt(p) == '*') {
            p++;
        }
        return p == pattern.length();
    }
    public static void main(String[] args) {
        String s1="aa",s2="cb",s3="xaylmz";
        String p1="a",p2="*",p3="?a",p4="x?y*z";
        System.out.println(isMatch1(s1,p1));//false
        System.out.println(isMatch1(s1,p2));//true
        System.out.println(isMatch1(s2,p3));//false
        System.out.println(isMatch1(s3,p4));//true
        System.out.println();
        System.out.println(isMatch2(s1,p1));//false
        System.out.println(isMatch2(s1,p2));//true
        System.out.println(isMatch2(s2,p3));//false
        System.out.println(isMatch2(s3,p4));//true
    }
}

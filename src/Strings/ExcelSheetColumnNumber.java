package Strings;
/*
Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.
 */
public class ExcelSheetColumnNumber {
    public static int titleToNumber(String columnTitle) {
        int res=0;
        for(char c:columnTitle.toCharArray()){
            res*=26;
            res+=c-'A'+1;
        }
        return res;
    }
    public static void main(String[] args) {
        String s1="AB",s2="ZY",s3="A";
        System.out.println(titleToNumber(s1));//28
        System.out.println(titleToNumber(s2));//701
        System.out.println(titleToNumber(s3));//1
    }
}

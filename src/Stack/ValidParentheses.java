package Stack;


import java.util.Stack;

/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('||c=='{'||c=='['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char bracket=stack.pop();
                if(c==')' && bracket!='('||c=='}' && bracket!='{'||c==']' && bracket!='['){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1="()",s2="()[]{}",s3="(]",s4="{[]";
        System.out.println(isValid(s1));//true
        System.out.println(isValid(s2));//true
        System.out.println(isValid(s3));//false
        System.out.println(isValid(s4));//false
    }
}

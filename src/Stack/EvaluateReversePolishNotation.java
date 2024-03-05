package Stack;

import java.util.Stack;

/*
You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
Evaluate the expression. Return an integer that represents the value of the expression.
Note that:
The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
Example 1:
Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack=new Stack<>();
        int a,b;
        for(String s:tokens){
            if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")){
                b=stack.pop();
                a=stack.pop();
                stack.push(operations(a,b,s));
            }else{
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    private static int operations(int a,int b,String operand){
        switch (operand){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "/":
                return a/b;
            case "*":
                return a*b;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        String[] s1={"2","1","+","3","*"},s2={"4","13","5","/","+"},s3={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(s1));//9
        System.out.println(evalRPN(s2));//6
        System.out.println(evalRPN(s2));//22
    }
}

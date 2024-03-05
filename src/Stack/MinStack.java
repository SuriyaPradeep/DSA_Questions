package Stack;
/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
MinStack() initializes the stack object.
void push(int val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
You must implement a solution with O(1) time complexity for each function.
 */
public class MinStack {
    private class Node{
        private int value;
        private int min;
        private Node next;
        public Node(int value,int min,Node next){
            this.value=value;
            this.min=min;
            this.next=next;
        }
    }

    Node head;

    public void push(int val){
        if(head==null){
            head=new Node(val,val,null);
        }else{
            head=new Node(val,Math.min(val,head.min),head);
        }
    }

    public void pop(){
        head=head.next;
    }

    public int top(){
        return head.value;
    }

    public int getMin(){
        return head.min;
    }

    public static void main(String[] args) {
        MinStack stack=new MinStack();
        stack.push(5);
        stack.push(2);
        stack.push(1);
        stack.push(6);
        System.out.println(stack.top());//6
        System.out.println(stack.getMin());//1
        stack.pop();
        System.out.println(stack.top());//1
        stack.pop();
        System.out.println(stack.getMin());//2
    }
}

package LinkedList;
/*
Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.
Example 1:
Input: head = [1,2,2,1]
Output: true
Example 2:
Input: head = [1,2]
Output: false
 */
public class PalindromeLinkedList {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean isPalindrome(ListNode head) {
        ListNode fastNode=head,slowNode=head,prevSlowNode=null;
        while(fastNode!=null && fastNode.next!=null){
            fastNode=fastNode.next.next;
            //Reverse
            ListNode slowNextNode=slowNode.next;
            slowNode.next=prevSlowNode;
            prevSlowNode=slowNode;
            slowNode=slowNextNode;
        }
        ListNode firstHalf=prevSlowNode,secondHalf=null;
        if(fastNode==null){
            secondHalf=slowNode;
        }else{
            secondHalf=slowNode.next;
        }
        while(firstHalf!=null && secondHalf!=null){
            if(firstHalf.val!=secondHalf.val){
                return false;
            }
            firstHalf=firstHalf.next;
            secondHalf=secondHalf.next;
        }
        return true;
    }
}

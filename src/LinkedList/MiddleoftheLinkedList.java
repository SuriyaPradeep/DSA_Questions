package LinkedList;
/*
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.
 */
public class MiddleoftheLinkedList {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
   public ListNode middleNode(ListNode head){
        ListNode fastPointer=head,slowPointer=head;
       while(fastPointer!=null && fastPointer.next!=null){
           fastPointer=fastPointer.next.next;
           slowPointer=slowPointer.next;
       }
       return slowPointer;
   }
   /*
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
*/
}
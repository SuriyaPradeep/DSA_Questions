package LinkedList;

import java.util.HashSet;

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.
 */
public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
      }
      //Using Hashset
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode>set=new HashSet<>();
        while (head!=null){
            if(!set.add(head)){
                return true;
            }
            head=head.next;
        }
        return false;
    }
    //Two Pointer
    public boolean hasCycle2(ListNode head) {
        ListNode slowPointer=head,fastPointer=head;
        while (fastPointer!=null && fastPointer.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
            if(slowPointer==fastPointer){
                return true;
            }
        }
        return false;
    }
}

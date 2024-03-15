package LinkedList;
/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Input: list1 = [], list2 = []
Output: []

Input: list1 = [], list2 = [0]
Output: [0]
 */
public class MergeTwoSortedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy= new ListNode(0);
        ListNode cur=dummy;
        while(list1!=null && list2!=null){
            int num1=list1.val;
            int num2=list2.val;
            ListNode value;
            if(num1<=num2){
                value=list1;
                list1=list1.next;
            }else{
                value=list2;
                list2=list2.next;
            }
            cur.next=value;
            cur=cur.next;
        }
        while(list1!=null){
            cur.next=list1;
            cur=cur.next;
            list1=list1.next;
        }
        while(list2!=null){
            cur.next=list2;
            cur=cur.next;
            list2=list2.next;
        }
        return dummy.next;
    }
}

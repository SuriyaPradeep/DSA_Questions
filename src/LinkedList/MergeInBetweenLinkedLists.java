package LinkedList;
/*
You are given two linked lists: list1 and list2 of sizes n and m respectively. Remove list1's nodes from the ath node to the bth node, and put list2 in their place. The blue edges and nodes in the following figure indicate the result: Build the result list and return its head. Example 1: Input: list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002] Output: [10,1,13,1000000,1000001,1000002,5] Explanation: We remove the nodes 3 and 4 and put the entire list2 in their place.
The blue edges and nodes in the above figure indicate the result.
 */

public class MergeInBetweenLinkedLists {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode ptr=list1;
        for(int i=0;i<a-1;i++){
            ptr=ptr.next;
        }
        ListNode qtr=ptr.next;
        for(int i=0;i<b-a+1;i++){
            qtr=qtr.next;
        }
        ptr.next=list2;
        while(list2.next!=null){
            list2=list2.next;
        }
        list2.next=qtr;
        return list1;
    }
}

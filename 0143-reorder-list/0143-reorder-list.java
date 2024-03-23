/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head==null || head.next==null) return;
        ListNode next=head.next;
        ListNode newHead=new ListNode(head.val);
        ListNode newItr=newHead;
        while(next!=null){
            ListNode newNext=new ListNode(next.val);
            newItr.next=newNext;
            newItr=newItr.next;
            next=next.next;
        }
        ListNode prev=newHead,curr=newHead.next;
        int nodes=1;
        prev.next=null;
        while(curr.next!=null){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp; 
            nodes++;
        }
        curr.next=prev;
        prev=head;
        while(nodes>0){
            nodes--;
            ListNode temp=prev.next;
            prev.next=curr;
            prev=prev.next;
            curr=temp;
        }
        prev.next=null;
    }
}
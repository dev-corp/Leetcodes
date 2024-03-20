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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start1=list1,end1,end2=list2;
        while(end2.next!=null) end2=end2.next;
        int cnt=0;
        while(cnt!=a-1){
            start1=start1.next;
            cnt++;
        }
        end1=start1.next;
        while(a!=b){
            end1=end1.next;
            a++;
        }
        start1.next=list2;
        end2.next=end1.next;
        end1.next=null;
        return list1;
    }
}
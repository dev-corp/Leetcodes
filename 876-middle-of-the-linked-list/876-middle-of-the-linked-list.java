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
class Solution 
{
    public ListNode middleNode(ListNode head)
    {
        ListNode fastPtr = head;//at starting fast pointer and slow pointer at the head
        ListNode slowPtr = head;
        while(fastPtr.next!=null && fastPtr.next.next!=null)
        {                                                   
            fastPtr = fastPtr.next.next;//while fast pointer increments by 2
            slowPtr = slowPtr.next;//but at each iteration slow pointer increments at 1
        }
        if(fastPtr.next!=null)
        {
            return slowPtr.next;
        }
        return slowPtr;
    }
}

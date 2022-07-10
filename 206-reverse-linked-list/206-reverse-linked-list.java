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
     public ListNode reverseList(ListNode head) 
     {
         //1 -> Make Dummy node null and connect to the 1 node of given list.
         //2 -> Point head to the next connecting node
        ListNode prev = null;
        ListNode curr = head;
        ListNode nextOne = null;
        
        while(curr!=null)
        {
            nextOne = curr.next;//head next to the dummy node
            curr.next = prev;//Point to next node
            prev = curr;
            curr = nextOne;
        }
        return prev;
    }
}

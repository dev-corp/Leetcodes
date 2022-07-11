/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution
{
    public boolean hasCycle(ListNode head)
    {
        if(head==null)
            return false;
                                // We will take 2 pointer 
        ListNode slowPtr = head;// Slow pointer iterate at 1 step
        ListNode fastPtr = head;// Fast pointer iterate at 2 step
                            // There is a certainty that there fast and slow pointer gonna meet if there is a cycle
        while(fastPtr.next != null && fastPtr.next.next != null)
        {    
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            
            if(slowPtr == fastPtr)
                return true;
        }
        return false;
    }
}
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
        ListNode newHead = null;//Initilize dummy node to null
        
        while (head != null) 
        {
            ListNode next = head.next;// we create new next and pointed to imidiate of next
            head.next = newHead;// we broke the hext pointer of head and pointed to dummy node
            newHead = head;// moved dummy node to head
            head = next;//move head to next head
        }
        return newHead;
    }
}

//         ListNode prev = null;
//         ListNode curr = head;
//         ListNode nextOne = null;
        
//         while(curr!=null)
//         {
//             nextOne = curr.next;//head next to the dummy node
//             curr.next = prev;//Point to next node
//             prev = curr;
//             curr = nextOne;
//         }
//         return prev;

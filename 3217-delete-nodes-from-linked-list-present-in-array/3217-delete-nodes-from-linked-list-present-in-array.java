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
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = -1;
        for(int num : nums ){
            max = num > max ? num : max;
        }
        boolean[] freq = new boolean[max+1];

        for(int num : nums) freq[num] = true;

        ListNode temp = new ListNode();
        ListNode current = temp;

        while(head != null){
            if( head.val >= freq.length || freq[head.val] == false){
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }

        current.next = null;
        return temp.next;
    }
}
/*
Approach
1. First, we find the largest number in the list to know how big our frequency array needs to be.
2. We create a frequency array (like a guest list) where True means the number is invited, and False means they aren't.
3. Then we walk through the linked list. If a node’s value is on the guest list (i.e., the frequency array says True), we skip it. If not, we add it to our new, modified linked list.
4. Finally, we return the new linked list that only contains the uninvited guests (nodes with values not in the array).
*/
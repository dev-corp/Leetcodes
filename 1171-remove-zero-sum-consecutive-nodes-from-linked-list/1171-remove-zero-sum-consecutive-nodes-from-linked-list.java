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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer,ListNode> map=new HashMap();
        ListNode root=new ListNode();
        root.next=head;
        map.put(0,root);

        int sum=0;
        ListNode node=head;
        while(node!=null){
            sum+=node.val;
            if(map.containsKey(sum)){
                ListNode prev=map.get(sum);
                int sum1=sum;
                prev=prev.next;
                while(prev!=node){
                    sum1+=prev.val;
                    map.remove(sum1);
                    prev=prev.next;
                }
                prev=map.get(sum);
                prev.next=node.next;
                node.next=null;
                node=prev.next;
            }
            else{
                map.put(sum,node);
                node=node.next;
            }
        }
        return root.next;
    }
}
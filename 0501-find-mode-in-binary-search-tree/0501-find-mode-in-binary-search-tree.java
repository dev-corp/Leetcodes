/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public static void calc(TreeNode root,HashMap<Integer,Integer> map){
        if(root==null) return;
        calc(root.left,map);
        calc(root.right,map);
        if(map.containsKey(root.val)) map.put(root.val,map.get(root.val)+1);
        else map.put(root.val,1);
        return;
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        calc(root,map);
        int max_rep=Collections.max(map.values());
        List<Integer> list = new ArrayList<>();
        for(int key:map.keySet()){
            if(map.get(key)==max_rep) list.add(key);
        }
        int arr[] = new int[list.size()];
        int i=0;
        for(int ele:list){
            arr[i]=ele;
            i++;
        }
        return arr;
    }
}
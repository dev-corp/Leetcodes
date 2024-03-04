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
    public List<Integer> rightSideView(TreeNode root) {
        HashMap<Integer,TreeNode> memo = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        solve(root,memo,ans,0);
        for(Map.Entry<Integer,TreeNode> e: memo.entrySet()){
            ans.add(e.getValue().val);
        }
        return ans;
    }
    private void solve(TreeNode root,HashMap<Integer,TreeNode> memo,List<Integer> ans,int currLevel){
        if(root==null) return;
        memo.put(currLevel,root);
        solve(root.left,memo,ans,currLevel+1);
        solve(root.right,memo,ans,currLevel+1);
        return;
    }
}
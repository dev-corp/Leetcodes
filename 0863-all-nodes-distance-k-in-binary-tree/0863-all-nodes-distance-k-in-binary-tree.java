/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        HashMap<TreeNode,TreeNode> memo = new HashMap<>();
        HashSet<TreeNode> visited = new HashSet<>();
        findParent(root,null,memo);
        solve(target,memo,visited,ans,k);
        return ans;
    }
    private void solve(TreeNode root,HashMap<TreeNode,TreeNode> memo,HashSet<TreeNode> set,List<Integer> ans,int k){
        if(root==null||set.contains(root)) return;
        if(k==0){
            ans.add(root.val);
            return;
        }
        set.add(root);
        solve(root.left,memo,set,ans,k-1);
        solve(root.right,memo,set,ans,k-1);
        solve(memo.get(root),memo,set,ans,k-1);
        return;
    }
    private void findParent(TreeNode root,TreeNode currParent,HashMap<TreeNode,TreeNode> memo){
        if(root==null) return;
        memo.put(root,currParent);
        findParent(root.left,root,memo);
        findParent(root.right,root,memo);
        return;
    }
}
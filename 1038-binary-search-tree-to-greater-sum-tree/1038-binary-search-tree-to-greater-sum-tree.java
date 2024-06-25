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
    int solve(TreeNode root,int sum)
    {
        if(root==null)
            return 0;
        int rightside=solve(root.right,sum);
        int leftside = solve(root.left,root.val+rightside+sum);
        int res=leftside+rightside+root.val;
        root.val+=rightside+sum;
        return res;
    }
    public TreeNode bstToGst(TreeNode root) 
    {
        solve(root,0);
        return root;
    }
}
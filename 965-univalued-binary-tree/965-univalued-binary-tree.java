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
    public boolean isUnivalTree(TreeNode root) {
       return isSame(root,root.val);
    }

    private boolean isSame(TreeNode root, int currentVal) {

        if(root == null) return true;

        if(root.val != currentVal) return false;

        boolean la = isSame(root.left,currentVal);
        boolean ra = isSame(root.right,currentVal);

        return la && ra;
    }
}

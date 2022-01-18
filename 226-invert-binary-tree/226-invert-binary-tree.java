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
   public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }
        
        TreeNode newNode = new TreeNode(root.val);
        
        if(root.left!=null && root.right!=null){
            TreeNode temp = root.left;
            root.left = root.right;
            newNode.left = invertTree(root.left);
            root.right = temp;
            newNode.right = invertTree(root.right);
        }
        
        if((root.left!=null && root.right==null)||(root.left==null && root.right!=null)){
             TreeNode temp = root.left;
            root.left = root.right;
            newNode.left = invertTree(root.left);
            root.right = temp;
            newNode.right = invertTree(root.right);
        }
        
        return newNode;
    }
}
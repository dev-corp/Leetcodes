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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        height(root, diameter);
        return diameter[0];        
    }

    private int height(TreeNode node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int left_height = height(node.left, diameter);// Either the max diameter will be present in left part of tree
        int right_height = height(node.right, diameter);//Or present in right part
        diameter[0] = Math.max(diameter[0], left_height + right_height);//or combined
        return 1 + Math.max(left_height, right_height); //returning the max diameter
    }
}
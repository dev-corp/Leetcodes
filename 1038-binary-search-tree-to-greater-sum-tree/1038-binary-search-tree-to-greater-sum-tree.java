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
class Solution
{
    // Helper function to transform the BST to GST
    int solve(TreeNode root,int sum)
    {
        // Base case: if the node is null, return 0
        if(root==null)
            return 0;
        
        // Recursively transform the right subtree and update the current node's value
        int rightside=solve(root.right,sum);
        
        // Recursively transform the left subtree, passing the updated sum including the current node's new value
        int leftside = solve(root.left,root.val+rightside+sum);
        
        // Calculate the total sum for the current subtree including the current node and the sum from nodes above
        int res=leftside+rightside+root.val;
        
        // Update the current node's value to include the sum of values greater than or equal to it
        root.val+=rightside+sum;
        
        // Return the total sum of the subtree rooted at the current node
        return res;
    }
    public TreeNode bstToGst(TreeNode root) 
    {
        solve(root,0);
        return root;
    }
}
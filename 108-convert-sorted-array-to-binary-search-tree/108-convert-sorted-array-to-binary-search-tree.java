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
    public TreeNode sortedArrayToBST(int[] nums) {
        return binarySearchTree(nums,0,nums.length-1);
    }
    
    public TreeNode binarySearchTree(int[] nums, int left, int right){
        
        if(right<left){
            return null;
        }
        
        int mid = (right-left)/2 + left;
        
        TreeNode newNode = new TreeNode(nums[mid]);
        
        newNode.left = binarySearchTree(nums,left,mid-1);
        newNode.right = binarySearchTree(nums,mid+1,right);
        
        return newNode;
        
    }

}
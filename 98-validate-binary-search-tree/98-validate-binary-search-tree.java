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
    public boolean isValidBST(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorderTraversal(root,answer);
        
        boolean isBST = true;
        for(int i = 1; i<answer.size(); i++){
            isBST = isBST && answer.get(i-1)<answer.get(i) ? true : false;
        }
        
        return isBST;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> answer){
        
        if(root==null){
            return;
        }
        
        inorderTraversal(root.left,answer);
        answer.add(root.val);
        inorderTraversal(root.right,answer);
        
        return;
        
    }

}
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
        return checkBst(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public boolean checkBst(TreeNode root, long min, long max){
        if(root == null)
            return true;
        if(root.val <= min || root.val >= max)
            return false;
        return  checkBst(root.left,min,root.val) && 
                checkBst(root.right,root.val,max);
    }

//     public boolean isValidBST(TreeNode root) {
//         List<Integer> answer = new ArrayList<>();
//         inorderTraversal(root,answer);
        
//         boolean isBST = true;
//         for(int i = 1; i<answer.size(); i++){
//             isBST = isBST && answer.get(i-1)<answer.get(i) ? true : false;
//         }
        
//         return isBST;
//     }
    
//     private void inorderTraversal(TreeNode root, List<Integer> answer){
        
//         if(root==null){
//             return;
//         }
        
//         inorderTraversal(root.left,answer);
//         answer.add(root.val);
//         inorderTraversal(root.right,answer);
        
//         return;
        
//     }

}
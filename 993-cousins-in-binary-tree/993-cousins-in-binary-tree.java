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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[]levels={-1,-1};
        TreeNode[]parents={null,null};
        findNodes(root,x,y,levels,parents,0,null);
        if(levels[0]==levels[1] && parents[0]!=parents[1]){
            return true;
        }
        return false;
    }
    private void findNodes(TreeNode root,int x,int y,int[]levels,TreeNode[]parents,int currentLevel,TreeNode currentParent){
        if(root==null){
            return;
        }
        if(root.val==x){
            levels[0]=currentLevel;
            parents[0]=currentParent;
        }
        if(root.val==y){
            levels[1]=currentLevel;
            parents[1]=currentParent;
        }
        findNodes(root.left,x,y,levels,parents,currentLevel+1,root);
        findNodes(root.right,x,y,levels,parents,currentLevel+1,root);
        return;
    }
}

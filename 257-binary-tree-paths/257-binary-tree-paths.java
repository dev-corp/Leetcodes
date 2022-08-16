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
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> answer = new ArrayList<>();
        rootToLeaf(root, "", answer);  
        return answer;
    }
    
    private void rootToLeaf(TreeNode root,String currentPath, List<String> answer)
    {
        if(root == null)
            return;
        
        if(root.left == null && root.right == null)
        {
            currentPath += Integer.toString(root.val);
            answer.add(currentPath);
            return;
        }
        
        currentPath += Integer.toString(root.val) + "->";
        rootToLeaf(root.left, currentPath, answer);
        rootToLeaf(root.right, currentPath, answer);
        return;
    }
    
}
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

public class Solution 
{
    public List<Integer> inorderTraversal(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null)
        {
            result.addAll(inorderTraversal(root.left));
            result.add(root.val);
            result.addAll(inorderTraversal(root.right));
        }
        return result;
    }
}

// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         List<Integer> answer = new ArrayList<>();
        
//         inorder(root, answer);
        
//         return answer;
//     }
    
//     private void inorder(TreeNode root, List<Integer> answer)
//     {
//         if(root == null)
//         {
//             return;
//         }

//         inorder(root.left, answer);
//         answer.add(root.val);
//         inorder(root.right, answer);
//         return;
//     }
// }
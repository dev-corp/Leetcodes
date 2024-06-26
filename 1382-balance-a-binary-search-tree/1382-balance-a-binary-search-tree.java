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
    List<Integer> arr;

    void inorder(TreeNode root)
    {
        if(root==null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    TreeNode constructBST(int low,int high)
    {
        if(low>high) 
            return null;
        int mid=(high-low)/2+low;
        TreeNode root=new TreeNode(arr.get(mid));
        root.left=constructBST(low,mid-1);
        root.right=constructBST(mid+1,high);
        return root;
    }

    public TreeNode balanceBST(TreeNode root)
    {
        arr=new ArrayList();
        inorder(root);
        return constructBST(0,arr.size()-1);
    }
}
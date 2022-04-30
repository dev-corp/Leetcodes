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


//Iterative Method
// import java.util.*;

// class Node {
//     int data;
//     Node left, right;
//     Node(int data) {
//         this.data = data;
//         left = null;
//         right = null;
//     }
// }
// class TUF {
//     static ArrayList < Integer > inOrderTrav(Node curr) {
//         ArrayList < Integer > inOrder = new ArrayList < > ();
//         Stack < Node > s = new Stack < > ();
//         while (true) {
//             if (curr != null) {
//                 s.push(curr);
//                 curr = curr.left;
//             } else {
//                 if (s.isEmpty()) break;
//                 curr = s.peek();
//                 inOrder.add(curr.data);
//                 s.pop();
//                 curr = curr.right;
//             }
//         }
//         return inOrder;
//     }

//     public static void main(String args[]) {

//         Node root = new Node(1);
//         root.left = new Node(2);
//         root.right = new Node(3);
//         root.left.left = new Node(4);
//         root.left.right = new Node(5);
//         root.left.right.left = new Node(8);
//         root.right.left = new Node(6);
//         root.right.right = new Node(7);
//         root.right.right.left = new Node(9);
//         root.right.right.right = new Node(10);

//         ArrayList < Integer > inOrder;
//         inOrder = inOrderTrav(root);

//         System.out.println("The inOrder Traversal is : ");
//         for (int i = 0; i < inOrder.size(); i++) {
//             System.out.print(inOrder.get(i) + " ");
//         }
//     }
// }

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
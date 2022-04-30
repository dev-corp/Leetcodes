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
    public List<Integer> postorderTraversal(TreeNode root) 
    {
        List<Integer> result = new ArrayList<Integer>();
        if (root != null)
        {
            result.addAll(postorderTraversal(root.left));
            result.addAll(postorderTraversal(root.right));
            result.add(root.val);
        }
        return result;
    }
}

//Iterative Single Stack Method
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
// public class TUF {
//     static ArrayList < Integer > postOrderTrav(Node cur) {

//         ArrayList < Integer > postOrder = new ArrayList < > ();
//         if (cur == null) return postOrder;

//         Stack < Node > st = new Stack < > ();
//         while (cur != null || !st.isEmpty()) {

//             if (cur != null) {
//                 st.push(cur);
//                 cur = cur.left;
//             } else {
//                 Node temp = st.peek().right;
//                 if (temp == null) {
//                     temp = st.peek();
//                     st.pop();
//                     postOrder.add(temp.data);
//                     while (!st.isEmpty() && temp == st.peek().right) {
//                         temp = st.peek();
//                         st.pop();
//                         postOrder.add(temp.data);
//                     }
//                 } else cur = temp;
//             }
//         }
//         return postOrder;


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

//         ArrayList < Integer > postOrder = new ArrayList < > ();
//         postOrder = postOrderTrav(root);

//         System.out.println("The postOrder Traversal is : ");
//         for (int i = 0; i < postOrder.size(); i++) {
//             System.out.print(postOrder.get(i) + " ");
//         }
//     }
// }



// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//         List<Integer> answer = new ArrayList<>();
        
//         postorder(root, answer);
        
//         return answer;
//     }
    
//     private void postorder(TreeNode root, List<Integer> answer)
//     {
//         if(root == null)
//         {
//             return;
//         }

//         postorder(root.left, answer);
//         postorder(root.right, answer);
//         answer.add(root.val);
//         return;
//     }
// }
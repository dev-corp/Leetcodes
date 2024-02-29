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
 **/
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) return false;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int level = -1;
        while(!queue.isEmpty()){
            level++;
            int size = queue.size(), prev = 0;
            for(int i = 0; i < size; i++){
                TreeNode curr = queue.poll();

                if(level == 0 && curr.val % 2 == 0){                        
                    return false;
                }
                if(i == 0){
                    if((level % 2 == 0 && curr.val % 2 == 1)
                    || (level % 2 == 1 && curr.val % 2 == 0)
                    ){                    
                        prev = curr.val;
                    }else{
                        return false;
                    }
                }
                else{                    
                    if (level % 2 == 1){
                        if(curr.val % 2 == 0 && prev > curr.val){
                            prev = curr.val;
                        }else{
                            return false;
                        }
                    }else{
                        if(curr.val % 2 == 1 && prev < curr.val){
                            prev = curr.val;
                        }else{
                            return false;
                        }
                    }
                }
                                        
                if(curr.left != null){
                    queue.add(curr.left);
                }
                
                if(curr.right != null){
                    queue.add(curr.right);
                }

            }
        }
        return true;
    }
}

// https://leetcode.com/problems/even-odd-tree/discuss/4797567/Beats-99.22-with-Proof-or-Very-Easy-to-Understand

// Intuition
// The intuition behind this solution is to perform a level-order traversal of the binary tree while checking the conditions for an Even-Odd tree at each level.

// Approach
// Use a queue to perform level-order traversal.
// Initialize a variable level to keep track of the current level (starting from 0).
// Iterate through the nodes at each level and check the conditions for an Even-Odd tree.
// For even-indexed levels (level % 2 == 0), check if the values are odd and strictly increasing.
// For odd-indexed levels (level % 2 == 1), check if the values are even and strictly decreasing.
// If any condition is violated, return false. Otherwise, continue the traversal.
// If the traversal completes without any violations, return true.
// Complexity
// Time complexity: $$O(n)$$
// where n is the number of nodes in the tree (each node is visited once).

// Space complexity: $$O(m)$$
// where m is the maximum number of nodes at any level in the tree (maximum size of the queue). In the worst case, the last level of the tree might have roughly half of the nodes, so m is approximately n/2.
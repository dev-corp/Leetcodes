/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
    
    void solve(TreeNode* root, vector<int>& m, int cnt, int& ans) {
        if (!root) {
            return;
        }
        m[root->val]++;
        cnt++;
        if (!root->left && !root->right) {
            int odd = 0;
            for (int p : m) {
                if (p%2 == 1) {
                    if (odd) {
                        odd = 2;
                        break;
                    } else {
                        odd = 1;
                    }
                }
            }
            if (odd==0 || odd == cnt%2) {
                ans++;
            }
            m[root->val]--;
            return;
        }
        solve(root->right, m, cnt, ans);
        solve(root->left, m, cnt, ans);
        m[root->val]--;
        cnt--;
        return;
    }
    
public:
    int pseudoPalindromicPaths (TreeNode* root) {
        int ans = 0;
        int cnt = 0;
        vector<int> m(10, 0);
        solve(root, m, cnt, ans);
        return ans;
    }
};
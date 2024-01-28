#define ll long long
class Solution {
public:
    int numSubmatrixSumTarget(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        ll dp[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (j)  dp[i][j] = matrix[i][j] + dp[i][j-1];
                else    dp[i][j] = matrix[i][j];
            }
        }
        for (int j=0; j<n; j++) {
            for (int i=0; i<m; i++) {
                if (i)  dp[i][j] = dp[i][j] + dp[i-1][j];
            }
        }
        int cnt = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                for (int k=i; k<m; k++) {
                    for (int l=j; l<n; l++) {
                        ll s = dp[k][l];
                        if (i)  s -= dp[i-1][l];
                        if (j)  s -= dp[k][j-1];
                        if (i and j)    s += dp[i-1][j-1];
                        // if (s==0)   cout << "Si\n";
                        cnt += s==target;
                    }
                }
            }
        }
        return cnt;
    }
};
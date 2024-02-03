struct comp {
    bool operator() (pair<int, int>& a, pair<int, int>& b) {
        return a.first < b.first || (a.first < b.first && a.second < b.second);
    }
};

int min(int a, int b) {
    return a<b ? a : b;
}

class Solution {

    int k;
    
    int solve(int i, vector<int>& mx, vector<int>& a, vector<int>& dp) {
        if (i >= a.size()) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        int val = a[i] + solve(i+1, mx, a, dp);
        // val = max(val, min(k, a.size()-i)*mx[i] + solve(i+k, mx, a, dp));
        int mv = a[i];
        for (int j=2; j<=k; j++) {
            int last = i+(j-1);
            if (last >= a.size()) {
                break;
            }
            mv = max(mv, a[last]);
            val = max(val, mv*j + solve(last+1, mx, a, dp));
        }
        // cout << i << " " << val << "\n";
        return dp[i] = val;
    }
    
public:
    int maxSumAfterPartitioning(vector<int>& a, int k) {
        int n = a.size();
        this->k = k;
        priority_queue<pair<int,int>,vector<pair<int, int>>, comp> q;
        vector<int> mxTillNext(n);
        for (int i=n-1; i>=0; i--) {
            q.push({a[i], i});
            while(!q.empty() && q.top().second-i>=k) {
                q.pop();
            }
            mxTillNext[i] = q.top().first;
        }
        vector<int> dp(n, -1);
        return solve(0, mxTillNext, a, dp);
    }
};
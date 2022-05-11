class Solution
{
public:
    void helper(int i, int n, int k, vector<vector<int>> &ans, vector<int> v) 
    {
        if(k == 0)
        {
            ans.push_back(v);
            return;
        }
        for(int j=i+1;j<=n-k;j++)
        {
            v.push_back(j+1);
            helper(j,n,k-1,ans,v);
            v.pop_back();
        }
      
    }
    
    vector<vector<int>> combine(int n, int k) 
    {
        vector<vector<int>> ans;
        helper(-1,n,k,ans,vector<int>());
        return ans;
    }
};



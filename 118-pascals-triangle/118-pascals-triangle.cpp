class Solution {
public:

    vector<vector<int>> generate(int numRows) 
    {
        vector<vector<int>> v;

        for(int i=0;i<numRows;i++)
        {
            vector<int> ds(i+1,1);
            for(int j=1;j<i;j++)
                ds[j] = v[i-1][j-1] + v[i-1][j];
            v.push_back(ds);
        }

        return v;
    }
};
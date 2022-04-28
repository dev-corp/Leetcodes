class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) 
    {
        vector<int> ds;
        int n=nums.size();
        sort(nums.begin(), nums.end());
        nums.erase( unique( nums.begin(), nums.end() ), nums.end() );
        int j=0;
        
        for(int i=1;i<=n;i++)
        {
            if(i != nums[j])
                ds.push_back(i);
            else
                j++;
        }
        return ds;
    }
};
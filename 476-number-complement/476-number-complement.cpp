class Solution {
public:
//     vector<int> calc(int num)
//     {
//         int n=num;
//         vector<int> ds;
//         while(n!=0)
//         {
//             int temp = n%2;
//             temp == 0? ds.push_back(1):ds.push_back(0);
//             n/=2;
//         }
//         return ds;
//     }
    
//     int findComplement(int num) 
//     {
//         vector<int> ans = calc(num);
//         reverse(ans.begin(), ans.end());
        
//         int sum=0;
//         for(int i=0;i<ans.size();i++)
//             sum+=ans[ans.size()-i-1] * pow(2,i);
        
//         return sum;
//     }
    
    //method 2
    
    int findComplement(int num) 
    {
        int copy = num;
        int i=0;
        
        while(copy!=0)
        { 
            copy>>=1;
            num = num ^(1<<i);
            i++;
        }
        return num;
    }
};
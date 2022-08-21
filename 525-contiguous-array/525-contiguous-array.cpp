class Solution {
public:
    int findMaxLength(vector<int>& arr)
    {
        unordered_map<int, int> mp;
        int len=0, sum=0, n=arr.size();
        mp[0]=-1;
        //initially the sum is 0 at index -1
        
        for(int i=0;i<n;i++)
        {
            if(arr[i] == 0)
                sum=sum-1;
            else
                sum+=1;
            
            if(mp.find(sum)!=mp.end())
            {
                int temp=i-mp[sum];
                len=max(len, temp);
            }
            else
                mp[sum]=i;
        }
        return len;
    }
};



//treat 0s as -1 and 1s as +1 only
//agar starting ke 3 elemnts ka sum bhi 5 ha and strtng ke 10 elemnts ka sum bhi 5 that means unn 7 elemnts me equal no of 0s and 1s the tabhi +1 and -1 ke kaarad sum same hi rha

//hashmap of sum vs index ki kis index tak kya sum aarkha ha and we will look ki kaha pr jaake sum ki value is repeating
//agar voh vala sum phle aaya ha so we will index uska and length nikalnge by subtrctng currnt index and 
//voh vala index 
//if curnt length > glbl length, update glbl length to this crrnt length
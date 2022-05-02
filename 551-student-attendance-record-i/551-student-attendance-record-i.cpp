class Solution
{
public:
    bool checkRecord(string s)
    {
        int ca=0,cl=0,n=s.size();
        bool a=true;
        
        for(int i=0;i<n;i++)
        {
            if(s[i] == 'L')
            {
                cl++;
                if(cl>2)
                    a = false;
            }

            else
            {
                cl=0;
                if(s[i] == 'A')
                {    
                    ca++;
                    if(ca>=2)
                        a = false;
                }
            }
        }
              
        return (a == true);
    }
};
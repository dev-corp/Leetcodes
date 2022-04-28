class Solution {
    public boolean isSubsequence(String s, String t) 
    {
        if(s.length() > t.length())
            return false;
        
        int j=0;
        for(int i=0;i<t.length() && j<s.length();i++)
        {
             if(s.charAt(j)==t.charAt(i))
             {
                    j++;
            }
        }
        return(j == s.length());
        
        
        
        
        
        // if(j == s.length())
        //     return true;
        // else
        //     return false;
        // for(int i=0;i<s.length();i++)
        // {
        //     for(int j=0;j<t.length();j++)
        //     {
        //         if(s.charAt(i)==t.charAt(j))
        //             //t.deleteCharAt(j);
        //             t = t.substring(0, j) + t.substring(j + 1);
        //     }
        // }
        // if(s!=t)
        //     return true;
        // else
        //     return false;
    }
}
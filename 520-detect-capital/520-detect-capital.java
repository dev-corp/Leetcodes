class Solution {
    public boolean detectCapitalUse(String str)
    {
        int n=str.length();
        boolean ans1=true,ans2=true,ans3=false;
        int c1=0,c2=0;
        
        boolean first = Character.isUpperCase(str.charAt(0));
        for (int i=0; i<n; i++)
        {
            if(Character.isUpperCase(str.charAt(i)))
                c1++; 
            
            if(Character.isLowerCase(str.charAt(i)))
                c2++;
        }
        ans1 = c1 != n ? false:true;
        ans2 = c2 != n ? false:true;
           
        if(c2 == n-1 && first)
            ans3=true;

        return (ans1  || ans2 || ans3);   
    }
}
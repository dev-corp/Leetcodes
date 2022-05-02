// class Solution {
//     public boolean checkRecord(String s) 
//     {
//     		if (s.contains("LLL")) 
//                 return false;
    		
//     		String str = s.replaceAll("A", "");
    		
//     		if ((s.length() - str.length()) > 1)
//     		{
//     			return false;
//     		}
    		
    		
//         return true;
        
//     }
// }
class Solution 
{
    public boolean checkRecord(String s) 
    {
        int countA=0;
        int continuosL = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == 'A')
            {
                countA++;
                continuosL = 0;
            }
            else if(s.charAt(i) == 'L')
                continuosL++;
            else
                continuosL = 0;
            
            if(countA >1 || continuosL > 2 )
                return false;
        }
        return true;

    }
}
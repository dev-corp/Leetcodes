class Solution {
    public boolean checkRecord(String s) 
    {
    		if (s.contains("LLL")) return false;
    		
    		String str = s.replaceAll("A", "");
    		
    		if ((s.length() - str.length()) > 1)
    		{
    			return false;
    		}
    		
    		
        return true;
        
    }
}
// class Solution {
//     public boolean checkRecord(String s) {
//         for (int i=0;i<s.length();i++)
//         {
//             int tot_absent = 0, ;
//             if(s.charAt(i) == 'P')
//                 continue 
                
//             if(s.charAt(i) == 'A')
//             {
//                 tot_absent++;
//                 if(tot_absent >2)
//                     return false;
//             }
            
//             if(s.c)
//         }
//     }
// }
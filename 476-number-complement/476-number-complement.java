class Solution 
{
    public int findComplement(int num)
    {
        String binaryString=Integer.toBinaryString(num);
        StringBuilder str=new StringBuilder();
        for(int i=0;i<binaryString.length();i++)
        {
            if(binaryString.charAt(i)=='0')
            {
                str.append('1');
            }
            else
            {
                str.append('0');
            }
        }
        
        return Integer.parseInt(str.toString(),2);
    }
}
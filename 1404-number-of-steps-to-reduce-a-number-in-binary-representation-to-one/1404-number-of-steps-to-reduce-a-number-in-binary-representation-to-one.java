class Solution {
    public int numSteps(String s) {
        StringBuilder str=new StringBuilder(s);
        int ans=0;
        while(str.length()!=1){
            if(str.charAt(str.length()-1)=='1'){
                System.out.println("hi");
                ans++;
                while(str.length()>0 && str.charAt(str.length()-1)=='1'){
                    ans++;
                    str.deleteCharAt(str.length()-1);
                }
                System.out.println(ans);
                if(str.length()!=0) str.deleteCharAt(str.length()-1);
                str.append("1");
            }
            else{
                while(str.charAt(str.length()-1)=='0'){
                    ans++;
                    str.deleteCharAt(str.length()-1);
                }
            }
        }
        return ans;
    }
}
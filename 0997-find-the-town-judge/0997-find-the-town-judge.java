class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] in=new int[n+1];
        int[] out=new int[n+1];
        for(int[] t:trust){
            in[t[1]]++;
            out[t[0]]++;
        }
        int ans=-1;
        for(int i=1;i<=n;i++){
            if(in[i]==n-1 && out[i]==0){
                if(ans==-1) ans=i;
                else return -1;
            }
        }
        return ans;
    }
}
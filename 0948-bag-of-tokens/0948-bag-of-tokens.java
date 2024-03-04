class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int ans=0,score=0;
        int start=0,end=tokens.length-1;
        Arrays.sort(tokens);
        while(start<=end){
            if(tokens[start]<=power){
                score++;
                power-=tokens[start];
                start++;
            }
            else{
                if(score>0){
                    power+=tokens[end];
                    score--;
                    end--;
                }
                else break;
            }
            ans=Math.max(ans,score);
        }
        return ans;
    }
}
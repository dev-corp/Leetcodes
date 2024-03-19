class Solution {
    class Pair{
        int time,count;
        Pair(int time,int count){
            this.time=time;
            this.count=count;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char ch:tasks) freq[ch-'A']++;
        PriorityQueue<Pair> pq1=new PriorityQueue<Pair>((a,b)-> a.time!=b.time ? a.time-b.time : b.count-a.count);
        PriorityQueue<Pair> pq2=new PriorityQueue<Pair>((a,b)-> b.count-a.count);
        for(int i=0;i<26;i++){
            if(freq[i]!=0) pq1.add(new Pair(1,freq[i]));
        }
        int ans=1;
        while(!pq1.isEmpty() || !pq2.isEmpty()){
            while(!pq1.isEmpty() && pq1.peek().time<=ans) pq2.add(pq1.poll());
            if(!pq2.isEmpty()){
                Pair pair=pq2.poll();
                if(pair.count-1!=0) pq1.add(new Pair(ans+n+1,pair.count-1));
                ans++;
            }
            else{
                if(!pq1.isEmpty()) ans=pq1.peek().time;
            }
        }
        return ans-1;
    }
}
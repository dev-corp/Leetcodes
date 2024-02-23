class Solution {
    class Triplet{
        int node,weight,via;
        Triplet(int node,int weight,int via){
            this.node=node;
            this.weight=weight;
            this.via=via;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<Triplet> queue=new PriorityQueue<Triplet>((a,b) -> b.via-a.via);
        List<Pair<Integer,Integer>>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList();
        for(int[] flight:flights){
            adj[flight[0]].add(new Pair(flight[1],flight[2]));
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        queue.add(new Triplet(src,0,k));
        while(!queue.isEmpty()){
                Triplet curr=queue.poll();
                // if(curr.node==dst) return curr.weight;
                if(curr.via>=0){
                    for(Pair<Integer,Integer> next:adj[curr.node]){
                        if(dist[next.getKey()]>next.getValue()+curr.weight){
                            queue.add(new Triplet(next.getKey(),next.getValue()+curr.weight,curr.via-1));
                            dist[next.getKey()]=next.getValue()+curr.weight;
                        }
                    }
                }
            }
        return dist[dst]==Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
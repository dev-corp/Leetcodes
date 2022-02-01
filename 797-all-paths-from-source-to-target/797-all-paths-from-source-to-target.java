class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> list = new ArrayList<>();
        boolean visited[] = new boolean[n];
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph,graph[0],n-1,path,list);
        return list;
    }
    
    public void dfs(int[][] graph, int arr[], int target, List<Integer> path, List<List<Integer>> list){
        for(int elem : arr){
            path.add(elem);
            if(elem==target){
                list.add(new ArrayList<>(path));
            }
            dfs(graph,graph[elem],target,path,list);
            path.remove(path.size()-1);
        }
    }
}

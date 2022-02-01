class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        
        dfs(graph, 0, path, res);
        return res;
    }
    
    public void dfs(int[][] graph, int node, List<Integer> path, List<List<Integer>> res){
        if(node == graph.length - 1){
            res.add(new ArrayList<>(path));
            return;
        }
        
        for(Integer childNode : graph[node]){
            path.add(childNode);
            dfs(graph, childNode, path, res);
            path.remove(path.size() - 1);
        }
        return;
    }
}

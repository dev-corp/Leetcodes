class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> arr=new ArrayList();
        int i=0;
        boolean flag=true;
        while(i<intervals.length){
            if(newInterval[0]>=intervals[i][0] && newInterval[0]<=intervals[i][1]){
                arr.add(new ArrayList(Arrays.asList(Math.min(newInterval[0],intervals[i][0]),Math.max(newInterval[1],intervals[i][1]))));
                i++;
                flag=false;
                break;
            }
            else if(newInterval[0]<intervals[i][0]){ 
                arr.add(new ArrayList(Arrays.asList(newInterval[0],newInterval[1])));
                flag=false;
                break;
            }
            else arr.add(new ArrayList(Arrays.asList(intervals[i][0],intervals[i][1])));
            i++;
        }
        if(i==intervals.length && flag){
            arr.add(new ArrayList(Arrays.asList(newInterval[0],newInterval[1])));
        }
        while(i<intervals.length){
            if(intervals[i][0]>=arr.get(arr.size()-1).get(0) && intervals[i][0]<=arr.get(arr.size()-1).get(1)){
                arr.get(arr.size()-1).set(0,Math.min(intervals[i][0],arr.get(arr.size()-1).get(0)));
                arr.get(arr.size()-1).set(1,Math.max(intervals[i][1],arr.get(arr.size()-1).get(1)));
            }
            else arr.add(new ArrayList(Arrays.asList(intervals[i][0],intervals[i][1])));
            i++;
        }
        int[][] ans=new int[arr.size()][2];
        i=0;
        for(List<Integer> next:arr){
            ans[i][0]=next.get(0);
            ans[i++][1]=next.get(1);
        }
        return ans;
    }
}
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)-> a[1]!=b[1] ? a[1]-b[1] : a[0]-b[0]);
        int ans=1,point=points[0][1];
        for(int i=1;i<points.length;i++)
        {
            if(points[i][0]<=point && points[i][1]>=point)
                continue;
            ans++;
            point=points[i][1];
        }
        return ans;
    }
}
class Solution {
    public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int i = 0;
        int s = 0; //record the start index of the left and right sides of the peaks
        int sum = 1; //initialize as 1 because in each round we minus 1 for the left bottom 
                   //since it was calculated once in the previous round
        while(i < n-1){
            //calculate the length from bottom -> peak on the left side of peak point, peak not included
            while(i < n-1 && ratings[i+1] > ratings[i]){
                i++;
            }
            int left = i-s;
            s = i;
            //calculate the length from peak-> bottom on the right side of peak point, peak not included
            while(i < n-1 && ratings[i+1] < ratings[i]){
                i++;
            }
            int right = i-s;
            s = i;
            //calculate the candies that needs to be assign to the peak
            int max = Math.max(left, right)+1;
            //total candies needed for current bottom->peak->bottom sub array
            sum += (1+left)*left/2+(1+right)*right/2+max-1;
            //skip points that have same value, increase i and final result by 1
            while(i < n-1 && ratings[i+1] == ratings[i]){
                i++;
                sum++;
            }
            s = i;
        }
        
        return sum;
    }
}
// https://leetcode.com/problems/candy/discuss/42770/One-pass-constant-space-Java-solution
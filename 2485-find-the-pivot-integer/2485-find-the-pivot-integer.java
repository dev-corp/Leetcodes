class Solution {
    public int pivotInteger(int n) {
        int[] arr=new int[n+1];
        for(int i=1;i<n+1;i++){
            arr[i]+=arr[i-1]+i;
        }
        for(int i=1;i<n+1;i++){
            if(arr[i]==arr[n]-arr[i-1]) return i;
        }
        return -1;
    }
}
class Solution {
    public boolean isMonotonic(int[] A) {
     boolean increasing = false, decreasing = false;
     for(int i = 1; i< A.length; i++){
         if(A[i] < A[i-1]) decreasing = true;
         if(A[i] > A[i-1]) increasing = true;
     }
     return increasing && decreasing ? false: true;
    }
}
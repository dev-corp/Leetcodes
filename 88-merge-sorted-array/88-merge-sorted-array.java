class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    for (int i = m; i<m+n; i++) 
    {
        nums1[i] = nums2[i-m];
    }
    
    Arrays.sort(nums1);
    }
}

// class Solution 
// {
//     public void merge(int[] nums1, int m, int[] nums2, int n)
//     {
//     int finished = m+n-1;
//     int tail1 = m-1;
//     int tail2 = n-1;
    
//     while(tail1>=0 && tail2>=0){
//         if(nums1[tail1]> nums2[tail2]){
//             nums1[finished--] = nums1[tail1--];
//         }
//         else
//          nums1[finished--] = nums2[tail2--];   
//     }
    
//     while(tail2 >=0)
//         nums1[finished--] = nums2[tail2--];
//     }
// }
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }
}























// class Solution 
// {
//     public int[] sortArrayByParity(int[] nums) 
//     {
//         for(int i=0;i<nums.length;i++)
//         {
//             for(int j=1;j<nums.length-1;j++)
//             {
//                 if(nums[i]%2 == 0)
//                 {
//                     int temp = nums[i];
//                     nums[i++] = nums[j];
//                     nums[j] = temp;
//                 }
//             }
//         }
//         return nums;
//     }
// }

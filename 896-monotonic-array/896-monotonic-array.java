class Solution
{
    public boolean isMonotonic(int[] A) 
    {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) 
        {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
        // int i=0;
        // if(arr[i]>arr[i+1])
        // {
        //     while(i<arr.length)
        //     {
        //         if(arr[i]>arr[i+1])
        //             i++;
        //     }
        // }
        // else if(arr[i]<arr[i+1])
        // {
        //     while(i<arr.length)
        //     {
        //         if(arr[i]>arr[i+1])
        //             i++;
        //     }
        // }
        // if(i == arr.length)
        //     return true;
        // else
        //     return false;
    }
}
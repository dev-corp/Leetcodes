class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        return -1;
    }
}

// Two pointer Approach

    // Initialize Pointers: Initialize two pointers, i and j, both starting from the beginning of the sorted arrays.
    // Find Common Element: Use a while loop that continues until either i or j reaches the end of their respective arrays or a common element is found.
    // Check if nums1[i] equals nums2[j]. If true, return this common element.
        // If nums1[i] < nums2[j], increment i.
        // If nums2[j] < nums1[i], increment j.
    // Return -1 if No Common Element Found: If the loop completes without finding a common element, return -1.
    // Time Complexity: O(n + m)
    // Space Complexity: O(1)
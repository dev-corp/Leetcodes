class Solution {
    public int trap(int[] height) {
        int n = height.length;

        // Initialize arrays to store the maximum height to the left and right of each position
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        // The maximum height to the left of the first position is its own height
        maxLeft[0] = height[0];

        // The maximum height to the right of the last position is its own height
        maxRight[n - 1] = height[n - 1];

        // For each position from left to right
        for (int i = 1; i < n; i++) {
            // The maximum height to the left of the current position is the maximum of the maximum height to the left of the previous position and the height of the current position
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }

        // For each position from right to left
        for (int i = n - 2; i >= 0; i--) {
            // The maximum height to the right of the current position is the maximum of the maximum height to the right of the next position and the height of the current position
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }

        int totalWaterTrapped = 0;

        // For each position
        for (int i = 0; i < n; i++) {
            // The amount of water that can be trapped at the current position is the minimum of the maximum height to the left and the maximum height to the right minus the height of the current position
            totalWaterTrapped += Math.abs(Math.min(maxLeft[i], maxRight[i]) - height[i]);
        }

        // Return the total amount of water that can be trapped
        return totalWaterTrapped;
    }
}
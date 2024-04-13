class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0, rows = matrix.length, cols = matrix[0].length;

        // Initialize a grid to store the height of the rectangle at each position
        int[][] heights = new int[rows][cols];

        // For each position in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the current position is in the first row, the height of the rectangle is the value of the current position
                if (i == 0) heights[i][j] = matrix[i][j] - '0';
                // Otherwise, if the value of the current position is '0', the height of the rectangle is 0
                // If the value of the current position is '1', the height of the rectangle is the height of the rectangle at the position above plus 1
                else heights[i][j] = matrix[i][j] - '0' == 0 ? 0 : heights[i - 1][j] + 1;
            }
        }

        // For each position in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the height of the rectangle at the current position is 0, skip this position
                if (heights[i][j] == 0) continue;

                int width = 1, left = j - 1, right = j + 1;

                // While the position to the left is within the grid and the height of the rectangle at the position to the left is greater than or equal to the height of the rectangle at the current position
                while (left >= 0 && heights[i][left] >= heights[i][j]) {
                    // Increase the width of the rectangle and move to the left
                    width++;
                    left--;
                }

                // While the position to the right is within the grid and the height of the rectangle at the position to the right is greater than or equal to the height of the rectangle at the current position
                while (right < cols && heights[i][right] >= heights[i][j]) {
                    // Increase the width of the rectangle and move to the right
                    width++;
                    right++;
                }

                // Update the maximum area of the rectangle
                maxArea = Math.max(maxArea, heights[i][j] * width);
            }
        }

        // Return the maximum area of the rectangle
        return maxArea;
    }
}
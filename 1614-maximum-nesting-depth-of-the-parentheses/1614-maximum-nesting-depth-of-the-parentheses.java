class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;

        // Iterate over each character in the string
        for (char c : s.toCharArray()) {
            // If the current character is '(', increment the current depth
            if (c == '(') {
                currentDepth++;
                // Update the maximum depth
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            // If the current character is ')', decrement the current depth
            else if (c == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
}
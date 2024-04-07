class Solution {
    public boolean checkValidString(String s) {
        int starCount = 0, openCount = 0;

        // First pass: Check from left to right
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(') {
                openCount++;
            } else if (currentChar == '*') {
                starCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else if (starCount > 0) {
                    starCount--;
                } else {
                    return false;
                }
            }
        }

        // If there are no unmatched open brackets, the string is valid
        if (openCount == 0) {
            return true;
        }

        // Second pass: Check from right to left
        starCount = 0;
        openCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);
            if (currentChar == ')') {
                openCount++;
            } else if (currentChar == '*') {
                starCount++;
            } else {
                if (openCount > 0) {
                    openCount--;
                } else if (starCount > 0) {
                    starCount--;
                } else {
                    return false;
                }
            }
        }

        // If we reach here, the string is valid
        return true;
    }
}
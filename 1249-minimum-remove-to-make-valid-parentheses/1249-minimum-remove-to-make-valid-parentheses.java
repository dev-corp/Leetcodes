class Solution {
    public String minRemoveToMakeValid(String s) {
        int openBracketsCount = 0;
        int index = 0;
        StringBuilder validString = new StringBuilder();

        // First pass: Remove all invalid ")"
        while (index < s.length()) {
            if (s.charAt(index) == ')') {
                if (openBracketsCount == 0) {
                    index++;
                    continue;
                } else {
                    openBracketsCount--;
                }
            } else if (s.charAt(index) == '(') {
                openBracketsCount++;
            }
            validString.append(s.charAt(index));
            index++;
        }

        // Second pass: Remove all invalid "(" from the end
        index = validString.length() - 1;
        int closeBracketsCount = 0;
        while (index >= 0) {
            if (validString.charAt(index) == '(') {
                if (closeBracketsCount == 0) {
                    validString.deleteCharAt(index);
                } else {
                    closeBracketsCount--;
                }
            } else if (validString.charAt(index) == ')') {
                closeBracketsCount++;
            }
            index--;
        }

        // Return the validString as a string
        return validString.toString();
    }
}
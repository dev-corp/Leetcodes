public class Solution {
    
    // Define a function to check if a string is a palindrome.
    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        // Iterate from both ends towards the center to check for equality.
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public String firstPalindrome(String[] words) {
        // Iterate through each word in the array.
        for (String word : words) {
            // If a palindrome is found, return it.
            if (isPalindrome(word)) {
                return word;
            }
        }

        // If no palindrome is found, return an empty string.
        return "";
    }
}
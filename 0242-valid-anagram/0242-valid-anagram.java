import java.util.HashMap;

class Solution {
    public boolean isAnagram(String s, String t) {
        // Initialize a HashMap to count the frequency of each character in string s
        HashMap<Character, Integer> charCount = new HashMap<>();

        // Iterate over each character in string s
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            // If the character is already in the HashMap, increment its count
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, charCount.get(currentChar) + 1);
            } else {
                // If the character is not in the HashMap, add it with a count of 1
                charCount.put(currentChar, 1);
            }
        }

        // Iterate over each character in string t
        for (int i = 0; i < t.length(); i++) {
            char currentChar = t.charAt(i);
            // If the character is in the HashMap, decrement its count
            if (charCount.containsKey(currentChar)) {
                charCount.put(currentChar, charCount.get(currentChar) - 1);
                // If the count of the character becomes 0, remove it from the HashMap
                if (charCount.get(currentChar) == 0) {
                    charCount.remove(currentChar);
                }
            } else {
                // If the character is not in the HashMap, return false
                // because string t has a character that string s does not have
                return false;
            }
        }

        // If the HashMap is empty, that means string t is an anagram of string s
        // because it has the same characters with the same frequency
        // If the HashMap is not empty, return false because string t has less characters than string s
        return charCount.isEmpty();
    }
}
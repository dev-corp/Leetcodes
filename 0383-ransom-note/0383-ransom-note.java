import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Initialize a HashMap to count the frequency of each character in the magazine
        Map<Character, Integer> count = new HashMap<>();

        // Iterate over each character in the magazine
        for (char c : magazine.toCharArray()) {
            // Increment the count of this character in the HashMap
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // Iterate over each character in the ransom note
        for (char c : ransomNote.toCharArray()) {
            // If this character is not in the HashMap or its count is 0,
            // return false because we can't construct the ransom note
            if (!count.containsKey(c) || count.get(c) == 0) {
                return false;
            }
            // Decrement the count of this character in the HashMap
            count.put(c, count.get(c) - 1);
        }

        // If we have not returned false, return true because we can construct the ransom note
        return true;
    }
}
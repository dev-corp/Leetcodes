class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Create a map to store the characters of the substring and their indices
        HashMap<Character,Integer> charToIndexMap = new HashMap<>();
        // Initialize maxLength to store the maximum length of the substring found so far
        int maxLength = 0;
        // Initialize substringStartIndex to represent the start of the current substring
        int substringStartIndex = 0;
        // Iterate over the string s
        for(int currentIndex = 0; currentIndex < s.length(); currentIndex++){ 
            // If the current character is already in charToIndexMap, update substringStartIndex
            if(charToIndexMap.containsKey(s.charAt(currentIndex))){
                substringStartIndex = Math.max(substringStartIndex, charToIndexMap.get(s.charAt(currentIndex)) + 1);
            }
            // Add the current character and its index to charToIndexMap
            charToIndexMap.put(s.charAt(currentIndex), currentIndex);
            // Update maxLength with the maximum of maxLength and the length of the current substring
            maxLength = Math.max(maxLength, currentIndex - substringStartIndex + 1);
        }
        // Return maxLength, which is the length of the longest substring without repeating characters
        return maxLength;
    }
}
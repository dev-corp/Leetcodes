class Solution {
    public String makeGood(String s) {
        StringBuilder goodString = new StringBuilder();

        // Iterate over each character in the string
        for (char currentChar : s.toCharArray()) 
        {
            // If the goodString is not empty and the last character in the goodString is the opposite case of the current character,
            // remove the last character from the goodString
            if (goodString.length() > 0 && Math.abs(currentChar - goodString.charAt(goodString.length() - 1)) == 32) 
            {
                goodString.deleteCharAt(goodString.length() - 1);
            } 
            else 
            {
                // Otherwise, append the current character to the goodString
                goodString.append(currentChar);
            }
        }
        // Return the goodString as a string
        return goodString.toString();
    }
}
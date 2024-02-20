class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> memo = new HashMap<>(); //  store the characters of the substring and their indices.
        int count=0; // keeps track of the current length of the substring without repeating characters
        int ans=0; //  stores the maximum length of the substring found so far
        int release=0; // represent the end of the current substring
        for(int acquire=0;acquire<s.length();acquire++) { // acquire represent the start of the current substring
            if(!memo.containsKey(s.charAt(acquire))){ // If the current character is not in memo, it's added to memo and count is incremented.
                count = count + 1;
                memo.put(s.charAt(acquire),acquire);
            }
            else { // updates ans with the maximum of ans and count, then it removes characters from the start of the substring until it removes the repeated character.
                ans = Math.max(ans,count); // updates ans one more time to account for the case where the longest substring is at the end of s.
                while(release<acquire&&memo.containsKey(s.charAt(acquire))){
                    memo.remove(s.charAt(release));
                    count = count - 1;
                    release = release + 1;
                }
                memo.put(s.charAt(acquire),acquire);
                count = count + 1;
            }
        }
        ans = Math.max(ans,count);
        return ans;
    }
}
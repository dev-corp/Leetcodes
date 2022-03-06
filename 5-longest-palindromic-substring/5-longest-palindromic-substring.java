class Solution {
    public String longestPalindrome(String s) {
        int maxlen = 0;
        int start = 0, end = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = findPalindrome(s, i, i);
            int len2 = findPalindrome(s, i, i+1);
            int templen = Math.max(len1, len2);
            if(templen > (end - start + 1)){
                start = i - (templen-1)/2;
                end = i+ templen/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    public int findPalindrome(String s, int start, int end){
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
}
class Solution {
    public char findTheDifference(String s, String t) {
        int i = -1,sum=0;
        while((++i)<s.length()) {
            sum += t.charAt(i)-s.charAt(i);
        }
        sum += t.charAt(i);
        return (char)sum;
    }
}
//https://leetcode.com/problems/find-the-difference/discuss/861918/Find-the-Difference-or-Java-or-O(1)-Space-or-Simple-Explained
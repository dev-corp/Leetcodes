class Solution {
 public String decodeAtIndex(String S, int K) {
        
        long curLength = 0;
        char c = 0;
        
        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (Character.isDigit(c)) { 
                curLength *= c - '0';
            }
            else { 
                curLength++;
            }
        }
        
        for (int i = S.length() - 1; i >= 0; i--) {
            c = S.charAt(i);
            if (Character.isDigit(c)) { 
                curLength /= c - '0';
                K %= curLength;
            }
            else {
                if (K == 0 || K == curLength) {
                    return "" + c;
                }
                curLength--;
            }
        }
        
        throw null;
    }
}
//Only the character in the Kth position matters rather than the whole string decoded, so we only keep track of curLength (long data type to avoid integer overflow).
//Let's see the code commented, first a1, a2, then b1, b2. They are matching except that we manage K in a2, b2.
//Since the result character can only be a letter rather than digit, in b2 we ought to check K. Whenever K % curLength == 0, we figure out the result.
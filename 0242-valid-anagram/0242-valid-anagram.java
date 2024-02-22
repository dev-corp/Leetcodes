class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> memo = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(memo.containsKey(s.charAt(i))){
                memo.put(s.charAt(i),memo.get(s.charAt(i))+1);
            }
            else {
                memo.put(s.charAt(i),1);
            }
        }
        for(int i=0;i<t.length();i++){
            if(memo.containsKey(t.charAt(i))){
                memo.put(t.charAt(i),memo.get(t.charAt(i))-1);
                if(memo.get(t.charAt(i))==0){
                    memo.remove(t.charAt(i));
                }
            }
            else {
                return false;
            }
        }
        return memo.size()==0?true:false;
    }
}
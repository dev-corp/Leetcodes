class Solution 
{
    public int tribonacci(int n) 
    {
        return nthFib(n,new HashMap<Integer,Integer>());
    }
    public int nthFib(int n,HashMap<Integer,Integer> memo)
    {
        if(n <= 1)
            return n;
        
        if(n == 2)
            return 1;
        
        int currentKey = n;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int a = nthFib(n-1, memo);
        int b = nthFib(n-2, memo);
        int c = nthFib(n-3, memo);
        
        memo.put(currentKey, a+b+c);
        
        return a+b+c;
    }
}
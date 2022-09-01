class Solution 
{
    public int fib(int n) 
    {
        return nthFib(n,new HashMap<Integer,Integer>());
    }
    public int nthFib(int n,HashMap<Integer,Integer> memo)
    {
        if(n<=1)
            return n;
        
        int currentKey = n;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        int a = nthFib(n-1, memo);
        int b = nthFib(n-2, memo);
        
        memo.put(currentKey, a+b);
        
        return a+b;
    }
}
class Solution 
{
    public boolean backspaceCompare(String S, String T) 
    {
        return stackSolution(S).equals(stackSolution(T));
    }
    
    private String stackSolution(String str) 
    {
        Stack<Character> stack = new Stack<Character>();
        
        for (char c : str.toCharArray()) 
        {
		
            if (c != '#') 
            {
                stack.push(c);
				
            } else if (!stack.isEmpty())
            {
                stack.pop();
            }
        }
        return stack.toString();
    }
}
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0)
        {
            return new int[0];
        }
        
        Stack<Integer> stack = new Stack<>();
        int []results = new int[temperatures.length];
        
        for (int day = 0;day<temperatures.length;day++)
        {
            int currentTemp = temperatures[day];
            
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp)
            {
                int prevDay = stack.pop();
                results[prevDay] = day - prevDay;
            }
            stack.push(day);
        }
        return results;
    }
}
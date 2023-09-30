class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int secondMax = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < nums[i])
            {
                secondMax = stack.pop(); // because secondMax will be nums[i] now.
            }
            // System.out.println(nums[i]+".."+ secondMax);
            if (nums[i] > secondMax) 
                stack.push(nums[i]); // this can be candidate for secondMax
            if (nums[i] < secondMax) 
                return true; // as we found number less than second Max.
        }
        return false;
    }
}
class Solution {
    public String removeKdigits(String num, int k) {
        // If k is greater than or equal to the length of the number, return "0"
        if (k >= num.length()) return "0";

        Stack<Character> digitStack = new Stack<>();

        // For each digit in the number
        for (int i = 0; i < num.length(); i++) {
            // While the stack is not empty, the top digit of the stack is greater than the current digit, and k is greater than 0
            while (!digitStack.isEmpty() && digitStack.peek() > num.charAt(i) && k > 0) {
                // Remove the top digit from the stack and decrement k
                digitStack.pop();
                k--;
            }
            // Add the current digit to the stack
            digitStack.add(num.charAt(i));
        }

        // While k is greater than 0
        while (k > 0) {
            // Remove the top digit from the stack and decrement k
            digitStack.pop();
            k--;
        }

        StringBuilder smallestNum = new StringBuilder();

        // While the stack is not empty
        while (!digitStack.isEmpty()) {
            // Append the top digit of the stack to the result and remove it from the stack
            smallestNum.append(digitStack.pop());
        }

        // Reverse the result to get the number in the correct order
        smallestNum.reverse();

        // While the result has more than one digit and the first digit is '0'
        while (smallestNum.length() > 1 && smallestNum.charAt(0) == '0') {
            // Remove the first digit from the result
            smallestNum.deleteCharAt(0);
        }

        // Return the result as a string
        return smallestNum.toString();
    }
}
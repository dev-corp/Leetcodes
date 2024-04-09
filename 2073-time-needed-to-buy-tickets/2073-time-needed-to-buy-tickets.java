class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int totalTimeRequired = 0;

        // For each ticket in the array
        for (int i = 0; i < tickets.length; i++) {
            // If the current ticket is at an index less than or equal to k
            if (i <= k) {
                // Add the smaller of the current ticket and the kth ticket to the total time
                totalTimeRequired += Math.min(tickets[i], tickets[k]);
            } else {
                // If the current ticket is at an index greater than k
                // Add the smaller of the current ticket and one less than the kth ticket to the total time
                totalTimeRequired += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        // Return the total time required to buy all the tickets
        return totalTimeRequired;
    }
}
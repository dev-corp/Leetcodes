class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Create a HashMap to store the frequency of each number in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Create a PriorityQueue to store the numbers and their frequencies.
        // The PriorityQueue is sorted by frequency in ascending order.
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            queue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        
        // Remove the least frequent numbers from the PriorityQueue until we have removed 'k' numbers
        while (!queue.isEmpty() && k > 0) {
            int[] top = queue.peek();
            if (k < top[1]) {
                break;
            }
            k -= top[1];
            queue.poll();
        }
        
        // The size of the PriorityQueue is the number of unique integers left in the array
        return queue.size();
    }
}
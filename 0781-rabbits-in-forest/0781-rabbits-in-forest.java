import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> count = new HashMap<>();
        int totalRabbits = 0;

        for (int answer : answers) {
            // If this is a new answer or we have found all the rabbits that gave this answer,
            // start a new group of rabbits that give the same answer
            if (count.getOrDefault(answer, 0) == 0) {
                totalRabbits += answer + 1;
                count.put(answer, answer);
            } else {
                // If we have not found all the rabbits that gave this answer,
                // decrement the count of this answer
                count.put(answer, count.get(answer) - 1);
            }
        }

        return totalRabbits;
    }
}
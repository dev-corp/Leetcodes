import java.util.*;

class Solution
{
    public int[] arrayRankTransform(int[] arr)
    {
        // Use a TreeSet to automatically sort and remove duplicates
        TreeSet<Integer> sortedSet = new TreeSet<>();
        for (int e : arr)
        {
            sortedSet.add(e);
        }

        // Create a map to store the rank of each element
        HashMap<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
        for (int e : sortedSet)
        {
            rankMap.put(e, rank++);
        }

        // Transform the original array to its rank array
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
        {
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}
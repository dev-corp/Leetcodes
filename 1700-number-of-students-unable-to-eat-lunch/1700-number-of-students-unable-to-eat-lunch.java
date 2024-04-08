class Solution
{
    public int countStudents(int[] students, int[] sandwiches) {
        int zeroPreferenceCount = 0, onePreferenceCount = 0, totalStudents = students.length;

        // Count the number of students who prefer each type of sandwich
        for (int preference : students) 
        {
            if (preference == 0)
                zeroPreferenceCount++;
            else
                onePreferenceCount++;
        }
        // For each sandwich in the stack
        for (int i = 0; i < totalStudents; i++)
        {
            // If the sandwich is of type 0
            if (sandwiches[i] == 0) 
            {
                // If there are students who prefer this type of sandwich, serve it
                if (zeroPreferenceCount > 0)
                    zeroPreferenceCount--;
                else 
                    // Otherwise, all remaining students prefer the other type of sandwich and cannot be served
                    return totalStudents - i;
            }
            else
            {
                // If the sandwich is of type 1
                // If there are students who prefer this type of sandwich, serve it
                if (onePreferenceCount > 0)
                    onePreferenceCount--;
                else 
                    // Otherwise, all remaining students prefer the other type of sandwich and cannot be served
                    return totalStudents - i;
            }
        }
        // If all sandwiches can be served, return 0
        return 0;
    }
}
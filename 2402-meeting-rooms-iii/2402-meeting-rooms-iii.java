class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] bookings = new int[n];
        long[] endTime = new long[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            boolean hasFoundRoom = false;
            int nextAvailableRoom = -1;
            long waitingDuration = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (endTime[j] < waitingDuration) {
                    waitingDuration = endTime[j];
                    nextAvailableRoom = j;
                }
                if (endTime[j] <= start) {
                    hasFoundRoom = true;
                    bookings[j]++;
                    endTime[j] = end;
                    break;
                }
            }
            if (!hasFoundRoom) {
                bookings[nextAvailableRoom]++;
                endTime[nextAvailableRoom] += (end - start);
            }
        }
    
        int maxBookings = -1, mostBookedRoom = -1;
        for (int i = 0; i < n; i++) {
            if (bookings[i] > maxBookings) {
                maxBookings = bookings[i];
                mostBookedRoom = i;
            }
        }
        return mostBookedRoom;
    }
}

//      Initialization:

// We initialize two vectors: ans to keep track of the number of meetings each person attends, and times to keep track of the end time of each person's last meeting.
// Both vectors are initialized with zeros.

//      Sorting Meetings:

// We sort the meetings based on their start times. This helps us process them in chronological order.

//      Processing Meetings:

// For each meeting, we find the person who has the earliest available time slot to attend the meeting.
// If there's a person available (i.e., their last meeting ends before the current meeting starts), we assign them to attend the meeting and update their end time.
// If no person is available, we find the person who has the earliest end time among all persons and assign them to attend the meeting. We also update their end time accordingly.

//      Finding Most Booked:

// After processing all meetings, we find the person who attended the maximum number of meetings.
// We iterate through the ans vector and find the person with the highest count of attended meetings.

//      Return Result:

// We return the ID of the person who attended the most meetings.
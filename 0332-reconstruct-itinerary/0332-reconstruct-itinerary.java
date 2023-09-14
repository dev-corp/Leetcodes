class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // dfs backtracking, each time we go to smallest lexical order airport
        HashMap<String, TreeMap<String, Integer>> map = new HashMap<>();   // key: Departure, (Arrival, Number of tickets available)
        
        for (List<String> ticket : tickets) {
            String dep = ticket.get(0);
            String arr = ticket.get(1);
            if (!map.containsKey(dep)) {
                map.put(dep, new TreeMap<>());
            }
            TreeMap<String, Integer> arrMap = map.get(dep);
            if (!arrMap.containsKey(arr)) {
                arrMap.put(arr, 0);
            }
            arrMap.put(arr, arrMap.get(arr)+1);
        }
        
        List<String> itinerary = new LinkedList<>();
        dfs(map, tickets.size(), itinerary, "JFK");
        
        itinerary.add(0, "JFK");
        return itinerary;
    }
    
    private boolean dfs(HashMap<String, TreeMap<String, Integer>> map, int numTickets, List<String> itinerary, String depAirport) {
        if (itinerary.size() == numTickets) {
            return true;
        }
        
        if (!map.containsKey(depAirport)) {
            return false;
        }
        
        TreeMap<String, Integer> arrMap = map.get(depAirport);
        for (Map.Entry<String, Integer> entry : arrMap.entrySet()) {
            String arrAirport = entry.getKey();
            int count = entry.getValue();
            // if no ticket availble, continue
            if (count == 0) {
                continue;
            }            
            // else make choice
            itinerary.add(arrAirport);
            arrMap.put(arrAirport, count-1);
            if (dfs(map, numTickets, itinerary, arrAirport)) {
                return true;
            }
            // revert back if no answer found
            itinerary.remove(itinerary.size()-1);
            arrMap.put(arrAirport, count);
        }
        
        return false;
    }
}
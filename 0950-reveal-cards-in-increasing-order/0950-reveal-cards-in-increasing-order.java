class Solution 
{
    public int[] deckRevealedIncreasing(int[] deck)
    {
        int deckSize = deck.length;
        int[] resultDeck = new int[deckSize];
        Queue<Integer> indexQueue = new LinkedList<>();
        // Add all indices to the queue
        for (int i = 0; i < deckSize; i++)
        {
            indexQueue.add(i);
        }
        // Sort the deck
        Arrays.sort(deck);
        // For each card in the deck
        for (int i = 0; i < deckSize; i++)
        {
            // Assign the card to the position indicated by the first index in the queue
            resultDeck[indexQueue.poll()] = deck[i];

            // If there are more indices in the queue, move the first one to the end
            if (!indexQueue.isEmpty()) 
            {
                indexQueue.add(indexQueue.poll());
            }
        }
        // Return the resulting deck
        return resultDeck;
    }
}
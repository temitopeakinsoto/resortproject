package bluej;

/**
 * interface WIRE specifies requirements for 7COM1015 Cwk 2 - Nov 2022
 * 
 * @author A.Marczyk 
 * @version 05/11/22
 */
public interface WIRE
{
    /**
     * Returns information about the resort including its location/name and all
     * cards currently on each island, or "No cards" (if no card on that island
     * @return all of the details of all islands including location 
     * and all cards currently on each island, or "No cards" if island has no cards
     */
    public String toString();

    /**Returns a String representation of all the cards on all islands
     * with "No cards" if there are no cards on an island
     * @return a String representation of all cards on all islands
     **/
    public String getAllCardsOnAllIslands();
    
    
    /**Returns the name of the island which contains the specified card or "Not found"
     * @param cd - the id of the card
     * @return the name of the island which contains the card, or "Not found"
     **/
    public String findCardLocation(int cd);
    
    /**Returns details of the card with the specified id or "Not found"
     * @param cd - the id of the card
     * @return the details of the card, or "Not found"
     **/
    public String viewACard(int cd);
    
    /**Returns the card object with the specified id or "Not found"
     * @param cd - the id of the card
     * @return the card object, or "Not found"
     **/
    public Card getACard(int cd);
    
    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl);
    
                
    /**Returns a String representation of all the cards on a specified island
     * @param isl - the name of the island
     * @return a String representation of all cards on specified island
     **/
    public String getAllCardsOnIsland(String isl);
  
    
     /**Returns true if a Card is allowed to journey using a ferry, false otherwise
     * A journey can be made if:  
     * the rating of the card  >= the rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits (a journey costs 3 credits)
     * AND the card is currently in the source island 
     * AND the card id and ferry code represent objects in the system
     * @param cdId is the id of the card requesting the move
     * @param ferCode is the code of the ferry journey by which the card wants to move
     * @return true if the card is allowed on the ferry journey, false otherwise 
     **/
    public boolean canTravel(int cdId, String ferCode);
    

    /**Returns the result of a card requesting to journey by Ferry.
     * A journey will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source island
     * AND both the card id and the ferry code is on the system
     * If the ferry journey can be made, the card is removed from the source island,
     * added to the destination island and a suitable message returned. Card 
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param pCardId is the id of the card requesting the move
     * @param ferCode is the code of the ferry by which the card wants to travel
     * @return a String giving the result of the request 
     **/
    public String travel(int pCardId, String ferCode );
    
    /** Allows credits to be added to a card.
     *  @param id the id of the card toping up their credits
     *  @param creds the number of credits to be added to card 
     */
    public void topUpCredits(int id, int creds);
  
  
    /** Converts a card's journey points into credits
     * @param id the id of the card whose points are to be converted
     */
    public void convertPoints(int id); 
    
}
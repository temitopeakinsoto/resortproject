package bluej;

/**
 * A ferry provides a one-way journey between two islands. It
 * has a ferry code and information about both the source and
 * the destination island
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ferry
{

    private String ferryCode;
    private Island sourceIsl;
    private Island destIsl;
    private static int ferryFare = 3;

    /** constructor
     * Assigns values to Ferry objects upon instantiation
     * @param fCode is the ferry code 
     * @param src is the source Island
     * @param dest is the destination Island
     */
    public Ferry(String fCode, Island src, Island dest)
    {
        ferryCode = fCode;
        sourceIsl = src;
        destIsl = dest;
    }

    /** getFerryCode() is a method for getting the ferry code of a Ferry
     * @paran - accepts no parameters
     * @return returns the ferryCode property
     */
    public String getFerryCode()
    {
        return ferryCode;
    }

    /** getSourceIsland() is a method for getting the source Island of a Ferry
     * @paran - accepts no parameters
     * @return - returns the source Island object property
     */
    public Island getSourceIsland()
    {
        return sourceIsl;
    }

    /** getDestinationIsland() is a method for getting the destination Island of a Ferry
     * @paran - accepts no parameters
     * @return - returns the destination Island object property
     */
    public Island getDestinationIsland()
    {
        return destIsl;
    }

    /** canCardTravel() is a method for checking if a card can travel on the ferry
     * @paran - accepts the  card object
     * @return - returns TRUE if card can travel or FALSE otherwise
     */
    public boolean canCardTravel(Card cd)
    {

        int cardRating = cd.getCardRating();
        double cardCredit = cd.getCardCredits();

        return (!destIsl.isIslandFull() && (cardCredit >= ferryFare) && (cardRating >= destIsl.getRating()) 
            && sourceIsl.isCardOnIsland(cd));

    }

    /**moveCard() method returns the result of a card requesting to move by Ferry.
     * A movement will be successful if:  
     * the card rating of the card  >= the luxury rating of the destination island
     * AND the destination island is not full
     * AND the card has sufficient credits for the ferry journey
     * AND the card is currently in the source island
     * If the ferry journey can be made, the card is removed from the source island,
     * added to the destination island and a suitable message returned. Card 
     * information should be updated (A journey costs 3 credits and journey points incremented by 1)
     * If the ferry journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * @param crd is the card object requesting the move
     * @return a String giving the result of the request 
     **/
    public String moveCard(Card crd)
    {
        double crdCredit = crd.getCardCredits();
        int cardRating = crd.getCardRating();
        int crdId = crd.getCardId();

        if (destIsl.isIslandFull())
        {
            return "Destination Island is FULL!!!";
        }
        else if (crdCredit < ferryFare)
        {
            return "Not enough Credit for this journey";
        }
        else if ( cardRating < destIsl.getRating())
        {
            return "Not enough rating for this journey!";
        }
        else 
        {
            destIsl.enter(crd);          
            sourceIsl.leave(crd);
            crd.useFerry();
            return "Card " + crdId + " has SUCCESSFULLY travelled to Island " + destIsl.getName();
        }    
    }

    /**
     * Returns information about the Ferry object including its ferryCode,source island,destination Island,
     * @return - a string representation of the ferry Object containing, ferryCode, source and destination
     * Islands respectively
     */
    public String toString()
    {
        String toStr;
        toStr = "***Start of Ferry***\n";
        toStr += "Ferry Code: " + ferryCode;
        toStr += "\nSource Island: " + sourceIsl.getName();
        toStr += "\nDestination Island: " + destIsl.getName();
        return toStr;

    }

}

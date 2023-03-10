package bluej;

/**
 * A Card has an id number, name, a luxury rating,
 * number of credits and journey points
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * a Card ID number, person's name, a luxury rating, 
 * a number of credits and journey points 
 */
public class Card 
{
    //fields
    private int cardId;
    private String cardName;
    private int cardRating;
    private double cardCredit;
    private int journeyPoints;

    /** constructor
     * Assigns values to card objects upon instantiation
     * @param id is the card id
     * @param name is the card name
     * @param rating is the card rating
     * @param credits is the card credits
     */
    public Card(int id, String name, int rating, int credits)
    {
        cardId = id;
        cardName = name;
        cardRating = rating;
        cardCredit = credits;
        journeyPoints = 0;
    }

    /** getCardId is an accessor method for accessing the id property of a card object
     * @return the value of card Id
     */
    public int getCardId()
    {
        return cardId;
    }

    /** getCardName is a method for accessing the name field of a card
     * @return the card name property
     */
    public String getCardName()
    {
        return cardName;
    }

    /** getCardRating() is a method for accessing the name of a card
     * @paran - accepts no parameters
     * @return returns the card name property
     */
    public int getCardRating()
    {
        return cardRating;
    }

    /** getCardCredits() is a method for acessing the CardCredits
     * @return the card credit property
     */
    public double getCardCredits()
    {
        return cardCredit;
    }

    /** getJourneyPoints is the method for acessing the JourneyPoints
     * @return the card journey property
     */

    public int getJourneyPoints()
    {
        return journeyPoints;
    }

    /** buyCredits is the method for increment the credit amount needed
     * for taking the ferry journey
     * @param creditsAmount - the amount or value by which credit is to be incremented by
     */
    public void buyCredits(double creditsAmount)
    {
        cardCredit = cardCredit + creditsAmount;

    }

    /** useCredits is the method for decrementing the credit amount
     * whenever a user takes a ferry journey
     * @param creditsAmount - the amount or value by which credit is to be decremented by
     */
    public void useCredits(double creditsAmount)
    {
        cardCredit =  cardCredit - creditsAmount;
    }

    /** setJourneyPoints is a method for incrementing the value for 
     * the journey points
     * @param jPointsAmt - the amount or value by which journey
     * point is to be incremented by.
     */
    public void setJourneyPoints(int jPointsAmt)
    {
        journeyPoints = jPointsAmt;
    }

    /** increaseJourneyPoints is a method for increasing the 
     * value of the journey points by 1.
     */
    public void increaseJourneyPoints()
    {
        journeyPoints = journeyPoints + 1;
    }

    /** increaseJourneyPointsByValue is a method for increasing the 
     * value of the journey points by a specified amount.
     *@params amount by which journey points is to be incremented.
     */
    public void increaseJourneyPointsByValue(int val)
    {
        journeyPoints = journeyPoints + val;
    }

    /** convertJourneyPoint is a method for comverting the 
     * value of the journey points to credits. 
     * 5 journeyPoints = 1 credit
     */
    // journeyPoints = 23;
    public void convertJourneyPoints() 
    {
        int newCredits = journeyPoints/5;
        int remainder = journeyPoints%5;
        buyCredits(newCredits);
        setJourneyPoints(remainder);
    }

    /** useFerry is a method called whenever a journey is completed.
     * for decrementing amount of credits by 3 and increments journey points by 1
     * @param accepts no parameter
     */
    public void useFerry()
    {
        useCredits(3);
        increaseJourneyPoints();
    }

    /**
     * Returns information about the card object including its cardId,cardName,cardRating,cardCredits,
     * journeyPoints
     * @param accepts no parameter
     * @return a string representation of the information about the card object including its cardId,cardName,cardRating,cardCredits,
     * journeyPoints
     */
    public String toString()
    {
        String cardToStr;
        cardToStr = "***Start of Card***\n";
        cardToStr = cardToStr + "Card ID: " + cardId + "\n";
        cardToStr = cardToStr + "Card Name: " + cardName + "\n";
        cardToStr = cardToStr + "Card Rating: " + cardRating + "\n";
        cardToStr = cardToStr + "No. of Card Credits: " + cardCredit + "\n";
        cardToStr = cardToStr + "Journey Points: " + journeyPoints + "\n";
        return cardToStr;

    }

}


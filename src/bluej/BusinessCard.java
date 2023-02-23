package bluej;

/**
 * Write a description of class BusinessCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BusinessCard extends Card
{
    private int loyaltyPoints;

    /** constructor
     * Assigns values to card objects upon instantiation
     * calls the Base class constructor super()
     * @param int id is the card id
     * @param String name is the card name
     * @param int rating is the card rating
     */
    public BusinessCard(int id, String name, int rating)
    {
        super(id, name,  rating, 30);
        loyaltyPoints = 20;

    }

    /** setLoyaltyPoints() is a method for setting the value for 
     * the journey points
     * @param lPointsAmt - the amount or value by which loyalty
     * points is to be set by.
     */
    public void setLoyaltyPoints(int lPointsAmt)
    {
        loyaltyPoints = lPointsAmt;
    }

    /** getLoyaltyPoints() is the method for acessing the loyaltyPoints
     * @return the Business card loyalty property
     * @param accepts no parameters.
     */

    public int getLoyaltyPoints()
    {
        return loyaltyPoints;
    }

    /** convertLoyaltyPoints() is a method for converting the 
     * value of the loyalty points to credits. 
     * 3 journeyPoints = 1 credit as the conversion rate.
     * @param accepts no parameters
     * @return returns no value
     */

    public void convertLoyaltyPoints(){
        // Assumption: 3 loyalty points = 1 credit

        int ccreds = loyaltyPoints / 3;
        int rmder = loyaltyPoints % 3;

        loyaltyPoints = rmder;

    }

    /** 
     * @override
     * useFerry is a method called whenever a journey is completed.
     * for decrementing amount of credits by 3 and increments loyalty points by 2
     * @param accepts no parameter
     */
    public void useFerry()
    {
        useCredits(3);
        loyaltyPoints += 2;

    }

    /**

     * @override
     * @return Returns information about the card object including its cardId,cardName,cardRating,cardCredits,
     * loyalty Points
     */

    public String toString()
    {
        String str = "";
        str = str + super.toString();
        str = str + "\n Loyalty Points: " + loyaltyPoints;
        str = str + "\n";
        return str;
    }

}

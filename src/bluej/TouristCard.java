package bluej;

/**
 * Write a description of class TouristCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TouristCard extends Card
{
    private String citizenship;

    /** constructor
     * Assigns values to Touristcard objects upon instantiation
     * @param id is the card id
     * @param name is the card name
     * @param rating is the card rating
     * @param credits is the card credits
     * @param ctry is the country of citizenship
     */
    public TouristCard(int id, String name, int rating, int credits, String ctry)
    {
        super(id, name,  rating, credits);
        citizenship = ctry;
    }

    /** 
     * getCitizenship() method returns the country of citizenship of the touristCard
     * @return returns citizenship property of the touristCard object
     */

    public String getCitizenship()
    {
        return citizenship;
    }

    /**
     * @override
     * useFerry is a method called whenever a journey is completed.
     * for decrementing amount of credits by 4 and increments journey points by 1 
     */
    public void useFerry()
    {
        useCredits(4);
        increaseJourneyPoints();
    }

    /**
     * @override
     * @return Returns information about the card object including its cardId,cardName,cardRating,cardCredits,
     * journeyPoints AND CITIZENSHIP specific to the TouristCard
     */
    public String toString()
    {
        String str = "";
        str = str + super.toString();
        str = str + "Citizenship: " + getCitizenship();
        str = str + "\n";
        return str;
    }
}

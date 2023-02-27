package bluej;

/**
 * Write a description of class MockCardTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MockCardTest
{
    public static void main(String[] args)
    {
        Card herCard = new Card(474, "Uriah", 4, 10);
        System.out.println(herCard.getCardRating());
        System.out.println(herCard.toString());
    }
}

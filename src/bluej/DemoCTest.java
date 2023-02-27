package bluej;

/**
 * Write a description of class MockDemo here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DemoCTest
{
    public static void main(String[] args)
    {
        Resort paradise = new Resort("Holiday Islands");
        
        System.out.println(paradise.getAllCardsOnIsland("Base"));
        
        // Request to travel from base to yorkie
        System.out.println("Card Location before Travelling: " + paradise.findCardLocation(1001));
        paradise.travel(1001, "ABC1");
        System.out.println("Card Location after Travelling: " + paradise.findCardLocation(1001));
        
        System.out.println("\n");
        
        // Request to travel from base to yorkie
        System.out.println("Card Location before Travelling: " + paradise.findCardLocation(1004));
        paradise.travel(1004, "ABC1");
        System.out.println("Card Location after Travelling: " + paradise.findCardLocation(1004));
        
        System.out.println("\n");
        
        // Request to travel from base to yorkie
        System.out.println("Card Location before Travelling: " + paradise.findCardLocation(1005));
        paradise.travel(1005, "ABC1");
        System.out.println("Card Location after Travelling: " + paradise.findCardLocation(1005));
        
        System.out.println("\n");
        
        // Request to travel from Yorkie to Bounty
        System.out.println("Card Location before Travelling: " + paradise.findCardLocation(1005));
        paradise.travel(1005, "CDE3");
        System.out.println("Card Location after Travelling: " + paradise.findCardLocation(1005));
        
        System.out.println("\n");
        
        // ALL TRAVEL Request to GO from BASE to Bounty (FOR CARD 1003)
        System.out.println("Card Location before Travelling: " + paradise.findCardLocation(1003));
        paradise.travel(1003, "ABC1");
        paradise.travel(1003, "GHJ6");
        System.out.println("Card Location after Travelling: " + paradise.findCardLocation(1003));
        
        System.out.println("can travel: " + paradise.canTravel(1005, "HJK7"));
        System.out.println(paradise.findCardLocation(1004));
        System.out.println(paradise.getAllCardsOnIsland("Yorkie"));
        
 
    }
}

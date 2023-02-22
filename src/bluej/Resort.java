package bluej;

import java.util.*;

/**This class implements the WIRE interface
 *
 * @author A.A.Marczyk 
 * @version 05/11/22
 **/
public class Resort implements WIRE   // do not change this header
{

    private String location;
    private static int journeyFare = 3;
    private ArrayList<Card> allCards = new ArrayList<Card>();
    private ArrayList<Island> allIslands = new ArrayList<Island>();
    private ArrayList<Ferry> allFerries = new ArrayList<Ferry>();

    /** constructor
     * Some code has been provided 
     */

    public Resort(String loc) 
    {
        location = loc;
        loadIslandsAndFerries();
        loadCards();
        // Ensure all cards are added to Base Island
        addCardsToBaseIsland();
        // you may do this here or in one of the above method
    }

    /**
     * Returns information about the resort including its location/name and all
     * cards currently on each island, or "No cards" (if no card on that island
     * @return all of the details of all islands including location 
     * and all cards currently on each island, or "No cards" if island has no cards
     */
    public String toString()
    {
        String s = location;
        s = s + getAllCardsOnAllIslands();
        return s;
    }

    /**Returns a String representation of all the cards on all islands
     * with "No cards" if there are no cards on an island
     * @return a String representation of all cards on all islands
     **/

    public String getAllCardsOnAllIslands()
    {
        String s = "\nLocation of Cards\n";

        for(Island temp : allIslands)
        {
            s = s + temp.toString();
        }
        return s;
    } 

    /**Returns the name of the island which contains the specified card or "Not found"
     * @param cd -the id of the card
     * @return the name of the Island which contains the card, or "Not found"
     **/
    public String findCardLocation(int cd)
    { 
        Card temp = getCard(cd);
        if (temp != null)
        {
            for (Island dtemp : allIslands)
            {
                if (dtemp.isCardOnIsland(temp))
                {
                    return dtemp.getName();
                }
            }
        }

        return "Not found";
    }

    /**Returns details of the card with the specified id or "Not found"
     * @param cd - the id of the card
     * @return the details of the card, or "Not found"
     **/
    public String viewACard(int cd)
    {
        for (Card temp : allCards)
        {
            if (temp.getCardId() == cd)
            {
                return temp.toString();
            }
        }

        return "Not found";
    }

    /** Given the name of a island, returns the island id number
     * or -1 if island does not exist
     * @param isl is the name of island
     * @return id number of island
     */
    public int getIslandNumber(String isl)
    {
        for (Island temp : allIslands) 
        {
            if (temp.getName().equals(isl))
            {
                return temp.getIslandId();
            }
        }
        return -1;
    }

    /**Returns a String representation of all cards on a specified island
     * @param isl - the name of the island
     * @return a String representation of all cards on specified island
     **/
    public String getAllCardsOnIsland(String isl)
    {
        String s = "\nCards on " + isl + " Island are: \n";
        for (int i = 0; i < allIslands.size(); i++)
        {
            Island temp = allIslands.get(i); 

            if(temp.getName().equals(isl))
            {
                s = s + "\n" + temp.listCardsOnIsland();
            }
        }

        return s;
    } 

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
    public boolean canTravel(int cdId, String ferCode)
    {
        Card c = getCard(cdId);
        double cardCrdt = c.getCardCredits();
        int cardRtng = c.getCardRating();
        Ferry fr = getFerry(ferCode);
        Island dstIsl = fr.getDestinationIsland();
        Island srcIsl = fr.getSourceIsland();
        int luxRtn = dstIsl.getRating();  

        return ((cardRtng >= luxRtn) && !dstIsl.isIslandFull() && (cardCrdt >= journeyFare) 
            && srcIsl.isCardOnIsland(c) && (c != null) && (fr !=null));

    }

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
    public String travel(int pCardId, String ferCode) 
    {
        String s = "";
        Card c = getCard(pCardId);        
        Ferry fr = getFerry(ferCode);

        if(fr == null)
        {
            s = "Ferry does not exist";
        }else if(c == null)
        {
            s = "Card does not exist";  
        }else
        {
            s = fr.moveCard(c);  
        }

        return s;
    }

    /** Allows credits to be added to a card.
     *  @param id the id of the card toping up their credits
     *  @param creds the number of credits to be added to card 
     */
    public void topUpCredits(int id, int creds)
    {
        Card crdObj = getCard(id);
        crdObj.buyCredits(creds);
    }

    /** Converts a card's journey points into credits
     * @param id the id of the card whose points are to be converted
     */
    public void convertPoints(int id)  
    {
        Card crdObj = getCard(id);
        int jp = crdObj.getJourneyPoints();
        int creds = jp/5;
        crdObj.buyCredits(creds);
        int remainder = (jp % 5);
        crdObj.setJourneyPoints(remainder);

    } 

    //***************private methods**************
    private void loadCards()
    {
        Card card1 = new Card (1000, "Lynn", 5, 10); 
        Card card2 = new Card (1001, "May", 3, 30); 
        Card card3 = new Card (1002, "Nils", 10, 0); 
        Card card4 = new Card (1003, "Olek", 1, 12); 
        Card card5 = new Card (1004, "Pan", 3, 3); 
        Card card6 = new Card (1005, "Quin", 1, 30); 
        Card card7 = new Card (1006, "Raj", 4, 5); 
        Card card8 = new Card (1007, "Sol", 7, 20); 
        Card card9 = new Card (1008, "Tel", 6, 30);
        
        // demo 4.1
        Card a4444 = new Card (4444, "Cela", 6, 15);
        // dEMO 5.2
        Card a8888 = new Leader (8888, "Jovian", 1234, "STD");

        // Inheritance TASK 7
        TouristCard tcard = new TouristCard(2000, "Lynn", 5, 10, "Nigeria");
        EmployeeCard ecard = new EmployeeCard(2001, "Lynn", 1234, "Software Engineer");
        BusinessCard bcard = new BusinessCard(2002, "May", 8);

        allCards.add(card1);
        allCards.add(card2);
        allCards.add(card3);
        allCards.add(card4);
        allCards.add(card5);
        allCards.add(card6);
        allCards.add(card7);
        allCards.add(card8);
        allCards.add(card9);
        //demo 4.1
        allCards.add(a4444);
        
        allCards.add(a8888);

        allCards.add(tcard);
        allCards.add(ecard);
        allCards.add(bcard);
        

    }

    /** Add all the cards in the resort to the base Island
     *
     */

    private void addCardsToBaseIsland()
    {
        Island baseIsl = allIslands.get(0);
        for (Card ttemp : allCards)
        {
            baseIsl.enter(ttemp);
        }

    }

    /** Returns the card with the card id specified by the parameter
     * @param id card id
     * @return the card with the specified name
     **/
    public Card getACard(int id)
    {
        {
            for (int i = 0; i < allCards.size(); i++)
            {
                Card temp = allCards.get(i); 
                if (temp.getCardId() == id)
                {
                    return temp;
                }
            }
        }
        return null;
    }

    private void loadIslandsAndFerries()

    {
        Island Base = new Island(0, "Base", 100, 0);
        Island Yorkie= new Island(1, "Yorkie", 100, 1);
        Island Bounty = new Island(2, "Bounty", 10, 3); 
        Island Twirl = new Island(3, "Twirl", 5, 2);
        Island Aero = new Island(4, "Aero", 1, 1);
        //demo 4.2
        Island Rolo = new Island(5, "Rolo", 3, 25);

        allIslands.add(Base);
        allIslands.add(Yorkie);
        allIslands.add(Bounty);
        allIslands.add(Twirl);
        allIslands.add(Aero);
        //demo 4.2
        allIslands.add(Rolo);

        Ferry ABC1 = new Ferry ("ABC1", Base, Yorkie);
        Ferry BCD2 = new Ferry ("BCD2",Yorkie, Base );
        Ferry CDE3 = new Ferry ("CDE3", Yorkie, Bounty);
        Ferry DEF4 = new Ferry ("DEF4", Bounty, Yorkie);
        Ferry EFG5 = new Ferry ("EFG5", Twirl, Yorkie);
        Ferry GHJ6 = new Ferry ("GHJ6", Yorkie, Aero);
        Ferry HJK7 = new Ferry ("HJK7", Aero,Yorkie  );
        Ferry JKL8 = new Ferry ("JKL8",Bounty, Twirl );
        //DEMO 4.3
        Ferry QQQ = new Ferry ("", Twirl, Rolo);
        Ferry RRR = new Ferry ("", Rolo, Yorkie);

        allFerries.add(ABC1); 
        allFerries.add(BCD2); 
        allFerries.add(CDE3); 
        allFerries.add(DEF4); 
        allFerries.add(EFG5); 
        allFerries.add(GHJ6); 
        allFerries.add(HJK7); 
        allFerries.add(JKL8); 
        //demo 4.3
        allFerries.add(QQQ); 
        allFerries.add(RRR);
        

    }

    /** Returns the card with the card id specified by the parameter
     * @param id card id
     * @return the card with the specified name
     **/
    private Card getCard(int id)
    {

        for (int i = 0; i < allCards.size(); i++)
        {
            Card temp = allCards.get(i); 
            if (temp.getCardId() == id)
            {
                return temp;
            }
        }

        return null;
    }

    /** Returns the island with the name specified by the parameter
     * @param islandName the island name
     * @return the island with the specified name
     **/
    private Island getIsland(String islandName)
    {
        for (Island temp : allIslands) 
        {
            if (temp.getName() == islandName)
                return temp;
        }
        return null;
    }

    /** Returns the ferry with the ferry code specified by the parameter
     * @param fer the ferry code
     * @return the island with the specified name
     **/
    private Ferry getFerry(String fer)
    {
        for (Ferry temp : allFerries) 
        {
            String ferrycode = temp.getFerryCode();
            if (ferrycode.equals(fer))
            {
                return temp;

            }
        }
        return null;
    }
}
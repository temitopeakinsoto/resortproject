package bluej;

import java.util.*;
/**
 * An island is part of a WIRE resort.Each island has a name,  a luxury rating
 * and a capacity which represents the maximum number of people(cards) who can be on the  
 * island at any one time. Each island must maintain a list of all people (cards)
 * currently on the island. These lists are updated whenever cards enter or leave 
 * an island,so that it is always possible to say which (cards) are on the island 
 * 
 *patientList = new ArrayList<Patient>();* @author (your name) 
 * @version (a version number or a date)
 */

public class Island
{

    private String islandName;
    private int islandCapacity;
    private int islandLuxuryRating;
    private int islandId;
    private ArrayList<Card> cardList;

    /**
     * An island is part of a WIRE resort.Each island has a name,  a luxury rating
     * and a capacity which represents the maximum number of people(cards) who can be on the  
     */

    /** constructor
     * Assigns values to Island objects upon instantiation
     * @param id is the Island id - int
     * @param name is the Island name - String
     * @param rating is the Island luxury rating - int
     * @param credits is the Island capacity - int
     */

    public Island(int id, String nme, int capcty, int luxRatng)
    {
        islandId = id;
        islandName = nme;
        islandCapacity = capcty;
        islandLuxuryRating = luxRatng;
        cardList = new ArrayList<Card>();

    }

    /**
     * getName() is an accessor method that returns the id of the Island  (islandId)
     * @return the ID (islandId) of the card
     */
    public int getIslandId()
    {
        return islandId;
    }

    /**
     * getName() is an accessor method that returns  id of the name (islandName)
     * @return the name (islandName) detail of the card
     */
    public String getName()
    {
        return islandName;
    }

    /**
     * getCapacity() is an accessor method that returns  id of the capacity (islandCapacity)
     * @return the capacity of the card
     */
    public int getCapacity()
    {
        return islandCapacity;
    }

    /** getRating() is a method for getting the rating of an Island
     *@return the luxury rating of the Island. 
     */
    public int getRating()
    {
        return islandLuxuryRating;
    }

    /** enter() is a method for adding a card to the list of cards on an Island
     *@param the specified card object to be added to the Island. 
     */
    public void enter(Card card)
    {
        cardList.add(card);

    }

    /** leave() is a method for removing a card the list of cards on an Island
     *@param the specified card to be removed to the Island. 
     */
    public void leave(Card cr) 
    {
        int position = getIndex(cr);

        if(position != -1)
        {
            cardList.remove(position);
        }

    }

    
    /** getIndex() is a method for getting the position/index of a card in the list of cards of an Island
     *@param the specified card whose position is to be determined. 
     *@return position of the card in the arrayList of cards or -1 if card is not present on island
     */
    public int getIndex(Card crd)
    {
        for(int count=0; count < cardList.size(); count++)
        {
            if(cardList.get(count) == crd)
            {
                return count;
            }
        }

        return -1;
    }

    //  
    /** isCardOnIsland() is used to search if card is present on the island
     *@param the specified card be searched. 
     *@return TRUE if the card in the arrayList of cards or FALSE if card is not present on island
     */
    public boolean isCardOnIsland(Card crd)
    {
        for(int idx=0; idx < cardList.size(); idx++)
        {
            if(cardList.get(idx) == crd)
            {
                return true;
            }
        }

        return false;
    }

    /** isIslandFull() is used to determine if island is full or not
     *@return TRUE if the number of cards on the islands is greater or equal to the capacity of the island
     * or return FALSE Otherwise
     */

    public boolean isIslandFull()
    {
        return (cardList.size() >= islandCapacity);
    }

    /** isIslandEmpty() is used to determine if empty or not
     * @param accepts no parameters
     *@return TRUE if there are NO CARDS on the Island or FALSE Otherwise
     */

    public boolean isIslandEmpty()
    {
        return cardList.size() == 0;
    }

    /** listCardsOnIsland() is a method for displaying all the cards on an Island
     * @param accepts no parameters
     * @return the cards present on the Island
     */

    public String listCardsOnIsland()
    {
        String str = "";
        if(cardList.size() > 0)
        {
            for(Card temp : cardList)
            {
                str += temp.toString() + "\n";      
            } 
            return str;
        }

        return "There're no cards on this island";
    }

    /** getSize() is a method for displaying the number of the cards on an Island
     * @param accepts no parameters
     * @return the number of cards presently on the island
     */

    public int getSize()
    {
        return cardList.size();
    }

    /**
     * Returns information about the Island object
     * @return - a returns a string representation of the props of the island object e.g islandId, islandName
     * islandCapacity, luxury rating, capacity etc
     */
    public String toString()
    {
        String islandToStr;
        islandToStr = "***Start of Island***\n";
        islandToStr = islandToStr + "ISLAND ID: " + islandId + "\n";
        islandToStr = islandToStr +  "Island Name: " + islandName + "\n";
        islandToStr = islandToStr +  "Island Capacity: " + islandCapacity + "\n";
        islandToStr = islandToStr +  "Luxury Rating: " + islandLuxuryRating + "\n\n";
        islandToStr = islandToStr + "Number of Cards: " + getSize() + "\n";
        islandToStr = islandToStr + "Cards On " + islandName + " Island: \n\n";
        islandToStr = islandToStr + listCardsOnIsland();
        return islandToStr;

    }
}

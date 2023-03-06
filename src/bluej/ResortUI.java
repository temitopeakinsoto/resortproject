package bluej;

import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ResortUI
{  
    private Scanner reader = new Scanner(System.in);
    private WIRE wayward = new Resort("Wayward Islands");

    public void runUI()
    {   
        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllResort();}
            else if (choice == 2){listAllCards();}
            else if (choice == 3){listOneIsland();}
            else if (choice == 4){findLocationOfCard();}
            else if (choice == 5){tryTravel();}
            else if (choice == 6){travelNow();}
            else if (choice == 7){viewCard();}
            else if (choice == 8){updateCredits();}                        
            else if (choice == 9){convertPts();}

            // output menu & get choice

            choice = getOption();
        }
        System.out.println("\nThank-you");
    }

    private int getOption()
    {
        System.out.println("What would you like to do ?");
        System.out.println("0. Quit");
        System.out.println("1. List all resort details");
        System.out.println("2. List all cards on all islands");
        System.out.println("3. List all cards on one island");
        System.out.println("4. Find location of card");
        System.out.println("5. Say if card can move by ferry");
        System.out.println("6. Move a card by ferry");
        System.out.println("7. View card");
        System.out.println("8. Top up credits");
        System.out.println("9. Convert points to credits ");

        System.out.println("Enter your choice");
        // read choice
        int option = reader.nextInt();
        reader.nextLine();
        return option;
    }

    // This one has been done for you 
    private void listAllResort()
    {
        System.out.println(wayward.toString());
    }

    /**
     *listAllCards() method displays information of all the cards in the resort,
     * @param accepts no parameter
     */ 
    private void listAllCards()
    {
        System.out.println(wayward.getAllCardsOnAllIslands());

    }

    /**
     *listOneIsland() method displays all cards present on a specified Island in the resort,
     * accepts the name of the island as user input
     */
    private void listOneIsland()
    {
        System.out.println("Enter the name of the Island");
        String isl = reader.nextLine();
        System.out.println(wayward.getAllCardsOnIsland(isl));
    }

    // This one has been done for you
    /**
     *findLocationOfCard() method is used to find the Island location of a Card
     * accepts the id of the card as user input
     */
    private void findLocationOfCard()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        String ww = wayward.findCardLocation(trav);
        if(ww != null)
        {
            System.out.println(ww);
        }
        else
        {
            System.out.println("No such card");
        }
    }

    // This one has been done for you 
    /**
     *tryTravel() checks if a card can travel on a particular ferry
     * accepts the id of the card and the ferryCode of the ferry as user input
     */
    private void tryTravel()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter ferry code");
        String ferry = reader.nextLine();
        System.out.println(wayward.canTravel(trav,ferry));
    }

    // provide the code here
    /**
     *findLocationOfCard() method is used to find the Island location of a Card
     * accepts the id of the card as user input
     */
    private void travelNow()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter ferry code");
        String ferry = reader.nextLine();
        System.out.println(wayward.travel(trav,ferry));
    }

    // This one has been done for you
    /**
     *viewCard() method is used to view the details of a card
     * accepts the id of the card as user input
     */
    private void viewCard()
    {
        System.out.println("Enter card ID number");
        int cId = reader.nextInt();
        System.out.println(wayward.viewACard(cId));
    }

    // provide the code here
    /**
     *updateCredits() method is used to top up the credit amounts of a card
     * accepts the id of the card and the amount of credits as user input
     */
    private void updateCredits()
    {
        System.out.println("Enter card ID number");
        int cId = reader.nextInt();
        System.out.println("Enter the amounts of credits ");
        int creds = reader.nextInt();
        wayward.topUpCredits(cId, creds);

    }

    // This one has been done for you
    /**
     *convertPts() method is used to convert up the journey points of a card to credits
     * accepts the id of the card whose journey points are to be converted as user input
     */
    private void convertPts()
    {
        System.out.println("Enter card ID number");
        int cId = reader.nextInt();
        wayward.convertPoints(cId);
    }   

}

package bluej;

/**
 * Write a description of class EmployeeCard here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class EmployeeCard extends Card
{
    private int employeeNumber;
    private String jobDescription;

    /** constructor
     * Assigns values to EmployeeCard objects upon instantiation
     * calls the parent constructor passing appropriate params
     * @param id is the card id
     * @param name is the card name
     * @param rating is the card rating
     * @param credits is the card credits
     * @param empNum is the employee Number
     * @param jDesc is the job Description
     */
    public EmployeeCard(int id, String name, int empNum, String jDesc)
    {
        super(id, name,  10, 0);
        employeeNumber = empNum;
        jobDescription = jDesc;

    }

    /** 
     * @override
     * useFerry is a method called whenever a journey is completed.
     * increments journey score by 1
     * @param accepts no parameter
     */
    public void useFerry()
    {
        increaseJourneyPoints();
    }

    /**
     * @override
     * @return Returns information about the card object including its cardId,cardName,cardRating,cardCredits,
     * journeyPoints AND employeeNumber, jobDescription fields which are specific to convertJPToCreditsthe EmployeeCard
     */

    public String toString()
    {
        String str = "";
        str = str + super.toString();
        str = str + "Employee Number: " + employeeNumber;
        str = str + "\nJob Description: " + jobDescription;
        str = str + "\n";
        return str;
    }

}
package bluej;

/**
 * Write a description of class Leader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Leader extends Card
{
    private int licenseNumber;
    private String experienceLevel;
    
    public Leader(int id, String name, int licenseNum, String expLevel)
    {
        super(id, name, 10, 20);
        licenseNumber = licenseNum;
        experienceLevel = expLevel;
        
    }
    
    /** @override 
     * overrides the useFerry of base class
     * useFerry is a method called whenever a journey is completed.
     * @param accepts no parameter
     */
    public void useFerry()
    {
        useCredits(1);
    }
    
}

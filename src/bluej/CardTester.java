package bluej;

import java.util.*;
/**
 * Write a description of class CardTester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 * 1000    Lynn    5    10 
 */
public class CardTester
{
    public static void main(String[] args)
    {
        // write your tests here
        Card crd1 = new Card(1000, "Lynn", 5, 10);
        System.out.println(crd1.toString());
        crd1.setJourneyPoints(100);
        System.out.println(crd1.toString());
        crd1.setJourneyPoints(104);
        crd1.convertJourneyPoints();
        crd1.useFerry();
        System.out.println(crd1.toString());
        
    }
}

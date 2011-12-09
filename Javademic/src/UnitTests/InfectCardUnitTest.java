package UnitTests;

import Cards.InfectionCard;
import Location.Location;

/**
 * Test the InfectionCard Class
 * @author Brian Jerardi
 */
public class InfectCardUnitTest
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {  
        System.out.println("### InfectionCard Unit Test ###\n");
        
        Location testLoc = new Location("Loc Name");
        
        System.out.println("Construct new InfectionCard infCard "
                + "with image location "
                + "\"somelocation\\infCardFile.jpg\","
                + " name \"Some Infection Card\", "
                + "and location testLoc");
        InfectionCard infCard = new InfectionCard
                ("somelocation\\infCardFile.jpg", 
                "Some Infection Card", 
                testLoc);
        
        System.out.println("");
        
        System.out.println("infCard Name        : " 
                + infCard.getName());
        System.out.println("infCard ImgLoc      : " 
                + infCard.getImageLoc());
        System.out.println("infCard Location    : " 
                + infCard.getLocation());
        System.out.println("");
        
        System.out.println("### End InfectionCard Unit Test ###\n");
    }
    
}

package UnitTests;

import Locations.Location;
import ResearchStation.ResearchStation;

/**
 * Unit Test for ResearchStation Class
 * @author Brian Jerardi
 */
public class ResearchStationTest
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {              
        Location loc1 = new Location("Test Loc 1");
        Location loc2 = new Location("Test Loc 2");
        ResearchStation station = new ResearchStation(loc1);
        
        System.out.println("### ResearchStation Test ###\n");
        
        System.out.println("Get the ResearchStation's Location");
        System.out.println("Location: " + station.getLocation().getName());
        System.out.println(""); 
        
        System.out.println("Set the ResearchStation's Location");
        station.setLocation(loc2);
        System.out.println("Location: " + station.getLocation().getName());
        System.out.println(""); 
        
        
        System.out.println("### End ResearchStation Test ###");
    }
    
}

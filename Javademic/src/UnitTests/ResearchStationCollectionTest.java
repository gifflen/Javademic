package UnitTests;

import Locations.Location;
import ResearchStation.ResearchStationCollection;

/**
 * A test of the ResearchStationCollection Class
 * @author Brian Jerardi
 */
public class ResearchStationCollectionTest
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {              
        Location loc1 = new Location("Test Loc 1");
        Location loc2 = new Location("Test Loc 2");
        Location loc3 = new Location("Test Loc 3");
        Location loc4 = new Location("Test Loc 4");
        Location loc5 = new Location("Test Loc 5");
        Location loc6 = new Location("Test Loc 6");
        Location loc7 = new Location("Test Loc 7");
        ResearchStationCollection stations;
        
        System.out.println("### ResearchStationCollection Test ###\n");

        System.out.println("Create new default collection");
        stations = new ResearchStationCollection();        
        printLocs(stations);
        
        System.out.println("Add loc1 to stations");
        System.out.println("Sucess: " + stations.addStation(loc1));            
        printLocs(stations);
        
        System.out.println("Add loc2, loc3, loc4, loc5, and loc6 to stations");
        System.out.println("Sucess: " + stations.addStation(loc2));     
        System.out.println("Sucess: " + stations.addStation(loc3));  
        System.out.println("Sucess: " + stations.addStation(loc4));  
        System.out.println("Sucess: " + stations.addStation(loc5));  
        System.out.println("Sucess: " + stations.addStation(loc6));  
        printLocs(stations);
        
        System.out.println("Add loc7 to stations which should overwrite loc1");
        System.out.println("Sucess: " + stations.addStation(loc7)); 
        printLocs(stations);
        
        
        
        System.out.println("### End ResearchStationCollection Test ###");
    }

    /**
     * Prints the location of all research stations
     * @param stations 
     *  The collection of stations to print the locations of
     */
    private static void printLocs(ResearchStationCollection stations)
    {
        Location[] locs = stations.getLocations();
        
        System.out.println("Locations:");
        for (Location location : locs)
        {
            System.out.println(location.getLocationName());
        }
        System.out.println("");
    }
}

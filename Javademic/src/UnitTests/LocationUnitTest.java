package UnitTests;

import Disease.Disease;
import Locations.Location;

/**
 * Tests the Location Class
 * @author Brian Jerardi
 */
public class LocationUnitTest
{    
    private static Location beijing;
    private static Location tehran;
    private static Location atlanta;
    private static Location lima;
    private static Disease redDisease;
    private static Disease blackDisease;
    private static Disease blueDisease;
    private static Disease yellowDisease;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {   
        redDisease = new Disease("Red", 
                "tempResources/diseaseCubes/red_disease.png");
        blackDisease = new Disease("Black", 
                "tempResources/diseaseCubes/black_disease.png");
        blueDisease = new Disease("Blue", 
                "tempResources/diseaseCubes/blue_disease.png");
        yellowDisease = new Disease("Yellow", 
                "tempResources/diseaseCubes/yellow_disease.png");
        
        System.out.println("### Begin Location Test ###\n");
        
        createLocs();
        
        testSettersAndGetters();
        
        System.out.println("### End Location Test ###");
    }
    
    /**
     * Construct four locations
     * @postcondition
     *  beijing, tehran, atlanta, and lima have been constructed
     */
    private static void createLocs()
    {
        System.out.println("*** Begin Location Constructor Test ***\n");
        
        beijing = new Location("Beijing@#!");
        tehran = new Location("Tehran@#!");
        atlanta = new Location("Atlanta@#!");
        lima = new Location("Lima@#!");
        
        System.out.println("*** End Location Constructor Test ***\n");
    }
    
    
    /**
     * Test the setters and getters of Location
     * @precondition
     *  beijing, tehran, atlanta, and lima have been constructed
     * @postcondition
     *  beijing, tehran, atlanta, and lima have been constructed
     */
    private static void testSettersAndGetters()
    {
        System.out.println("*** Begin Location Setter and Getter Test ***\n");
        
        System.out.println("Location Names");
        System.out.println(beijing.getLocationName());
        System.out.println(tehran.getLocationName());
        System.out.println(atlanta.getLocationName());
        System.out.println(lima.getLocationName());
        System.out.println("");
        
        System.out.println("Set Location Names to correct names");
        beijing.setLocationName("Beijing");
        tehran.setLocationName("Tehran");
        atlanta.setLocationName("Atlanta");
        lima.setLocationName("Lima");
        
        System.out.println("Location Names");
        System.out.println(beijing.getLocationName());
        System.out.println(tehran.getLocationName());
        System.out.println(atlanta.getLocationName());
        System.out.println(lima.getLocationName());
        System.out.println("");
        
        System.out.println("Set colors of beijing, tehran, atlanta, and lima");
        beijing.setColor("Red");
        tehran.setColor("Black");
        atlanta.setColor("Blue");
        lima.setColor("Yellow");
        System.out.println("");
        
        System.out.printf("%15s%15s\n","Location","Color");
        System.out.printf("%15s%15s\n",beijing.getLocationName()
                ,beijing.getColor());
        System.out.printf("%15s%15s\n",tehran.getLocationName()
                ,tehran.getColor());
        System.out.printf("%15s%15s\n",atlanta.getLocationName()
                ,atlanta.getColor());
        System.out.printf("%15s%15s\n",lima.getLocationName()
                ,lima.getColor());
        System.out.println("");
        
        System.out.println("Set Base Disease for "
                + "beijing, tehran, atlanta, and lima");
        beijing.setBaseDisease(redDisease);
        tehran.setBaseDisease(blackDisease);
        atlanta.setBaseDisease(blueDisease);
        lima.setBaseDisease(yellowDisease);
        
        System.out.printf("%15s%15s\n","Location","Disease");
        System.out.printf("%15s%15s\n",beijing.getLocationName()
                ,beijing.getBaseDisease().getName());
        System.out.printf("%15s%15s\n",tehran.getLocationName()
                ,tehran.getBaseDisease().getName());
        System.out.printf("%15s%15s\n",atlanta.getLocationName()
                ,atlanta.getBaseDisease().getName());
        System.out.printf("%15s%15s\n",lima.getLocationName()
                ,lima.getBaseDisease().getName());
        System.out.println("");
        
        
        System.out.println("*** End Location Setter and Getter Test ***\n");
    }
    
}

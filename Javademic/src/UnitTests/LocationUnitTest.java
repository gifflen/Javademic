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
        
        testAddConnection();
        
        testInfect();
        
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

    /**
     * Test the adding of connections
     * @postcondition
     *  beijing, tehran, atlanta, and lima have had their connections added
     */
    private static void testAddConnection()
    {
        System.out.println("*** Begin Add Connection Test ***\n");
        
        System.out.println("Connect beijing to tehran and atlanta");
        beijing.addConnection(tehran);
        beijing.addConnection(atlanta);
        
        System.out.println("beijing Connections:");
        System.out.println(beijing.getConnections());
        System.out.println("");
        
        System.out.println("Connect tehran to atlanta");
        tehran.addConnection(atlanta);
        
        System.out.println("tehran Connections:");
        System.out.println(tehran.getConnections());
        System.out.println("");
        
        System.out.println("Connect atlanta to lima");
        atlanta.addConnection(lima);
        
        System.out.println("atlanta Connections:");
        System.out.println(atlanta.getConnections());
        System.out.println("");
        
        System.out.println("Connect lima to tehran");
        lima.addConnection(tehran);
        
        System.out.println("tehran Connections:");
        System.out.println(tehran.getConnections());
        
        System.out.println("lima Connections:");
        System.out.println(lima.getConnections());
        System.out.println("");     
        
        System.out.println("Listing Location Connections");
        System.out.println("beijing: " + beijing.listLocations());
        System.out.println("tehran: " + tehran.listLocations());
        System.out.println("atlanta: " + atlanta.listLocations());
        System.out.println("lima: " + lima.listLocations());
        System.out.println("");
        
        
        System.out.println("*** End Add Connection Test ***\n");
    }

    /**
     * Test infections
     * @postcondition
     *  beijing, tehran, atlanta, and lima have been infected 
     *  with multiple diseases
     */
    private static void testInfect()
    {
        System.out.println("*** Begin Infection Test ***\n");
        
        System.out.println("Infect beijing with one redDisease");
        beijing.infect(redDisease);
        beijing.printDiseases();
        System.out.println("");
        
        System.out.println("Infect tehran with three blackDisease");
        tehran.infect(blackDisease, 3);
        tehran.printDiseases();
        System.out.println("");
        
        System.out.println("Infect atlanta with 2 yellow diseases");
        atlanta.infect(yellowDisease, 2);
        atlanta.printDiseases();
        System.out.println("");
        
        System.out.println("Infect lima with its baseDisease yellowDisease");
        lima.infect();
        lima.printDiseases();
        System.out.println("");
        
        System.out.println("Infect tehran with one blackDisease to outbreak");
        tehran.infect();        
        tehran.printDiseases();
        beijing.printDiseases();
        atlanta.printDiseases();
        lima.printDiseases();
        System.out.println("");
        
        System.out.println("Infect beijing and atlanta with 2 black diseases");
        beijing.infect(blackDisease, 2);
        atlanta.infect(blackDisease, 2);
        beijing.printDiseases();
        atlanta.printDiseases();
        System.out.println("");
        
        System.out.println("Infect tehran with blackDisease to test outbreak");
        tehran.infect();
        tehran.printDiseases();
        beijing.printDiseases();
        atlanta.printDiseases();
        lima.printDiseases();
        System.out.println("");
        
        
        System.out.println("*** End Infection Test ***\n");
    }

    
}

package Disease;


/**
 * A Unit Test of the Disease Class
 * @author Brian Jerardi
 * @instructor Kendall Martin
 * @date 11/23/2011
 * @course CIS 112
 */
public class DiseaseUnitTest
{
    private static Disease redDisease;
    private static Disease blueDisease;
    private static Disease yellowDisease;
    private static Disease blackDisease;
    
    /**
     * Test the Disease Class
     * @param args 
     *  the command line arguments
     */
    public static void main(String[] args)
    { 
        createDiseases();
        
        testGetters();
        
        testAdd();
        
        testRemove();
        
        testCureAndEradicated();
    }
    
    private static void PrintDiseaseInfo(Disease diseaseToPrint)
    {
        System.out.println(diseaseToPrint.getColor() + "Disease:");
        System.out.println("\tColor           : " + 
                diseaseToPrint.getColor());
        System.out.println("\tImage File      : " + 
                diseaseToPrint.getImgFile());
        System.out.println("\tNumber of Board : " + 
                diseaseToPrint.getNumOnBoard());
        System.out.println("\tPile            : " + 
                diseaseToPrint.getPile());
        System.out.println("\tCured           : " + 
                diseaseToPrint.isCured());
        System.out.println("\tEradicated      : " + 
                diseaseToPrint.isEradicated());
        System.out.println("");        
    }

    /**
     * Create some valid and invalid diseases
     * @precondition
     *  none
     * @postcondition
     *  redDisease, blueDisease, yellowDisease, and blackDisease have been
     *  instantiated
     */
    private static void createDiseases()
    {        
        
        System.out.println("--- CREATING DISEASES ---\n");
        
        System.out.println("Creating disease redDisease");
        redDisease = new Disease
                ("red", 
                "tempResources/diseaseCubes/red_disease.png", 
                24);
        System.out.println("Disease redDisease created\n");
        
        System.out.println("Creating disease blueDisease");
        blueDisease = new Disease
                ("blue", 
                "tempResources/diseaseCubes/blue_disease.png", 
                24);
        System.out.println("Disease blueDisease created\n");
        
        System.out.println("Creating disease yellowDisease");
        yellowDisease = new Disease
                ("yellow", 
                "tempResources/diseaseCubes/yellow_disease.png", 
                24);
        System.out.println("Disease yellowDisease created\n");
        
        System.out.println("Creating disease blackDisease");
        blackDisease= new Disease
                ("black", 
                "tempResources/diseaseCubes/black_disease.png", 
                24);
        System.out.println("Disease blackDisease created\n");
        
        System.out.println("Trying to creat disease whose "
                + "image file doesnt exist.");        
        try
        {
            Disease testDisease = new Disease("purple", 
                    "tempResources/diseaseCubes/purple_disease.png", 
                    24);            
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage() + "\n");
        }
        
        System.out.println("Trying to creat disease with 0 intialPile");        
        try
        {
            Disease testDisease = new Disease("black", 
                "tempResources/diseaseCubes/black_disease.png", 
                0);    
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage() + "\n");
        }
        
        System.out.println("Trying to creat disease with -24 intialPile");        
        try
        {
            Disease testDisease = new Disease("black", 
                "tempResources/diseaseCubes/black_disease.png", 
                -24);    
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage() + "\n");
        }
        
        System.out.println("Creating testDisease with 1 intialPile");
        Disease testDisease= new Disease
                ("black", 
                "tempResources/diseaseCubes/black_disease.png", 
                1);
        System.out.println("Disease testDisease created\n");
        
        System.out.println("--- END CREATING DISEASES ---\n");
    }

    private static void testGetters()
    {
        System.out.println("--- TEST GETTERS ---\n");
        
        PrintDiseaseInfo(redDisease);
        PrintDiseaseInfo(blueDisease);
        PrintDiseaseInfo(yellowDisease);
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("--- END TEST GETTERS ---\n");
    }

    private static void testAdd()
    {
        System.out.println("--- TEST ADD METHODS ---\n");
        
        System.out.println("Add one redDiseases to the Board");
        System.out.println("Success: " + redDisease.addOneToBoard());
        PrintDiseaseInfo(redDisease);
        
        System.out.println("Add two blueDiseases to the Board");
        System.out.println("Success: " + blueDisease.addToBoard(2));
        PrintDiseaseInfo(blueDisease);
        
        System.out.println("Add three yellowDiseases to the Board");
        System.out.println("Success: " + yellowDisease.addToBoard(3));
        PrintDiseaseInfo(yellowDisease);
        
        System.out.println("Add 24 blackDiseases to the Board");
        System.out.println("Success: " + blackDisease.addToBoard(24));
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("Add one more blackDisease to the Board");
        System.out.println("Success: " + blackDisease.addOneToBoard());
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("--- END TEST ADD METHODS ---\n");
    }

    private static void testRemove()
    {
        System.out.println("--- TEST REMOVE METHODS ---\n");
        
        System.out.println("Remove one blueDisease from the board");
        blueDisease.removeOneFromBoard();
        PrintDiseaseInfo(blueDisease);
        
        System.out.println("Remove three yellowDiseases from the Board");
        yellowDisease.removeFromBoard(3);
        PrintDiseaseInfo(yellowDisease);
        
        System.out.println("Try to Remove 2 redDiseases from the Board");
        try
        {
            redDisease.removeFromBoard(2);
        }
        catch (IllegalStateException e)
        {
            System.out.println(e.getMessage() + "\n");
        }
         
        System.out.println("--- END TEST REMOVE METHODS ---\n");
    }

    private static void testCureAndEradicated()
    {
        System.out.println("--- TEST CURE AND ERADICATED METHODS ---\n");
        
        System.out.println("Cure blueDisease");
        blueDisease.cure();
        PrintDiseaseInfo(blueDisease);
        
        System.out.println("Remove last blueDisease counter");
        blueDisease.removeOneFromBoard();
        PrintDiseaseInfo(blueDisease);
        
        System.out.println("Try to add one blueDisease counter");
        System.out.println("Success: " + blueDisease.addOneToBoard());
        PrintDiseaseInfo(blueDisease);        
        
        System.out.println("Cure yellowDisease");
        yellowDisease.cure();
        PrintDiseaseInfo(yellowDisease);
        
        System.out.println("Try to add three yellowDisease counters");
        System.out.println("Success: " + yellowDisease.addToBoard(3));
        PrintDiseaseInfo(yellowDisease);   
        
        System.out.println("Cure blackDisease");
        blackDisease.cure();
        System.out.println("Remove one blackDisease counter");
        blackDisease.removeOneFromBoard();
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("Remove all but one blackDisease counter");
        blackDisease.removeFromBoard(22);
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("Add one blackDisease counter to the Board");
        blackDisease.addOneToBoard();
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("--- END TEST CURE AND ERADICATED METHODS ---\n");
    }

    
}

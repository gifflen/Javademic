package UnitTests;

import Disease.Disease;


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
        System.out.println("### BEGIN DISEASE UNIT TEST ###\n");
        
        createDiseases();
        
        testGetters();
        
        testAdd();
        
        testRemove();
        
        testCureAndEradicated();
        
        System.out.println("### END DISEASE UNIT TEST ###");
    }
    
    /**
     * Print the disease information; 
     *  name, imgFile,numOnBoard,Pile,Cure, and eradicated
     * @precondition
     *  diseaseToPrint is not Null
     * @param diseaseToPrint 
     *  The disease whose information to print
     * @postcondition
     *  diseaseToPrint's information has been printed to the screen
     */
    private static void PrintDiseaseInfo(Disease diseaseToPrint)
    {
        System.out.println(diseaseToPrint.getName() + "Disease:");
        System.out.println("\tName            : " + 
                diseaseToPrint.getName());
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
        
        System.out.println("--- BEGIN CREATING DISEASES ---\n");
        
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

    /**
     * Test the getters
     * @precondition
     *  redDisease, blueDisease, yellowDisease, and blackDisease are not Null
     * @postcondition
     *  redDisease, blueDisease, yellowDisease, and blackDisease have been
     *  printed to the screen testing their getters
     */
    private static void testGetters()
    {
        System.out.println("--- BEGIN TEST GETTERS ---\n");
        
        PrintDiseaseInfo(redDisease);
        PrintDiseaseInfo(blueDisease);
        PrintDiseaseInfo(yellowDisease);
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("--- END TEST GETTERS ---\n");
    }

    /**
     * Test the addToBoard methods
     * @precondition
     *  redDisease, blueDisease, yellowDisease, and blackDisease are not Null
     * @postcondition
     *  redDisease, blueDisease, yellowDisease, and blackDisease have had 
     *  disease counters added to them  
     */
    private static void testAdd()
    {
        System.out.println("--- BEGIN TEST ADD METHODS ---\n");
        
        System.out.println("Add one redDiseases to the Board");
        System.out.println("Success: " + redDisease.addToBoard());
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
        System.out.println("Success: " + blackDisease.addToBoard());
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("--- END TEST ADD METHODS ---\n");
    }

    /**
     * Test the removeFromBoard methods
     * @precondition
     *  redDisease, blueDisease, yellowDisease, and blackDisease are not Null
     * @postcondition
     *  redDisease, blueDisease, yellowDisease, and blackDisease have had 
     *  disease counters removed from them  
     */
    private static void testRemove()
    {
        System.out.println("--- BEGIN TEST REMOVE METHODS ---\n");
        
        System.out.println("Remove one blueDisease from the board");
        blueDisease.removeFromBoard();
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

    /**
     * Test how cure and eradicated interact with disease
     * @precondition
     *  redDisease, blueDisease, yellowDisease, and blackDisease are not Null
     * @postcondition
     *  blueDisease and yellowDisease have been cured and eradicated
     *  blackDisease has been cured
     */
    private static void testCureAndEradicated()
    {
        System.out.println("--- BEGIN TEST CURE AND ERADICATED METHODS ---\n");
        
        System.out.println("Cure blueDisease");
        blueDisease.cure();
        PrintDiseaseInfo(blueDisease);
        
        System.out.println("Remove last blueDisease counter");
        blueDisease.removeFromBoard();
        PrintDiseaseInfo(blueDisease);
        
        System.out.println("Try to add one blueDisease counter");
        System.out.println("Success: " + blueDisease.addToBoard());
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
        blackDisease.removeFromBoard();
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("Remove all but one blackDisease counter");
        blackDisease.removeFromBoard(22);
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("Add one blackDisease counter to the Board");
        blackDisease.addToBoard();
        PrintDiseaseInfo(blackDisease);
        
        System.out.println("--- END TEST CURE AND ERADICATED METHODS ---\n");
    }

    
}

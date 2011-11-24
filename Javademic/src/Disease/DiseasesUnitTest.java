package Disease;

/**
 * A Unit Test of the Diseases Class
 * @author Brian Jerardi
 * @instructor Kendall Martin
 * @date 11/23/2011
 * @course CIS 112
 */
public class DiseasesUnitTest
{     
    private static Diseases standardDiseases;
    private static Diseases experimentalDiseases;
    private static Disease spanishFlu = new Disease("Spanish Flu", 
                "tempResources/diseaseCubes/red_disease.png", 
                15);
    private static Disease tb = new Disease("Tuberculosis", 
                "tempResources/diseaseCubes/blue_disease.png", 
                20);

    
    /**
     * Test the Diseases Class
     * @param args 
     *  the command line arguments
     */
    public static void main(String[] args)
    { 
        System.out.println("### BEGIN DISEASES UNIT TEST ###\n");
        
        createDiseasesColections();
        
        testAddDisease();
        
        testGetters();
        
        testCure();
        
        testGetDiseaseAndIndex();
        
        System.out.println("### END DISEASES UNIT TEST ###\n");
    }
    
    private static void printDiseases
            (Diseases diseasesToPrint, String collectionName)
    {
        Disease[] diseaseArray = diseasesToPrint.getDiseases();
        
        System.out.println(collectionName + "(" 
                + diseasesToPrint.getPosition() + "):");
        System.out.printf("%15s%15s%15s%15s%15s%15s%-30s\n",
                "Name","NumOnBoard","Pile","Cured","Eradicated","","ImgLoc");
        
        for (int i = 0; i < diseasesToPrint.getPosition(); i++)
        {
            System.out.printf("%15s%15s%15s%15s%15s%15s%-30s\n",
                diseaseArray[i].getName(),diseaseArray[i].getNumOnBoard(),
                diseaseArray[i].getPile(),diseaseArray[i].isCured(),
                diseaseArray[i].isEradicated(),"",diseaseArray[i].getImgFile());
        }
        System.out.println("");
    }

    /**
     * Create diseases collections and test illegal constructors
     * @parm - none
     * @postcondition
     *  standardDiseases and experimentalDiseases have been constructed
     */
    private static void createDiseasesColections()
    {
        System.out.println("--- BEGIN CREATING DISEASES COLLECTIONS ---\n");
        
        System.out.println("Create standardDiseases with no-arg constructor");
        standardDiseases = new Diseases();
        
        System.out.println("Create experimentalDiseases with 2 diseases");
        experimentalDiseases = new Diseases(2);
        
        System.out.println("Try to create another collection with 0 diseases");
        try
        {
            Diseases testDiseases = new Diseases(0);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Try to create another collection with -42 diseases");
        try
        {
            Diseases testDiseases = new Diseases(-42);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        
        System.out.println("");
        
        System.out.println("--- END CREATING DISEASES COLLECTIONS ---\n");
    }
    
    
    private static void testAddDisease()
    {  
        System.out.println("--- BEGIN ADD TEST ---\n");
        
        printDiseases(standardDiseases, "Standard Diseases");        

        System.out.println("Add red disease to standardDiseases using Disease");
        System.out.println("Success: " + standardDiseases.addDisease(
                new Disease("red", 
                        "tempResources/diseaseCubes/red_disease.png", 
                        24)));        
        printDiseases(standardDiseases, "Standard Diseases");
        
        System.out.println("Add blue disease to standardDiseases using Disease");
        System.out.println("Success: " + standardDiseases.addDisease(
                new Disease("blue", 
                        "tempResources/diseaseCubes/blue_disease.png", 
                        24)));  
        printDiseases(standardDiseases, "Standard Diseases");
        
        System.out.println("Add yellow disease to "
                + "standardDiseases using params");
        System.out.println("Success: " + standardDiseases.addDisease("yellow", 
                "tempResources/diseaseCubes/yellow_disease.png", 
                24)); 
        printDiseases(standardDiseases, "Standard Diseases");
        
        System.out.println("Add black disease to "
                + "standardDiseases using params");
        System.out.println("Success: " + standardDiseases.addDisease("black", 
                "tempResources/diseaseCubes/black_disease.png", 
                24));
        printDiseases(standardDiseases, "Standard Diseases");
        
        System.out.println("Try to add another disease to "
                + "standardDiseases using Disease");
        System.out.println("Success: " + standardDiseases.addDisease(
                new Disease("purple", 
                        "tempResources/diseaseCubes/red_disease.png", 
                        24)));
        printDiseases(standardDiseases, "Standard Diseases");
        
        printDiseases(experimentalDiseases, "Experimental Diseases");
        
        System.out.println("Add Spanish Flu to experimentalDiseases");
        System.out.println("Success: " 
                + experimentalDiseases.addDisease(spanishFlu));
        printDiseases(experimentalDiseases, "Experimental Diseases");
        
        System.out.println("Add Tuberculosis to experimentalDiseases");
        System.out.println("Success: " 
                + experimentalDiseases.addDisease(tb));
        printDiseases(experimentalDiseases, "Experimental Diseases");
        
        System.out.println("Try to add another disease to "
                + "experimentalDiseases using params");
        System.out.println("Success: " 
                + experimentalDiseases.addDisease("Black Death", 
                "tempResources/diseaseCubes/black_disease.png", 
                50));
        printDiseases(experimentalDiseases, "Experimental Diseases");
        
        
        System.out.println("--- END ADD TEST ---\n");
    }
    
    private static void testGetters()
    {
        System.out.println("--- BEGIN GETTERS TEST ---\n");
        
        printDiseases(standardDiseases, "Standard Diseases");
        printDiseases(experimentalDiseases, "Experimental Diseases");
        
        System.out.println("standardDiseases all cured: " 
                + standardDiseases.isAllCured());
        System.out.println("experimentalDiseases all cured: " 
                + experimentalDiseases.isAllCured());
        System.out.println("");
        
        System.out.println("--- END GETTERS TEST ---\n");
    }

    private static void testCure()
    {
        System.out.println("--- BEGIN CURE TEST ---\n");
        
        System.out.println("Cure standardDiseases disease at index 0");
        standardDiseases.cure(0);
        printDiseases(standardDiseases, "Standard Diseases");
        
        System.out.println("Cure standardDiseases disease at index 3");
        standardDiseases.cure(3);
        printDiseases(standardDiseases, "Standard Diseases");
        
        System.out.println("standardDiseases all cured: " 
                + standardDiseases.isAllCured());
        System.out.println("");
        
        System.out.println("Try to cure standardDiseases disease at index 4");
        try
        {
            standardDiseases.cure(4);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println("");
        
        System.out.println("Try to cure standardDiseases disease at index -1");
        try
        {
            standardDiseases.cure(-1);
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println(e);
        }
        System.out.println("");
        printDiseases(standardDiseases, "Standard Diseases");
        
        System.out.println("standardDiseases all cured: " 
                + standardDiseases.isAllCured());
        System.out.println("");
        
        
        System.out.println("Cure experimentalDiseases disease spanishFlu");
        experimentalDiseases.cure(spanishFlu);
        printDiseases(experimentalDiseases, "Experimental Diseases");
        
        System.out.println("Cure experimentalDiseases disease tb");
        experimentalDiseases.cure(tb);
        printDiseases(experimentalDiseases, "Experimental Diseases");
        
        System.out.println("experimentalDiseases all cured: " 
                + experimentalDiseases.isAllCured());
        System.out.println("");
        
        System.out.println("Try to cure experimentalDiseases disease "
                + "not in the collection");
        try
        {
            experimentalDiseases.cure(
                    new Disease("Black Plague", 
                            "tempResources/diseaseCubes/black_disease.png", 
                            50));
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("");
        
        printDiseases(experimentalDiseases, "Experimental Diseases");
        
        System.out.println("experimentalDiseases all cured: " 
                + experimentalDiseases.isAllCured());
        System.out.println("");
        
        System.out.println("--- END CURE TEST ---\n");
    }

    private static void testGetDiseaseAndIndex()
    {
        System.out.println("--- BEGIN GET DISEASE AND INDEX TEST ---\n");
                 
        printDiseases(standardDiseases , "Standard Diseases");
        
        System.out.println("Get diseases from standardDiseases at indexes\n");
        System.out.printf("%15s%30s%15s%15s%15s%15s%15s%15s%-30s\n", 
                "index", "Reference", "Name","NumOnBoard","Pile",
                "Cured","Eradicated","","ImgLoc");
        System.out.printf("%15s%30s%15s%15s%15s%15s%15s%15s%-30s\n", 
                0, standardDiseases.getDisease(0), 
                standardDiseases.getDisease(0).getName(),
                standardDiseases.getDisease(0).getNumOnBoard(),
                standardDiseases.getDisease(0).getPile(),
                standardDiseases.getDisease(0).isCured(),
                standardDiseases.getDisease(0).isEradicated(),"",
                standardDiseases.getDisease(0).getImgFile());
        System.out.printf("%15s%30s%15s%15s%15s%15s%15s%15s%-30s\n", 
                1, standardDiseases.getDisease(1), 
                standardDiseases.getDisease(1).getName(),
                standardDiseases.getDisease(1).getNumOnBoard(),
                standardDiseases.getDisease(1).getPile(),
                standardDiseases.getDisease(1).isCured(),
                standardDiseases.getDisease(1).isEradicated(),"",
                standardDiseases.getDisease(1).getImgFile());
        System.out.printf("%15s%30s%15s%15s%15s%15s%15s%15s%-30s\n", 
                2, standardDiseases.getDisease(2), 
                standardDiseases.getDisease(2).getName(),
                standardDiseases.getDisease(2).getNumOnBoard(),
                standardDiseases.getDisease(2).getPile(),
                standardDiseases.getDisease(2).isCured(),
                standardDiseases.getDisease(2).isEradicated(),"",
                standardDiseases.getDisease(2).getImgFile());
        System.out.printf("%15s%30s%15s%15s%15s%15s%15s%15s%-30s\n", 
                3, standardDiseases.getDisease(3), 
                standardDiseases.getDisease(3).getName(),
                standardDiseases.getDisease(3).getNumOnBoard(),
                standardDiseases.getDisease(3).getPile(),
                standardDiseases.getDisease(3).isCured(),
                standardDiseases.getDisease(3).isEradicated(),"",
                standardDiseases.getDisease(3).getImgFile());
        
        System.out.println("");
        
        System.out.println("Try to get disease at index 4");
        try
        {
            standardDiseases.getDisease(4);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {             
            System.out.println(e);
        }
        
        System.out.println("Try to get disease at index -1");
        try
        {
            standardDiseases.getDisease(-1);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {             
            System.out.println(e);
        }
        
        System.out.println("");
        
        System.out.println("Get index of spansishFlu");
        System.out.println("spanishFlu[" 
                + experimentalDiseases.getIndex(spanishFlu) + "]");
        System.out.println("Get index of tb");
        System.out.println("tb[" 
                + experimentalDiseases.getIndex(tb) + "]");
        System.out.println
                ("Get index of blackPlague (doesn't exist in collection)");
        System.out.println("blackPlague[" 
                + experimentalDiseases.getIndex(
                new Disease("Black Plague", 
                        "tempResources/diseaseCubes/black_disease.png", 
                        50)
                ) + "]");
        
        System.out.println("");
        
        System.out.println("--- END GET DISEASE AND INDEX TEST ---\n");
    }   
}

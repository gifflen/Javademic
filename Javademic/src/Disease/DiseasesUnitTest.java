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
        
        System.out.println("### END DISEASES UNIT TEST ###\n");
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
        Disease spanishFlu = new Disease("Spanish Flu", 
                "tempResources/diseaseCubes/red_disease.png", 
                15);
        Disease tb = new Disease("Tuberculosis", 
                "tempResources/diseaseCubes/blue_disease.png", 
                20);
        
        
        System.out.println("--- BEGIN ADD TEST ---\n");
        
        System.out.println("Add red disease to standardDiseases using Disease");
        System.out.println("Success: " + standardDiseases.addDisease(
                new Disease("red", 
                        "tempResources/diseaseCubes/red_disease.png", 
                        24)) + "\n");
        
        System.out.println("Add blue disease to standardDiseases using Disease");
        System.out.println("Success: " + standardDiseases.addDisease(
                new Disease("blue", 
                        "tempResources/diseaseCubes/blue_disease.png", 
                        24)) + "\n");        
        
        System.out.println("Add yellow disease to "
                + "standardDiseases using params");
        System.out.println("Success: " + standardDiseases.addDisease("yellow", 
                "tempResources/diseaseCubes/yellow_disease.png", 
                24) + "\n");        
        
        System.out.println("Add black disease to "
                + "standardDiseases using params");
        System.out.println("Success: " + standardDiseases.addDisease("black", 
                "tempResources/diseaseCubes/black_disease.png", 
                24) + "\n");
        
        System.out.println("Try to add another disease to "
                + "standardDiseases using Disease");
        System.out.println("Success: " + standardDiseases.addDisease(
                new Disease("purple", 
                        "tempResources/diseaseCubes/red_disease.png", 
                        24)) + "\n");
        
        System.out.println("Add Spanish Flu to experimentalDiseases");
        System.out.println("Success: " 
                + experimentalDiseases.addDisease(spanishFlu) + "\n");
        
        System.out.println("Add Tuberculosis to experimentalDiseases");
        System.out.println("Success: " 
                + experimentalDiseases.addDisease(tb) + "\n");
        
        System.out.println("Try to add another disease to "
                + "experimentalDiseases using params");
        System.out.println("Success: " 
                + experimentalDiseases.addDisease("Black Death", 
                "tempResources/diseaseCubes/black_disease.png", 
                50) + "\n");
        
        
        System.out.println("--- END ADD TEST ---\n");
    }
    
    private static void testGetters()
    {
        System.out.println("--- BEGIN GETTERS TEST ---\n");
        
        
        
        System.out.println("--- END GETTERS TEST ---\n");
    }


    
}

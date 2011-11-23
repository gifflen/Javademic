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

    
}

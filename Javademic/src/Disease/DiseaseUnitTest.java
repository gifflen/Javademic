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
    private static Disease d1;
    private static Disease d2;
    private static Disease d3;
    private static Disease d4;
    
    /**
     * Test the Disease Class
     * @param args 
     *  the command line arguments
     */
    public static void main(String[] args)
    { 
        createDiseases();
        
    }

    private static void createDiseases()
    {
        d1 = new Disease
                ("red", 
                "../../tempResources/diseaseCubes/black_disease.png", 
                24);
    }

    
}

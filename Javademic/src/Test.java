
import UnitTests.DiseaseUnitTest;
import UnitTests.DiseasesUnitTest;
import UnitTests.LocationUnitTest;
import UnitTests.ResearchStationCollectionTest;
import UnitTests.ResearchStationTest;




/**
 * Calls test classes
 * @author Brian Jerardi
 * @instructor Kendall Martin
 * @date 11/23/2011
 * @course CIS 112
 */
public class Test
{
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {         
        ResearchStationTest.main(args);
        ResearchStationCollectionTest.main(args);
        DiseaseUnitTest.main(args);
        DiseasesUnitTest.main(args);
        LocationUnitTest.main(args);
        
    }
}

package UnitTests;

import Cards.Card;
import Cards.CityCard;
import Cards.EpidemicCard;
import Cards.SpecialEventCard;
import Location.Location;

/**
 * Tests the EpidemicCard, SpecialEventCard, and CityCard 
 * @author Brian Jerardi
 */
public class PlayerCardsUntiTests
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {               
        System.out.println("### Player Cards Unit Tests ###\n");
        
        epidemicCardTest();
        
        specialEventCardTest();
        
        cityCardTest();
        
        System.out.println("### End Card Unit Test ###\n");
    }

    /**
     * Test the EpidemicCard
     */
    private static void epidemicCardTest()
    {
        System.out.println("*** EpidemicCard Unit Test ***\n");
        
        System.out.println("Construct new card epCard with location "
                + "\"somelocation\\epfile.jpg\" and name \"Epidemic\"");
        EpidemicCard epCard = new EpidemicCard("somelocation\\epfile.jpg", "Epidemic");
        System.out.println("");
        
        System.out.println("epCard Name   : " + epCard.getName());
        System.out.println("epCard ImgLoc : " + epCard.getImageLoc());
        System.out.println("");
        System.out.println("epCard Step1  : " + epCard.getStep1());
        System.out.println("epCard Step2  : " + epCard.getStep2());
        System.out.println("epCard Step3  : " + epCard.getStep3());
        System.out.println("");
        
        
        System.out.println("*** End EpidemicCard Unit Test ***\n");
    }

    /**
     * Test SpecialEvenCard
     */
    private static void specialEventCardTest()
    {
        System.out.println("*** SpecialEventCard Unit Test ***\n");
        
        System.out.println("Construct new card sEventCard with location "
                + "\"somelocation\\sEventFile.jpg\","
                + " name \"Some Special Event\", "
                + "and description \"Special Event Description\"");
        SpecialEventCard sEventCard = new SpecialEventCard
                ("somelocation\\sEventFile.jpg", 
                "Some Special Event", 
                "Special Event Description");
        System.out.println("");
        
        System.out.println("sEventCard Name        : " 
                + sEventCard.getName());
        System.out.println("sEventCard ImgLoc      : " 
                + sEventCard.getImageLoc());
        System.out.println("sEventCard Description : " 
                + sEventCard.getDescription());
        System.out.println("");
        
        
        System.out.println("*** End SpecialEventCard Unit Test ***\n");
    }
    
    /**
     * Test CityCard
     */
    private static void cityCardTest()
    {
        System.out.println("*** CityCard Unit Test ***\n");
        
        Location testLoc = new Location("Loc Name");
        
        System.out.println("Construct new card cityCard with image location "
                + "\"somelocation\\sEventFile.jpg\","
                + " name \"Some Special Event\", "
                + "and location testLoc");
        CityCard cityCard = new CityCard("somelocation\\cityFile.jpg", 
                "Some City",
                testLoc); 
        System.out.println("");
        
        System.out.println("cityCard Name        : " 
                + cityCard.getName());
        System.out.println("cityCard ImgLoc      : " 
                + cityCard.getImageLoc());
        System.out.println("cityCard Location    : " 
                + cityCard.getLocation());
        System.out.println("");
        
        
        System.out.println("*** End CityCard Unit Test ***\n");
    }
    
}

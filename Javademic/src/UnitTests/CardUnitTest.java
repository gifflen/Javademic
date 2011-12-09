package UnitTests;

import Cards.Card;

/**
 * Tests the Card Class
 * @author Brian Jerardi
 */
public class CardUnitTest
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {               
        System.out.println("### Card Unit Test ###\n");
        
        System.out.println("Construct new card testCard with location "
                + "\"somelocation\\somefile.jpg\" and name \"A Test Name\"");
        Card testCard = new Card("somelocation\\somefile.jpg", "A Test Name");
        System.out.println("");
        
        System.out.println("testCard Name   : " + testCard.getName());
        System.out.println("testCard ImgLoc : " + testCard.getImageLoc());
        System.out.println("");
        
        System.out.println("Set name to \"A New Name\"");
        System.out.println("Set imageLoc to \"somelocation\\otherfile.jpg\"");
        System.out.println("");
        
        System.out.println("testCard Name   : " + testCard.getName());
        System.out.println("testCard ImgLoc : " + testCard.getImageLoc());
        System.out.println("");
        
        System.out.println("### End Card Unit Test ###\n");
    }
}

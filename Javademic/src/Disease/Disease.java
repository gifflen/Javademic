package Disease;

import java.io.File;

/**
 * A class to hold disease objects
 * @author Brian Jerardi
 * @instructor Kendall Martin
 * @date 11/23/2011
 * @course CIS 112
 */
public class Disease
{
    private String color;
    private File imgFile;
    private int pile;
    private int numOnBoard;
    private boolean cured;
    private boolean eradicated;

    
    /**
     * Constructs Disease Object
     * @param initialColor
     *  The initial color of the disease
     * @param initialImgLoc
     *  The initial location of the image
     * @param initialPile 
     *  The initial number of diseases
     * @precondition
     *  intialImgLoc must be a valid location
     *  intialPile must be a positive number
     * @postcondition
     *  A Disease object has been create with intialColor, intialImgLoc, and 
     *  initialPile.  numOnBoard is 0.  cured and eradicated are false.
     * @exception IllegalArgumentException
     *  initialImgLoc does not exist
     * @exception IllegalArgumentException
     *  initialPile is NOT positive
     */
    public Disease(String initialColor, String initialImgLoc, int initialPile)
    {
        imgFile = new File(initialImgLoc);

        if (!imgFile.isFile())
        {
            throw new IllegalArgumentException(initialImgLoc + ": Not Found");
        }
        
        if (initialPile < 1)
        {
            throw new IllegalArgumentException("Pile must be a postive number");
        }
        
        color = initialColor;
        pile = initialPile;
        numOnBoard = 0;
        cured = false;
        eradicated = false;        
    }

    /**
     * Get this diseases color
     * @return 
     *  The color string of this disease
     */
    public String getColor()
    {
        return color;
    }

    /**
     * Get this diseases image file
     * @return 
     *  The image file of this disease
     */
    public File getImgFile()
    {
        return imgFile;
    }

    /**
     * Get the number of counters on the board
     * @return 
     *  The number of counters on the board
     */
    public int getNumOnBoard()
    {
        return numOnBoard;
    }

    /**
     * Get the number of counters in the pile
     * @return 
     *  The number of counters in the pile
     */
    public int getPile()
    {
        return pile;
    }
    
    /**
     * Cure this disease
     * @postcondition
     *  cured is true
     *  If numOnBoard is 0 then eradicated is also true
     */
    public void cure()
    {
        cured = true;
        
        if (numOnBoard == 0)
        {
            eradicated = true;
        }
    }

    /**
     * Check if this disease is cured
     * @return 
     *  true if it is cured
     *  false if it is NOT cured
     */
    public boolean isCured()
    {
        return cured;
    }

    /**
     * Check if this disease is eradicated
     * @return 
     *  true if it is eradicated
     *  false if it is NOT eradicated
     */
    public boolean isEradicated()
    {
        return eradicated;
    }
    
    /**
     * Add one disease counter to the board
     * @precondition
     *  pile is greater than 0
     *  isEradicated is false
     * @postcondition
     *  pile has been decremented
     *  numOnBoard has been incremented
     * @return 
     *  true if it was successful
     *  false if disease is eradicated or pile is less than 1; unsuccessful add
     */
    public boolean addToBoard()
    {
        if (eradicated || pile < 1)
        {
            return false;
        }
        
        pile--;
        numOnBoard++;
        
        return true;
    }
    
    /**
     * Add a variable number of disease counters to the board
     * @param num
     *  The number of disease counters to add to the board
     * @precondition
     *  pile is greater than or equal to num
     * @postcondition
     *  num number of disease counters have been added to the board
     * @return 
     *  true if it was successful
     *  false if pile had insufficient diseases to add, so it was unsuccessful
     */
    public boolean addToBoard(int num)
    {        
        for (int i = 0; i < num; i++)
        {
            if(!addToBoard())
            {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Removes One disease counter from the board
     * @precondition
     *  There are disease counters on the board
     * @postcondition
     *  numOnBoard has been decremented
     *  pile has been incremented
     *  If the this disease is cured and the last counter is removed from the
     *  board eradicated is set to true
     * @exception IllegalStateException
     *  There are no disease counters of the board
     */
    public void removeFromBoard()
    {
        if (numOnBoard < 1)
        {
            throw new IllegalStateException
                    ("Insufficient disease counters are on the board");
        }
        
        numOnBoard--;
        pile++;
        
        if(cured && numOnBoard == 0)
        {
            eradicated = true;
        }
    }
    
    /**
     * Removes variables number of disease counters from the board
     * @param num 
     *  The number of disease counters to remove from the board
     * @precondition
     *  There are num number of disease counters on the board
     * @postcondition
     *  numOnBoard has been decremented by num
     *  pile has been incremented by num
     *  If the this disease is cured and the last counter is removed from the
     *  board eradicated is set to true
     * @exception IllegalStateException
     *  There are not num disease counters of the board
     */
    public void removeFromBoard(int num)
    {
        for (int i = 0; i < num; i++)
        {
            removeFromBoard();
        }
        
    }
    
}

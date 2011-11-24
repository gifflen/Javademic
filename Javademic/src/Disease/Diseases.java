package Disease;

/**
 * A collection class to manage Diseases
 * @author Brian Jerardi
 * @instructor Kendall Martin
 * @date 11/23/2011
 * @course CIS 112
 */
public class Diseases
{
    private Disease[] diseases;
    private int position;
    private boolean allCured;
    
    /**
     * Constructs Diseases collection with diseaseCount number of diseases
     * @precondition
     *  diseaseCount is greater than 0
     * @param diseaseCount 
     *  The number of diseases this collection contains
     * @postcondition
     *  Diseases has been constructed with diseaseCount number of diseases
     *  And counter is set to 0, And allCured is set to false
     * @exception IllegalArgumentException
     *  diseaseCount was less than 1
     */
    public Diseases(int diseaseCount)
    {
        if (diseaseCount < 1)
        {
            throw new IllegalArgumentException
                    (diseaseCount + ": diseaseCount must be positive.");
        }
        
        diseases = new Disease[diseaseCount];
        position = 0;
        allCured = false;
    }
    
    /**
     * Constructs Diseases collection with 4 diseases
     * @postcondition
     *  Diseases has been constructed with 4 diseases
     *  And counter is set to 0, And allCured is set to false
     */
    public Diseases()
    {
        this(4);
    }
    
    /**
     * Adds a disease to this collection
     * @precondition
     *  diseases is not full
     * @param disease
     *  The disease to add to this collection
     * @postcondition
     *  disease has been added to this collection
     *  position has been incremented
     * @return 
     *  true if disease was added
     *  false if disease was NOT added because diseases was full
     */
    public boolean addDisease(Disease disease)
    {
        if (position >= diseases.length)
        {
            return false;
        }
        
        diseases[position++] = disease;
        return true;
    }
    
    /**
     * Adds a disease with initialColor, initialImgLoc, 
     *  and initialCount to this collection
     * @precondition
     *  diseases is not full
     * @param initialColor
     *  The initial color of the disease to add
     * @param initialImgLoc
     *  The initial image location of the disease to add
     * @param initialCount
     *  The initial count of the disease to add
     * @postcondition
     *  disease has been added to this collection
     *  position has been incremented
     * @return 
     *  true if disease was added
     *  false if disease was NOT added because diseases was full
     */
    public boolean addDisease
            (String initialColor, String initialImgLoc, int initialCount)
    {
        return addDisease
                (new Disease(initialColor, initialImgLoc, initialCount));
    }
    
    /**
     * Cure the disease at diseaseLoc
     * @precondition
     *  diseaseLoc is a valid position in diseases array
     * @param diseaseLoc 
     *  The position of the disease to cure
     * @exception IndexOutOfBoundsException
     *  diseaseLoc was NOT a valid position in diseases array
     */
    public void cure(int diseaseLoc)
    {
        diseases[diseaseLoc].cure();
        
        if (checkAllCured())
        {
            allCured = true;
        }       
    }
    
    /**
     * Cure diseaseToCure
     * @precondition
     *  diseaseToCure is in this collection
     * @param diseaseToCure 
     *  The disease to cure
     * @postcondition
     *  diseaseToCure has been cured
     * @exception IllegalArgumentException
     *  diseaseToCure was NOT in this collection
     */
    public void cure(Disease diseaseToCure)
    {
        int cureAt = -1;
        for (int i = 0; i < diseases.length; i++)
        {
            if (diseases[i] == diseaseToCure)
            {
                cureAt = i;
            } 
        }
        
        if (cureAt == -1)
        {
            throw new IllegalArgumentException
                    ("Disease : " + diseaseToCure + " Not Found.");
        }
        
        cure(cureAt);
    }
    
    /**
     * Check if all disease are cured
     * @return 
     *  True if all diseases are cured
     *  False if any disease are not cured
     */
    private boolean checkAllCured()
    {
        for (Disease disease : diseases)
        {
            if (!disease.isCured())
            {
                return false;
            }
        }
        
        return true;
    }

    /**
     * Checks is all disease are cured
     * @return 
     *  True if all diseases are cured
     *  False if any disease is not cured
     */
    public boolean isAllCured()
    {
        return allCured;
    }

    /**
     * Gets the diseases array
     * @return 
     *  An array of Diseases
     */
    public Disease[] getDiseases()
    {
        return diseases;
    }

    /**
     * Gets the current position
     * @return 
     *  The current position
     */
    public int getPosition()
    {
        return position;
    } 
    
}

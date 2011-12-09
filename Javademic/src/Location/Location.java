package Location;

/**
 * Location stub for Card Testing
 */
public class Location
{
    public String name;
    
    /**
     * Constructs a location stub with initialName
     * @param initialName 
     *  The initialName of this location stub
     * @postcondition
     *  A Location has been constructed with initialName
     */
    public Location(String initialName)
    {
        name = initialName;
    }
    
    /**
     * Gets the string version of this location stub
     * @return 
     */
    @Override
    public String toString()
    {
        return name;
    }
}

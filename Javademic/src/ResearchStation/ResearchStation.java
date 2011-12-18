package ResearchStation;

import Locations.Location;

/**
 * A class to manage a Research Station
 * @author Brian Jerardi
 */
public class ResearchStation
{
    private Location location;
    
    /**
     * Constructs a research station at location
     * @param location 
     *  The location to construct a research station
     */
    public ResearchStation(Location location)
    {
        this.location = location;
    }
    
    /**
     * Get the location of this research station
     * @return 
     *  The location of this research station
     */
    public Location getLocation()
    {
        return location;
    }
    
    /**
     * Set the location of this research station
     * @param location 
     *  The location to set this research stations location to
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
}

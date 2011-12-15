package ResearchStation;

import Locations.Location;

/**
 * A class to manage a Research Station
 * @author Brian Jerardi
 */
public class ResearchStation
{
    private Location location;
    
    public ResearchStation(Location location)
    {
        this.location = location;
    }
    
    public Location getLocation()
    {
        return location;
    }
    
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
}

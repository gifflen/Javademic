package ResearchStation;

import Locations.Location;

/**
 * A collection Class for ResearchStations
 * @author Brian Jerardi
 */
public class ResearchStationCollection
{
    private ResearchStation[] stations;
    private int count;
    private int max;
    
    /**
     * Creates a collection of max ResearchStations
     * @param max 
     *  The maximum number of research stations.
     * @precondition
     *  max is a positive number
     * @postcondition
     *  max contains the maximum number of research stations
     *  stations can only hold max stations
     *  count is set to 0
     * @exception IllegalArgumentException
     *  max contained a non positive number
     */
    public ResearchStationCollection(int max)
    {
        if (max < 1)
        {
            throw new IllegalArgumentException("max must be a positive number");
        }
        
        this.max = max;
        stations = new ResearchStation[max];
        count = 0;
    }
    
    /**
     * Creates a default collection of 6 ResearchStations
     * @postcondition
     *  max contains the maximum number of research stations 6
     *  stations can only hold 6 stations
     *  count is set to 0
     */
    public ResearchStationCollection()
    {        
        this(6);
    }
    
    /**
     * Adds a Research Station to location
     * @param location
     *  The location to add a research station to
     * @return 
     *  true if the station was added
     *  false if it was not
     */
    public boolean addStation(Location location)
    {
        // If not all stations have been assigned add this one to the end
        if (count < max)
        {
            stations[count] = new ResearchStation(location);
            count++;
            return true;
        }
        
        // If all stations are assign ask if user would like to move one
        if(confirmMove())
        {
            // If a user wishes to move a station get which one to move
            stations[getChoiceOfMove()].setLocation(location);
            return true;
        }
        
        // If no station was added return false
        return false;
        
    }
    
    /**
     * Confirms the users move of a station
     * @return 
     *  true if the user chooses to move a station
     *  false if the user chooses not to move a station
     */
    private boolean confirmMove()
    {
        //TODO Offer user choice if they would like to move a station
        return true;
    }

    /**
     * Gets the users choice of station to move
     * @return 
     *  the position of the station to move
     */
    private int getChoiceOfMove()
    {
        //TODO get users choice for which station to move
        return 0;
    }
    
    /**
     * Gets all locations containing a Research Station
     * @return 
     *  an array of Locations containing the locations of all research stations
     */
    public Location[] getLocations()
    {
        Location[] locs = new Location[count];
        
        for(int i = 0; i < count; i++)
        {
            locs[i] = stations[i].getLocation();
        }
        
        return locs;
    }
    
    
}

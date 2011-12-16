package Cards;

import Locations.Location;

/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 */
public class PlayerCard {
    Location location;

    public Location getLocation() {
        return location;
    }

    public PlayerCard(Location location) {
        this.location = location;


    }
    
    public void displayCard(){
        System.out.println(this.location.getLocationName() + " : " +  this.location.getBaseDisease());
    }
    
    @Override
    public String toString() {
        return (this.location.getLocationName());
    }
}

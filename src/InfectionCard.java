/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 * 
 * Infection card class. 
 * Card adds infection to specific location.
 */
public class InfectionCard {
    Location location;

    public InfectionCard(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return this.location.getLocationName();
    }
}

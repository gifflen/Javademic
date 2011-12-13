/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
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

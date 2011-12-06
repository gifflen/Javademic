import java.util.ArrayList;

/**
 * User: Gifflen
 */
public class Location {
    private String locationName;
    private ArrayList<Location> connections;

    public void addConnection(Location connection){
        if (!connections.contains(connection)){
            connections.add(connection);
        }
    }

    public Location(String locationName) {
        this.locationName = locationName;
        this.connections = new ArrayList<Location>();
    }

    public String getLocationName() {
        return locationName;
    }

    public ArrayList<Location> getConnections() {
        return connections;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", connections=" + connections +
                '}';
    }
}

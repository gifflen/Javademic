package Locations;

import Disease.Disease;
import java.util.HashMap;
/**
 * User: Gifflen
 */
public class Location {
    private String locationName;
    private String color;
    private HashMap<String,Location> connections;
    private HashMap<Disease,Integer> presentDiseases;
    private boolean outBreakThisTurn;
    private Disease baseDisease;
    
    /**
     * Get the Locations color
     * @return 
     *  The color of this location
     */
    public String getColor() {
        return color;
    }

    /**
     * Set the color of this location
     * @param color 
     *  The color to set this location to
     * @postcondition
     *  The color of this location has been set to color
     */
    public void setColor(String color) {
        this.color = color;
    }

    public void addConnection(Location connection){
        if (!connections.containsKey(connection.getLocationName())){
            connections.put(connection.getLocationName(),connection);
        }
    }

    /**
     * Get the Base Disease for this location
     * @return 
     *  the Base Disease for this class
     */
    public Disease getBaseDisease() {
        return baseDisease;
    }

    /**
     * Set the Base Disease for this location
     * @param baseDisease 
     *  The disease to set Base Disease to
     * @postcondition
     *  baseDisease for this location has been set to baseDisease
     */
    public void setBaseDisease(Disease baseDisease) {
        this.baseDisease = baseDisease;
    }

    /**
     * Constructs a location with locationName
     * @param locationName 
     *  The location has been constructed with locationName as its name
     */
    public Location(String locationName) {
        this.locationName = locationName.trim();
        this.connections = new HashMap<String,Location>();
        this.presentDiseases = new HashMap<Disease, Integer>();
        this.outBreakThisTurn = false;

    }

    /**
     * Gets this locations name
     * @return 
     *  The name of this location
     */
    public String getLocationName() {
        return locationName;
    }

    public HashMap<String,Location> getConnections() {
        return connections;
    }

    /**
     * Sets the name of this location
     * @param locationName 
     *  the new name of this location
     * @postcondition
     *  the name of this location is set to locationName
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String listLocations(){
        String out = "";
        for(String location: connections.keySet()){
            out+= location + ";";
        }
        return out;
    }

    public void infect(Disease incDisease){
        if (presentDiseases.containsKey(incDisease)){
            int currentInfectionCount = presentDiseases.get(incDisease);
            if (currentInfectionCount<3){
                presentDiseases.put(incDisease,currentInfectionCount+1);
                incDisease.addToBoard(1);
                System.out.println("Reamining cubes of " + incDisease.getName() + ": " + incDisease.getPile());
            }else {
                if (!outBreakThisTurn){
                    outbreak(incDisease);
                }
            }
        }else{
            presentDiseases.put(incDisease,1);
            incDisease.addToBoard(1);
            System.out.println("Reamining cubes of " + incDisease.getName() + ": " + incDisease.getPile());
        }

    }

    public void infect(Disease incDisease,int count){
       for (int i = 0; i<count;i++){
           infect(incDisease);
       }
    }

    public void outbreak(Disease incDisease){
        this.outBreakThisTurn = true;
        for (Location connection: connections.values()){
            connection.infect(incDisease);
        }
    }

    public static String cleanString(String incLocationName){
        incLocationName = Character.toUpperCase(incLocationName.charAt(0)) + incLocationName.substring(1).toLowerCase();
        incLocationName= incLocationName.trim();
        return incLocationName;
    }
    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", connections=" + this.listLocations() +
                '}';
    }
}

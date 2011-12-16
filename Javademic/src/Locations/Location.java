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

    public HashMap<Disease, Integer> getPresentDiseases() {
        return presentDiseases;
    }
    private boolean outBreakThisTurn;
    private Disease baseDisease;

    public boolean outBreakThisTurn() {
        return outBreakThisTurn;
    }
    
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

    /**
     * Adds a connection to the parameter connection
     * @param connection 
     *  The location to add a connection to
     * @postcondition
     *  This location has a connection to param connection and
     *  param connection has a connection to this location
     */
    public void addConnection(Location connection){
        if (!connections.containsKey(connection.getLocationName())){
            connections.put(connection.getLocationName(),connection);
        }
        
        if (!connection.connections.containsKey(this.getLocationName()))
        {
            connection.connections.put(locationName, this);
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

    /**
     * Gets the connections of this location
     * @return 
     *  The connections of this location as a HashMap<String,Location>
     */
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

    /**
     * Lists the location connections as a string
     * @return 
     *  A String of this locations connections names
     */
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
    
    /**
     * Lists the location connections as a string
     * @return 
     *  A String of this locations connections names
     */
    public String listDiseases(){
        String out = "";
        
        for(Disease disease: presentDiseases.keySet()){
            out+= disease.getName() + ";";
        }
        
        out+= "\n";
        
        for(Integer count: presentDiseases.values()){
            out+= count + ";";
        }
        
        return out;
    }
    
    /**
     * Gets the present diseases
     * @return 
     *  A HashMap<Disease, Integer> of the present diseases
     */
    public HashMap<Disease, Integer> getPresentDiseases()
    {
        return presentDiseases;
    }
            

    public void infect(Disease incDisease,int count){
       System.out.println("Infecting " + locationName + " with " + incDisease.getName());
        for (int i = 0; i<count;i++){
           infect(incDisease);
       }
    }

    public void outbreak(Disease incDisease){
        System.out.println("OUTBREAK AT " +  locationName + " of " + incDisease.getName());
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
    
    public void printDiseases(){
        String message="";
        if (!presentDiseases.isEmpty()){
            message+=locationName + " ## ";
            for (Disease disease : presentDiseases.keySet()){
                message+=disease.getName() + ":" + presentDiseases.get(disease)+ " # ";
            }
            System.out.println(message);
        }
    }
}

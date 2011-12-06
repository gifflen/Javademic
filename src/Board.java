import java.io.*;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 */
public class Board {
    private HashMap<String,Location> locations =  new HashMap<String, Location>();
    private File locationCSV = new File("C:\\Users\\Gifflen\\IdeaProjects\\Javademic\\src\\Locations.csv");

    public Board() {

        this.setUpLocations();
        for (Map.Entry<String, Location> stringLocationEntry : locations.entrySet()) {
            Map.Entry pairs;
            pairs = stringLocationEntry;
            Location test = (Location) pairs.getValue();
            if (test.listLocations().length() < 1) {
                System.out.println(test.toString());
            }
            //System.out.println(pairs.getKey() +  " = " + pairs .getValue());
        }
    }

    public Location addLocationToBoard(String locationName){
        locationName = Location.cleanString(locationName);
        if (!locations.containsKey(locationName)){
           //System.out.println("Adding " + locationName);
           locations.put(locationName,new Location(locationName));
        }
        return locations.get(locationName);
    }

    public void setUpLocations(){
        locations = new HashMap<String,Location>();
        readCSV();
    }

    public Location getLocationByName(String locationName){
        return locations.get(Location.cleanString(locationName));
    }

    private void readCSV(){
        String line;
        BufferedReader reader;
        int fieldNumber;
        try {
            reader = new BufferedReader(new FileReader(locationCSV));
            while ((line = reader.readLine())!= null){
                fieldNumber=2;
                String field[] = line.split(",");
                //Using trim here to remove whitespace
                String primaryLocationName =  field[0].trim();
                String color = field[1];
                Location currentLocation = addLocationToBoard(primaryLocationName);
                currentLocation.setColor(color);
                while (fieldNumber<field.length){
                    if (field[fieldNumber].length()>0){
                        Location connection =  addLocationToBoard(field[fieldNumber]);
                        currentLocation.addConnection(connection);
                    }
                    fieldNumber++;
                }
                System.out.println(currentLocation);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("CANNOT FIND FILE: " + locationCSV);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}

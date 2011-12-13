import java.io.*;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 */
public class Board {
    private HashMap<String,Location> locations =  new HashMap<String, Location>();
    private File locationCSV = new File("src\\Locations.csv");
    private Location defaultLocation;
    private int numPlayers;
    private int difficulty;
    final String DEFAULT_LOCATION_NAME = "Atlanta";
    private Pawn[] players;
    private Deque<PlayerCard> playerDeck;
    private Deque<InfectionCard> infectionDeck;




    public int getDifficulty() {
        return difficulty;
    }

    public Location getDefaultLocation() {

        return defaultLocation;
    }

    private void setDefaultLocation(Location defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public Board() {

        this.initLocations();
        this.initPlayers();
        this.initDifficulty();
        this.initDeck();

    }

    public Location addLocationToBoard(String locationName){
        locationName = Location.cleanString(locationName);
        if (!locations.containsKey(locationName)) {
            System.out.println("Adding " + locationName);
            locations.put(locationName, new Location(locationName));
            return locations.get(locationName);
        } else {
            return locations.get(locationName);
        }
    }

    private void initLocations(){
        System.out.println("Initializing Locations...");
        locations = new HashMap<String,Location>();
        readCSV();
        this.setDefaultLocation(this.getLocationByName(DEFAULT_LOCATION_NAME));
    }

    public void initPlayers(){
        System.out.println("Initializing Players...");
        numPlayers = getIntInput("How many players will play in this game? 2-4: ", 2, 4);
        System.out.println("You've Chosen to play with " + numPlayers + " Players.");
        players = new Pawn[numPlayers];
        //Choose Roles
        //Determine Turn Order
        //Sort pawns
    }

    public void initDifficulty(){
        System.out.println("Initializing Difficulty...");
        difficulty = getIntInput("Please Select Difficulty Level\n" +
                            "1. Introductory\n" +
                            "2. Normal \n" +
                            "3. Heroic",1,3);
       System.out.println("You've Chosen to play at the " + difficulty + " difficulty level");
    }

    public void initDeck(){
        System.out.println("Initializing Decks...");

        for (Location location : locations.values()) {
            PlayerCard playerCard = new PlayerCard(location);
            InfectionCard  infectionCard = new InfectionCard(location);
            playerDeck.push(playerCard);
            infectionDeck.push(infectionCard);
        }

        //Shuffle Deck
        System.out.println("NOT IMPLEMENTED YET");
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
                        System.out.println("\t Adding Connection.getLocationName(): " + connection);
                    }
                    fieldNumber++;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("CANNOT FIND FILE: " + locationCSV);
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private int getIntInput(String message,int lowBound,int highBound){
        Scanner userInputScanner = new Scanner(System.in);
        String userInput = "";
        int inputInt=0;
        do{
            System.out.println(message);

            userInput = userInputScanner.next();

            try{
                inputInt = Integer.parseInt(userInput);
            }catch (NumberFormatException e ){
                System.out.println("Please input an integer.");
            }
        } while (((inputInt<lowBound)||(inputInt>highBound)));
        return inputInt;
    }



}
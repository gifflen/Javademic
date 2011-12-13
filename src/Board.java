import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

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
    private Deck<PlayerCard> playerDeck;
    private Deck<PlayerCard> playerDiscardDeck;
    private Deck<InfectionCard> infectionDeck;
    private Deck<InfectionCard> infectionDiscardDeck;
    private int infectionRate;
    private int outbreakLevel;
    private Diseases diseases = new Diseases();



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

    public int getInfectionRate() {
        return infectionRate;
    }

    public void setInfectionRate(int infectionRate) {
        this.infectionRate = infectionRate;
    }

    public void increaseInfectionRate(){
        //Need to add logic to increase infection rate.
    }

    public int getOutbreakLevel() {
        return outbreakLevel;
    }

    public void setOutbreakLevel(int outbreakLevel) {
        this.outbreakLevel = outbreakLevel;
    }

    public Board() {
        this.setInfectionRate(2);
        this.setOutbreakLevel(0);
        this.initLocations();
        this.initPlayers();
        this.initDifficulty();
        this.initDecks();
        this.initialInfect();

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
    private void initialInfect(){
        System.out.println("Drawing Cards for initial infection");
        //Draw 3 infect with 3
        for (int i =3; i>0 ;i--){
          for (int j=0;j<3;j++){
              InfectionCard drawn = (InfectionCard)infectionDeck.pop();
              System.out.println("Drew " + drawn);
              Location cardLocation = drawn.getLocation();
              System.out.println("Infecting "+drawn+ " with " + i +" disease cubes");
              Disease diseaseToInfect =diseases.getDiseaseByName(cardLocation.getColor());
              cardLocation.infect(diseaseToInfect,i);
              System.out.println("Discarding " + drawn);
              playerDiscardDeck.push(drawn);
          }
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

    public void initDecks(){
        System.out.println("Initializing Decks...");
        playerDeck = new Deck<PlayerCard>();
        infectionDeck = new Deck<InfectionCard>();
        playerDiscardDeck = new Deck<PlayerCard>();
        infectionDiscardDeck = new Deck<InfectionCard>();
        System.out.println("Adding cards to deck.");
        for (Location location : locations.values()) {
            PlayerCard playerCard = new PlayerCard(location);
            InfectionCard  infectionCard = new InfectionCard(location);
            playerDeck.push(playerCard);
            infectionDeck.push(infectionCard);
        }

        //Shuffling Decks
        playerDeck.shuffle();
        infectionDeck.shuffle();

        //Need to split decks and insert Epidemic cards.


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
            HashSet<String> diseaseColors = new HashSet<String>();
            while ((line = reader.readLine())!= null){
                fieldNumber=2;
                String field[] = line.split(",");
                //Using trim here to remove whitespace
                String primaryLocationName =  field[0].trim();
                String color = field[1];
                Location currentLocation = addLocationToBoard(primaryLocationName);
                currentLocation.setColor(color);
                Disease baseDisease;
                if (!diseaseColors.contains(color)){
                    System.out.println("Adding the " + color + " disease.");
                    diseases.addDisease(color,"resources/diseaseCubes/"+color+"_disease.png",24);
                    diseaseColors.add(color);
                }
                baseDisease = diseases.getDiseaseByName(color);
                currentLocation.setBaseDisease(baseDisease);


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
        String userInput;
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

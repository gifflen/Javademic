import Player.Player;
import Locations.Location;
import Disease.Disease;
import Disease.Diseases;
import Cards.Deck;
import Cards.PlayerCard;
import Cards.InfectionCard;
import Roles.*;
import ResearchStation.*;
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
    private File locationCSV = new File("src\\Locations\\Locations.csv");
    private Location defaultLocation;
    private int numPlayers;
    private int difficulty;
    final String DEFAULT_LOCATION_NAME = "Atlanta";
    final int DRAWS_PER_TURN=2;
    private int initalPlayerCards;
    private Player[] players;
    private int currentPlayer;
    private Deck<PlayerCard> playerDeck;
    private Deck<PlayerCard> playerDiscardDeck;
    private Deck<InfectionCard> infectionDeck;
    private Deck<InfectionCard> infectionDiscardDeck;
    private int infectionRate;
    private int outbreakLevel;
    private Actions actions = new Actions();
    private Diseases diseases = new Diseases();
    private ResearchStationCollection researchStations;


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
        this.initReasearchStations();
        this.initDifficulty();
        this.initDecks();
        this.initPlayers();
        this.initialDraw();
        this.initEpidemics();
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
              this.infectLocationByCard(drawn,i);
              infectionDiscardDeck.push(drawn);
          }
        }

    }
    private void infectLocationByCard(InfectionCard card,int numToInfect){
        System.out.println("Drew " + card);
              Location cardLocation = card.getLocation();
              System.out.println("Infecting "+card+ " with " + numToInfect +" disease cubes");
              Disease diseaseToInfect =diseases.getDiseaseByName(cardLocation.getColor());
              cardLocation.infect(diseaseToInfect,numToInfect);
              System.out.println("Discarding " + card);
        
    }
    
    private void initReasearchStations(){
        researchStations = new ResearchStationCollection();
        researchStations.addStation(defaultLocation);
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
        players = new Player[numPlayers];
        for (int i = 0 ; i<numPlayers;i++){
            players[i] = new Player(defaultLocation);
        }
        //Choose Roles
        //Determine Turn Order
        //Sort pawns

        currentPlayer = 0;

    }

    public void initDifficulty(){
        System.out.println("Initializing Difficulty...");
        difficulty = getIntInput("Please Select Difficulty Level\n" +
                            "1. Introductory : 4 Epidemics\n" +
                            "2. Normal : 5 Epidemics\n" +
                            "3. Heroic : 6 Epidemics",1,3);
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

    public void initialDraw(){
        int initialHandSize = 0;
        switch(players.length){
            case 2: initialHandSize=4;break;
            case 3: initialHandSize=3;break;
            case 4: initialHandSize=2;break;        
        }
        for (Player player : players){
            for (int i = 0; i <initialHandSize;i++ ){
                player.addCardToHand((PlayerCard)playerDeck.pop());
            }
            
        }
    }
    
    public void initEpidemics(){
        int numberOfPiles= 0;
        switch(difficulty){
            case 1:numberOfPiles=4;break;
            case 2:numberOfPiles=5;break;
            case 3:numberOfPiles=6;break;
        }
        
        //Split remaining PlayerCards into numberOfPiles
        //Add epidemic card to each pile
        //Shuffle Pile
        //clear PlayerDeck
        //Add each pile back into the playerCardDeck 
        
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
                    diseases.addDisease(color,"tempResources/diseaseCubes/"+color+"_disease.png",24);
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

    public Player getCurrentPlayer() {
        return players[currentPlayer];
    }
  
    public void startTurn(){
        players[currentPlayer].setRemainingActions(3);
        while (players[currentPlayer].getRemainingActions()>0){
            System.out.println("You have " + players[currentPlayer].getRemainingActions() + " remaining actions. ");
            players[currentPlayer].displayHand();
            actions.takeAction(players[currentPlayer]);
        }
        //Get next card
        PlayerCard[] drawnCards= new PlayerCard[DRAWS_PER_TURN];  
        for(int i =0; i<DRAWS_PER_TURN;i++){
            drawnCards[i] = (PlayerCard)playerDeck.pop();
        } 
        
        for (int i =0; i<DRAWS_PER_TURN;i++){
            boolean isEpidemic = false;
            //check for epidemic
            
            
            if (isEpidemic){
               playerDiscardDeck.add(drawnCards[i]);
               this.epidemic();
            }else{
               players[currentPlayer].addCardToHand(drawnCards[i]); 
            }
                
        }
        
        
        
        if (currentPlayer<players.length-1){
            currentPlayer++;
        }else{
            currentPlayer=0;
        }
        
        
        
    }
    private void iterateInfectionRate(){
        infectionRate++;
    }
    private void iterateOutbreak(){
        
    }
    private void epidemic(){
        System.out.println("EPIDEMIC!!!");
        iterateInfectionRate();
        InfectionCard drawnCard = infectionDeck.popLast();
        infectLocationByCard(drawnCard,3);
        infectionDiscardDeck.add(drawnCard);
        infectionDiscardDeck.shuffle();
        while (infectionDiscardDeck.peek()!=null){
            infectionDeck.add(infectionDiscardDeck.pop());
        }
        
        
    }
}

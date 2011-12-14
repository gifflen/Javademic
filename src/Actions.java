import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 */
public class Actions{

    public void takeAction(Player currentPlayer){
        System.out.println("Please select one of the available actions below:");
        String[] availibleActions = this.checkAvailableActions(currentPlayer);
        for (int i = 0; i<availibleActions.length;i++){
            if (availibleActions[i]!=null){
                System.out.println(i + ": " + availibleActions[i]);
            }
        }
        int choice = getIntInput("Please select one of the available actions",0,availibleActions.length);

        if (availibleActions[choice].equals("Pass")){
            System.out.println("You've Chosen to pass this turn");
        }else if (availibleActions[choice].equals("Drive")){
            drive(currentPlayer);
        }
        currentPlayer.useActionPoint();
    }

    public void drive(Player currentPlayer){
        boolean validInput = false;
        Scanner userInputScanner = new Scanner(System.in);
        String userInput;
        Location currentLocation =  currentPlayer.getCurrentLocation();
        HashMap<String,Location> connections = currentLocation.getConnections();
        System.out.println("You are currently at " + currentLocation.getLocationName());
        System.out.println("You can move to: ");


        for (Location connection: connections.values()){
            System.out.println("\t" +connection.getLocationName());
        }

        do{
            System.out.println("Please choose one of the locations above and enter the name of the location you would like to move to.");
            userInput = userInputScanner.nextLine();
            if (connections.containsKey(userInput)){
                validInput = true;
            }
        }while(!validInput);


        System.out.println("You've chosen to move to: " + userInput);
        currentPlayer.setCurrentLocation(connections.get(userInput));

    }


    private String[] checkAvailableActions(Player currentPlayer){
        String[] actionList = new String[13];
        actionList[0]= "Pass";
        actionList[1]= "Drive";
        return actionList;
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

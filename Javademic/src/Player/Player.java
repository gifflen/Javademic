package Player;
import Roles.*;
import Cards.*;

import Locations.Location;

/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 */
public class Player {
    Location currentLocation;
    int remainingActions;
    Cards.Deck<PlayerCard> hand ;

    public Player(Location currentLocation) {
        this.currentLocation = currentLocation;
        hand = new Cards.Deck<PlayerCard>();
        remainingActions = 0;
    }

    public int getRemainingActions() {
        return remainingActions;

    }

    public void setRemainingActions(int remainingActions) {
        this.remainingActions = remainingActions;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void useActionPoint(){
        remainingActions--;
    }
    
    public void addCardToHand(PlayerCard incCard){
        hand.add(incCard);
    }
    
    public void removeCardFromHand(PlayerCard card){
        hand.remove(card);
    }
    
    public PlayerCard getCardByName(String cardName){
        PlayerCard card;
        for (int i =0; i<hand.length();i++){
           card = (PlayerCard)hand.get(i); 
           if (card.getLocation().getLocationName().equalsIgnoreCase(cardName)) return card;
        }
        return null;
    }
    
    public void displayHand(){
        PlayerCard card;
        for (int i =0; i<hand.length();i++){
           card = (PlayerCard)hand.get(i); 
           Location cardsLocation = card.getLocation();
           card.displayCard();
        }
    }
    
    public void sortHand(){
        hand.sort();
    }
    

}

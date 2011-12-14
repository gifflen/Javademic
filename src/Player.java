/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 */
public class Player {
    Location currentLocation;
    int remainingActions;


    public Player(Location currentLocation) {
        this.currentLocation = currentLocation;
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

}

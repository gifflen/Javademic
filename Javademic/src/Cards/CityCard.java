package Cards;


import Location.Location;


public class CityCard extends Card {
	private Location location;

        /**
         * Constructs a CityCard
         * @param initialImageLoc
         *  The initial location of the image
         * @param initialName 
         *  The initial name of the city card
         * @param initialLocation 
         *  The initial location of the city card
         * @postcondition
         *  An CityCard has been constructed with 
         *  intialImageLoc, initialName, and initialLocation
         */
	public CityCard(String initialImageLoc, String initialName, Location initialLocation) {
		
		super(initialImageLoc, initialName);
		this.location = initialLocation;
	}
        
	/**
         * Plays this card
         */
	public void PlayCard(){
            //TODO fill in logic of what to do when this card is played		
	}
        
        /**
         * Gets the Location of this card
         * @return 
         *  The Location of this card
         */
        public Location getLocation()
        {
            return location;
        }

}

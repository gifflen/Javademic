package Cards;

import Location.Location;




public class InfectionCard extends Card {
	Location location;

	public InfectionCard(String initialImageLoc, String initialName, Location initialLocation) {
		super(initialImageLoc, initialName);
		this.location = initialLocation;
	}
        
        /**
         * Infect this cards location once
         */
	public void Infect(){
            //TODO integrate with real Location Class		
	}
	
	/**
         * Infect this cards location infection number of times
         * @param infection 
         *  The number of times to infect this cards location
         */
	public void Infect(Integer infection){
            
            // Infect this cards location infection amount of times
            for (int i = 0; i < infection; i++)
            {
                Infect();
            }		
	}
        
        public Location getLocation()
        {
            return location;
        }

}

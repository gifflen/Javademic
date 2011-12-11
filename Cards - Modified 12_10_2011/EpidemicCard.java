package Cards;

/*
 * this card will be the epidemic card drawn from the Cities deck
 */
public class EpidemicCard extends Card {

        /**
         * Construct an EpidemicCard with a image location and name 
         * @param initialImageLoc
         *  The initial location of the image
         * @param initialName 
         *  The initial name of the epidemic card
         * @postcondition
         *  An epidemicCard has been constructed with 
         *  intialImageLoc and initialName
         */
	public EpidemicCard(String initialImageLoc, String initialName) {
		super(initialImageLoc, initialName, CardType.Epidemic);
		// not sure initialName is relevant here, hmm...
		
	}
	
        /**
         * Plays this card
         */
	public void PlayCard(){
		//TODO Perhaps use this method for initialization as well as playing the card.
		
	}
}

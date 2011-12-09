package Cards;

/*
 * this card will be the epidemic card drawn from the Cities deck
 */
public class EpidemicCard extends Card {
	private final String step1;
	private final String step2;
	private final String step3;

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
		super(initialImageLoc, initialName);
                step1 = "step1 stub";
		step2 = "step2 stub";
                step3 = "step3 stub";
	}
	
        /**
         * Plays this card
         */
	public void PlayCard(){
            //TODO fill in logic of what to do when this card is played		
	}

        /**
         * Gets step 3
         * @return 
         *  step3
         */
	public String getStep3() {
		return step3;
	}

        /**
         * Gets step 2
         * @return 
         *  step2
         */
	public String getStep2() {
		return step2;
	}

        /**
         * Gets step 1
         * @return 
         *  step1
         */
	public String getStep1() {
		return step1;
	}

}

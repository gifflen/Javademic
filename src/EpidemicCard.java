/*
 * this card will be the epidemic card drawn from the Cities deck
 */
public class EpidemicCard extends Card {
	private final String step1;
	private final String step2;
	private final String step3;

	public EpidemicCard(String initialImageLoc, String initialName) {
		super(initialImageLoc, initialName);
		
	}
	
	public void PlayCard(){
		
	}

	public String getStep3() {
		return step3;
	}

	public String getStep2() {
		return step2;
	}

	public String getStep1() {
		return step1;
	}

}

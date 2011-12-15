package Cards;

/*
 * This card will be the special event card when drawn from the cities deck
 *  
 */
public class SpecialEventCard extends Card {
	
	private String cardName;
	private String description;
	private DeckType deckType;

        /**
         * Constructs a SpecialEventCard
         * @param initialImageLoc
         *  The initial location of the image
         * @param initialName 
         *  The initial name of the special event card
         * @param initialDescription 
         *  The initial description of the special event card
         * @postcondition
         *  An SpecialEventCard has been constructed with 
         *  intialImageLoc, initialName, and initialDescription
         */
	public SpecialEventCard(String initialImageLoc, String initialName, String initialDescription,
			String cardName) 
	{
		super(initialImageLoc, initialName, CardType.Special);
		this.description = initialDescription;
		this.deckType = DeckType.Player;
		this.cardName = cardName;
	}
        
        /**
         * Plays this card
         */
	public void PlayCard(){
            //TODO code play card logic		
	}
        
    /**
     * Get the description
     * @return 
     *  The description of this card
     */
    public String getDescription()
    {
        return description;
    }

}

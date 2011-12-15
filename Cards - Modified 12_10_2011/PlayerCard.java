package Cards;

import Location.Location;

public class PlayerCard extends Card 
{

	private Location city;
	private String cardText;
	private DeckType deckType;

	public PlayerCard(String initialImageLoc, String initialName, Location city, String text)
	{
        super(initialImageLoc, initialName, CardType.Player);
        this.cardText = text;
        deckType = DeckType.Player;
	}
	
	public PlayerCard(String initialImageLoc, String initialName, Location city)
	{
		super(initialImageLoc, initialName, CardType.Player);
		this.cardText = null;
		deckType = DeckType.Player;
	}
	
	public Location getCity() {
		return city;
	}

	public void setCity(Location city) {
		this.city = city;
	}

	public String getCardText() {
		return cardText;
	}

	public void setCardText(String cardText) {
		this.cardText = cardText;
	}

}

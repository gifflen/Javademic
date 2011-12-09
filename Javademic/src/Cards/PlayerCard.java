package Cards;


public class PlayerCard extends Card {
	private String role;

	public PlayerCard(String initialImageLoc, String initialName, String role){
                super(initialImageLoc, initialName);
		this.role = role;

	}

}

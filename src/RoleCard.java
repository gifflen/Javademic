/*
 * This is to create the role card.
 * Object can any of the 1 of 5 roles in the game
 */

public class RoleCard extends Card {
	private String role;

	public RoleCard(String initialImageLoc, String initialName) {
		super(initialImageLoc, initialName);
		this.setRole(getName());
	}

	private String getRole() {
		return role;
	}

	private void setRole(String role) {
		this.role = role;
	}
	public void PlayCard(){
		
	}

}

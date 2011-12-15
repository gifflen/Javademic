package Roles;

public abstract class Role 
{

	private String roleName;
	private Color color;
	private String specialAbility;
	
	public Role(String roleName, Color color, String specialAbility) {
		super();
		this.roleName = roleName;
		this.color = color;
		this.specialAbility = specialAbility;
	}
	
	public abstract void useSpecialAbility();
}

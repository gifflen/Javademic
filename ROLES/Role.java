package Roles;

/**
 * The base abstract class for roles
 * @author Jordan Rackley
 * @course CIS 112 ONLN
 */

public abstract class Role 
{

	/**
	 * Name of the assigned role
	 */
	private String roleName;
	/**
	 * The pawn color associated with the specified role
	 */
	private Color color;
	/**
	 * The name of the special ability provided by the specified role.
	 */
	private String specialAbility;
	
	/**
	 * Base constructor for the Role class
	 * @param roleName
	 * @param color
	 * @param specialAbility
	 */
	public Role(String roleName, Color color, String specialAbility) {
		super();
		this.roleName = roleName;
		this.color = color;
		this.specialAbility = specialAbility;
	}
	
	/**
	 * Abstract method for Special Ability
	 */
	public abstract void useSpecialAbility();
}

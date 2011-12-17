package Roles;

/**
 * Dispatcher class, extends the Role class
 * @author Jordan
 * @course CIS 112 ONLN
 */
public class Dispatcher extends Role
{
	
	/**
	 * Base constructor for the Dispatcher role
	 */
	public Dispatcher() {
		super("Dispatcher", Color.Purple, "MovePawn");
	}

	/* (non-Javadoc)
	 * Executes the special ability for the Dispatcher Role
	 */
	public void useSpecialAbility() 
	{
		MovePawn.Use();
	}
	

}
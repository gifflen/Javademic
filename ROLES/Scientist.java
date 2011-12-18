package Roles;

/**
 * Medic class, extends the Role class
 * @author Jordan
 * @course CIS 112 ONLN
 */
public class Scientist extends Role
{
	
	/**
	 * Base constructor for the Scientist role
	 */
	public Scientist() {
		super("Scientist", Color.White, "Discover Cure");
	}

	/* (non-Javadoc)
	 * Executes the special ability for the Scientist Role
	 */
	public void useSpecialAbility() 
	{
		DiscoverCure.Use();
	}
	

}

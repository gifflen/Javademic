package Roles;

/**
 * Resarcher class, extends the Role class
 * @author Jordan
 * @course CIS 112 ONLN
 */
public class Researcher extends Role
{
	
	/**
	 * Base constructor for the Researcher role
	 */
	public Researcher() {
		super("Researcher", Color.Yellow, "Share Knowledge");
	}

	/* (non-Javadoc)
	 * Executes the special ability for the Researcher Role
	 */
	public void useSpecialAbility() 
	{
		ShareKnowledge.Use();
	}
	

}
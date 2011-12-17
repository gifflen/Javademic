package Roles;

/**
 * Medic class, extends the Role class
 * @author Jordan
 * @course CIS 112 ONLN
 */
public class Medic extends Role
{
	
	/**
	 * Base constructor for the Medic role
	 */
	public Medic() {
		super("Medic", Color.Orange, "Treat Disease");
	}

	/* (non-Javadoc)
	 * Executes the special ability for the Medic Role
	 */
	public void useSpecialAbility() 
	{
		TreatDisease.Use();
	}
	

}

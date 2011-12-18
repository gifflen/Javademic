package Roles;

/**
 * Operations expert class, extends the Role class
 * @author Jordan
 * @course CIS 112 ONLN
 */
public class OperationsExpert extends Role
{
	
	/**
	 * Base constructor for the Operations Expert role
	 */
	public OperationsExpert() {
		super("OperationsExpert", Color.Green, "Build Research Center");
	}

	
	/* (non-Javadoc)
	 * Executes the special ability for the Operations Expert Role
	 */
	public void useSpecialAbility() 
	{
		BuildResearchCenter.Use();
	}
	

}
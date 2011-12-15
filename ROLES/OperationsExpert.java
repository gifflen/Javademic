package Roles;

public class OperationsExpert extends Role
{
	
	
	public OperationsExpert() {
		super("OperationsExpert", Color.Green, "Build Research Center");
	}

	public void useSpecialAbility() 
	{
		BuildResearchCenter.Use();
	}
	

}
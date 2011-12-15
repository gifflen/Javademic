package Roles;

public class Scientist extends Role
{
	
	
	public Scientist() {
		super("Scientist", Color.White, "Discover Cure");
	}

	public void useSpecialAbility() 
	{
		DiscoverCure.Use();
	}
	

}

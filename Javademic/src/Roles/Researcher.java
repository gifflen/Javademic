package Roles;

public class Researcher extends Role
{
	
	
	public Researcher() {
		super("Researcher", Color.Yellow, "Share Knowledge");
	}

	public void useSpecialAbility() 
	{
		ShareKnowledge.Use();
	}
	

}
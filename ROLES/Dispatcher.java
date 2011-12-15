package Roles;

public class Dispatcher extends Role
{
	
	
	public Dispatcher() {
		super("Dispatcher", Color.Purple, "MovePawn");
	}

	public void useSpecialAbility() 
	{
		MovePawn.Use();
	}
	

}
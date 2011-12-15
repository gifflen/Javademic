package Roles;

public class Medic extends Role
{
	
	
	public Medic() {
		super("Medic", Color.Orange, "Treat Disease");
	}

	public void useSpecialAbility() 
	{
		TreatDisease.Use();
	}
	

}

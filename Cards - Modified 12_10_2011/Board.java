package Cards;

public class Board 
{
	private int InfectionRate;
	
	Board(){
		InfectionRate = 0;
	}

	public int getInfectionRate() {
		return InfectionRate;
	}

	public void setInfectionRate(int infectionRate) {
		InfectionRate = infectionRate;
	}	
	
	public void IncreaseRate()
	{
		InfectionRate++;
	}
}

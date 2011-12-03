/*
 * Javademic Generic card class
 * This class will contain a generic card object
 */
public class Card {
	private String name;
	private String imageLoc;
	
	public Card(String initialImageLoc, String initialName){
		this.setName(name);
		this.setImageLoc(imageLoc); 
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getImageLoc() {
		return imageLoc;
	}

	void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}

}

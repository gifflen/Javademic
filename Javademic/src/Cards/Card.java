package Cards;

/*
 * Javademic Generic card class
 * This class will contain a generic card object
 */
public class Card {
	private String name;
	private String imageLoc;
	
        /**
         * Card Constructor 
         * @param initialImageLoc
         *  The initial location of the image
         * @param initialName 
         *  The initial name of the card
         */
	public Card(String initialImageLoc, String initialName){
            name = initialName;
            imageLoc = initialImageLoc;
	}

        /**
         * Get the cards name
         * @return 
         *  The name of the card
         */
	public String getName() {
		return name;
	}

        /**
         * Set the cards name
         * @param name 
         *  The name to set the card to
         * @postconidtion
         *  The cards name is what's in the param name
         */
	void setName(String name) {
		this.name = name;
	}

        /**
         * Get the image location
         * @return 
         *  The image location
         */
	public String getImageLoc() {
		return imageLoc;
	}

        /**
         * Set the imageLoc
         * @param imageLoc 
         *  The string to set image location to
         * @postcondition
         *  The imageLoc has been set to the parameter imageLoc
         */
	void setImageLoc(String imageLoc) {
		this.imageLoc = imageLoc;
	}

}

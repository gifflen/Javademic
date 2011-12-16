package UnitTests;

import Cards.*;/*

package UnitTests;

/**
 *
 * @author maxknee1
 */
public class CardUnitTest {
    
    public static void main (String[] args){
        Card testCard1 = new Card("null", "Special", CardType.Epidemic);
        Card testCard2 = new Card("null", "Disease", CardType.Infection);
        Card testCard3 = new Card("null", "Scientist", CardType.Player);
        System.out.print("### BEGIN CARDS UNIT TEST ###\n");
        testCardType(testCard1);
        testCardType(testCard2);
        testCardType(testCard3);
        
        testCardName(testCard1);
        testCardName(testCard2);
        testCardName(testCard3);
    }
    private static void testCardType(Card card){
        String current = null;
        CardType type = CardType.valueOf(current.toUpperCase());
        switch (type){
            case Epidemic: System.out.print("Epidemic Card"); break;
            case Infection: System.out.print("Infection Card"); break;
            case Player: System.out.print("Player Card"); break;    
                
        }
    }
    
    private static void isDiscardedTest(Card card){
        if (card.isDiscard() == true){
            System.out.println("Card is discarded");
        }
        else {System.out.print("Card is not discarded");}
    }
    
    private static void testCardName(Card card){
        System.out.println(card.getName());
    }
}

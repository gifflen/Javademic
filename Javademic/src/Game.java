/**
 * Created by IntelliJ IDEA.
 * User: Gifflen
 */
public class Game {
    public static void main(String[] args) {
        //Initing Game Board
        Board gameBoard = new Board();
        while (!gameBoard.isGameLost()&& !gameBoard.isGameWon()) {
            gameBoard.startTurn();
        }
        if (gameBoard.isGameLost()){
            System.out.println("You have lost the game =(");
        }else{
            System.out.println("You have won the game!!!");
        }
            
        System.out.println("Thanks for Playing!");

    }
}

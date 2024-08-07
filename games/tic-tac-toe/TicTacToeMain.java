import contollers.GameController;
import models.*;
import strategies.gamewinningstrategy.ColWinningStrategy;
import strategies.gamewinningstrategy.DiagonalWinnigStategy;
import strategies.gamewinningstrategy.RowWinningStrategy;
import strategies.gamewinningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeMain {

    public static void main(String args[]){

        System.out.println("GAME START");

        Scanner scanner = new Scanner(System.in);

        GameController gameController = new GameController();

        /// Take dimension as input
        int dimension = scanner.nextInt();

        /// take player as input
        List<Player> players = new ArrayList<>();
        players.add(new Player(new Symbol('X'),
                "Shriyash",
                PlayerType.HUMAN)
        );

        players.add(new Player(new Symbol('O'),"EVA^",PlayerType.BOT));

        /// take strategies as input
        List<WinningStrategy> strategies = List.of(
                new RowWinningStrategy(),
                new ColWinningStrategy(),
                new DiagonalWinnigStategy()
        );

        Game game = gameController.startGame(dimension,players,strategies);

        //gameController.printBoard(game);

        //lets start playing the game

        while(gameController.checkGameState(game).equals(GameState.IN_PROGRESS)){

            // 1. show the board.
            // 2. make a move.

            gameController.printBoard(game);

            System.out.println("Do you want to undo ? yes/no");
            String isUndo = scanner.next();
            if(isUndo.equalsIgnoreCase("yes")){
                gameController.undoMove(game);
            }

        }

        /// Build the Game


        System.out.println("END GAME");
    }
}

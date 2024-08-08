package contollers;

import exception.InvalidMoveException;
import models.Game;
import models.GameState;
import models.Player;
import strategies.gamewinningstrategy.WinningStrategy;

import java.util.List;

public class GameController {

    /// make move

    public void makeMove(Game game)  {
        try {
            game.makeMove();
        } catch (InvalidMoveException e) {
            throw new RuntimeException(e);
        }
    }

    //undo
    public void undoMove(Game game){
        game.undoMove();
    }


    ///check winner
    public Player getWinner(Game game){
        return game.getWinner();
    }

    public GameState getGameState(Game game){
        return game.getGameState();
    }

    ///game state
    public GameState checkGameState(Game game){
        return game.getGameState();
    }

    /// print board
    public void printBoard(Game game){
        game.printBoard();
    }

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> strategies){
        return Game.builder()
                .setDimensions(dimension)
                .setPlayers(players)
                .setWinningStrategies(strategies)
                .build();
    }

}

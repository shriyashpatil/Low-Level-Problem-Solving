package strategies.gamewinningstrategy;

import models.Board;
import models.Cell;
import models.Move;
import models.Player;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);

}

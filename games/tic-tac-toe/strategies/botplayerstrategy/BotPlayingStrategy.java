package strategies.botplayerstrategy;

import models.Board;
import models.Move;
import models.Player;

public interface BotPlayingStrategy {

        Move makeMove(Board board);

}

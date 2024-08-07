package strategies.gamewinningstrategy;

import models.Board;
import models.Move;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements WinningStrategy{
    private final Map<Integer, HashMap<Character,Integer>> colMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int col = move.getCell().getCol();
        Character ch = move.getPlayer().getSymbol().getSymbol();

        if(!colMaps.containsKey(col)){
            colMaps.put(col,new HashMap<>());
        }

        if(!colMaps.get(col).containsKey(ch)){
            colMaps.get(col).put(ch,1);
        }else{
            colMaps.get(col).put(ch,colMaps.get(col).get(ch)+1);
        }

        return colMaps.get(col).get(ch) == 3;

    }
}

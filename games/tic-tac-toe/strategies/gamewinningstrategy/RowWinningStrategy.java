package strategies.gamewinningstrategy;

import models.Board;
import models.Cell;
import models.Move;
import models.Player;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements  WinningStrategy{

    private final Map<Integer, HashMap<Character,Integer>> rowMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {

        int row = move.getCell().getRow();
        Character ch = move.getPlayer().getSymbol().getSymbol();

        if(!rowMaps.containsKey(row)){
            rowMaps.put(row,new HashMap<>());
        }

        if(!rowMaps.get(row).containsKey(ch)){
            rowMaps.get(row).put(ch,1);
        }else{
            rowMaps.get(row).put(ch,rowMaps.get(row).get(ch)+1);
        }

        return rowMaps.get(row).get(ch) == 3;

    }
}

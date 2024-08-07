package strategies.gamewinningstrategy;

import models.Board;
import models.Cell;
import models.Move;

import java.util.HashMap;

public class DiagonalWinnigStategy implements WinningStrategy{

    private final HashMap<String, HashMap<Character,Integer>> daiMaps = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        if(!checkDiagonalCell(board.getDimension(), move.getCell())) return false;
        String dai = String.valueOf(move.getCell().getRow())+String.valueOf(move.getCell().getCol());
        Character ch = move.getPlayer().getSymbol().getSymbol();
        if(!daiMaps.containsKey(dai)){
            daiMaps.put(dai,new HashMap<>());
        }

        if(!daiMaps.get(dai).containsKey(ch)){
            daiMaps.get(dai).put(ch,1);
        }else{
            daiMaps.get(dai).put(ch,daiMaps.get(dai).get(ch)+1);
        }

        return daiMaps.get(dai).get(ch) == 3;
    }

    public boolean checkDiagonalCell(int dimension, Cell cell){
        if(dimension%2!=0) return cell.getCol()==cell.getCol();
        return cell.getCol()== cell.getRow() || cell.getCol()+ cell.getRow()+1==dimension;
    }
}

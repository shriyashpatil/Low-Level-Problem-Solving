package strategies.botplayerstrategy;

import models.*;

import java.util.List;

public class EasyBoatPlayingStrategy implements BotPlayingStrategy{

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> list : board.getBoard()){
            for(Cell cell : list){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(new Cell(cell.getRow(), cell.getCol(),CellState.EMPTY),null);
                }
            }
        }
        return null;
    }
    
}

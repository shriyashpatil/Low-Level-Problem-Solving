package models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int dimension;
    private List<List<Cell>> board;

    public Board(int dimension){
        this.dimension = dimension;
        this.board = new ArrayList<>();
        for(int itr=0; itr<dimension; itr++){
            board.add(new ArrayList<>());
            for(int jtr=0; jtr<dimension; jtr++){
                board.get(itr).add(new Cell(itr,jtr,CellState.EMPTY));
            }
        }
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}

package models;

import java.util.Scanner;

public class Player {

    private Symbol symbol;
    private String name;

    private Scanner scanner;
    private PlayerType playerType;

    public Player(Symbol symbol, String name, PlayerType playerType) {
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
        this.scanner = new Scanner(System.in);
    }


    public Symbol getSymbol() {
        return symbol;
    }
    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public PlayerType getPlayerType() {
        return playerType;
    }
    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        //// take rw, col in the  intput from the player
        System.out.println("Please enter the row number where you want to make  a move");
        int row = scanner.nextInt();
        System.out.println("Please enter the col number where you want to make  a move");
        int col = scanner.nextInt();
        return new Move(new Cell(row,col,CellState.EMPTY),this);
    }
    
    
}

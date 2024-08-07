package models;

import strategies.gamewinningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game{

    private Board board;
    private List<Player> players;

    private List<Move> moves;

    private Player winner;

    private GameState gameState;

    private int nextMovePlayerIndex;

    private List<WinningStrategy> winningStrategies;

    private Game(int dimension,List<Player> players, List<WinningStrategy> winningStrategies){

        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextMovePlayerIndex = 0;
        this.winningStrategies = winningStrategies;

    }


    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextMovePlayerIndex() {
        return nextMovePlayerIndex;
    }

    public void setNextMovePlayerIndex(int nextMovePlayerIndex) {
        this.nextMovePlayerIndex = nextMovePlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public void printBoard(){
        this.board.printBoard();
    }

    public static Builder builder(){
        return new Builder();
    }


    public static class Builder{
        private int dimensions;
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;

        private Builder() {
            this.dimensions = 0;
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
        }

        public Builder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Game build(){
            /// validations
            validations();
            return new Game(dimensions,players,winningStrategies);
        }

        private void validations() {

            if (dimensions <= 0) {
                throw new RuntimeException("Dimensions can't be negative");
            }
            validatePlayersAndDimension();
            validateUniqueSymbol();
            validateBotCount();
        }

        /// because there should be only one bot available in the game
        private void validateBotCount(){
            int count =0;
            for(Player player:players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    count++;
                    if(count>1) throw new RuntimeException("Only Single Bot Allowed");
                }
            }
        }

        private void validateUniqueSymbol(){
            Set<Character> symbolSet = new HashSet<>();
            for(Player player:players){
                symbolSet.add(player.getSymbol().getSymbol());
            }

            if(symbolSet.size()!= dimensions-1){
                throw new RuntimeException("Every player should have unique symbol");
            }
        }

        /// validate players and dimension
        private void validatePlayersAndDimension(){
            if(dimensions-1!=players.size()){
                throw new RuntimeException("Players are not as per the dimension of the game");
            }
        }

    }

}
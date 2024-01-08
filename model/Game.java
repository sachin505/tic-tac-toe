package model;

import model.types.GameState;
import model.types.PlayerType;
import strategy.GameWinningRule;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players;
    Board board;
    GameState gameState;
    List<Move> moves;
    int nextPlayerTurn;
    List<GameWinningRule> gameWinningRules;
    Player winnerPlayer;

    private Game(int dimensions,List<Player> players,List<GameWinningRule> gameWinningRules){
        this.players=players;
        this.board=new Board(dimensions);
        this.gameWinningRules=gameWinningRules;
        this.nextPlayerTurn=0;
        this.winnerPlayer=null;
        this.moves=new ArrayList<>();
        this.gameState=GameState.IN_PROGRESS;
    }

    public void printBoard(){
        List<List<Cell>> gameBoard =this.getBoard().board;
        for(int i=0;i<gameBoard.size();i++){
            for(int j=0;j<gameBoard.size();j++){
                if(gameBoard.get(i).get(j).getPlayer()==null) {
                    System.out.print("| - |");
                }
                else{
                    System.out.print("| "+gameBoard.get(i).get(j).getPlayer().getSymbol().symbol+" |");
                }
            }
            System.out.println();
        }
    }

    public void makeMove(){
        Player player=this.players.get(this.nextPlayerTurn);
            try {
                Move move = player.makeMove(this.getBoard());
                this.moves.add(move);
                checkForWinnwer(this.getBoard(),move);
                checkForDraw();
                this.nextPlayerTurn++;
                this.nextPlayerTurn%= this.players.size();
                System.out.println(this.players.get(nextPlayerTurn).getName()+" is playing");
            }
            catch (Exception e) {
               e.printStackTrace();
            }
    }
    public void checkForWinnwer(Board board,Move move){
        for(GameWinningRule gameWinningRule:this.gameWinningRules) {
            if (gameWinningRule.CheckForWinner(board, move)) {
                this.winnerPlayer=move.getPlayer();
                this.gameState = GameState.END;
            }
        }
    }

    public void checkForDraw(){
//        System.out.println("checking for draw");
        if(this.moves.size()==this.board.getSize()-1){
            this.gameState=GameState.DRAW;
        }
    }


    public static GameBuilder getGameBuilder(){
        return new GameBuilder();
    }


    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public GameState getGameState() {
        return gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public int getNextPlayerTurn() {
        return nextPlayerTurn;
    }

    public List<GameWinningRule> getGameWinningRules() {
        return gameWinningRules;
    }

    public Player getWinnerPlayer() {
        return winnerPlayer;
    }

    public static class GameBuilder {
        List<Player> players;
        List<GameWinningRule> gameWinningRules;
        int dimensions;

        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public GameBuilder setDimensions(int dimensions) {
            this.dimensions = dimensions;
            return this;
        }

        public GameBuilder setGameWinningRules(List<GameWinningRule> gameWinningRules) {
            this.gameWinningRules = gameWinningRules;
            return this;
        }

        public boolean validateInputs(){
            int botCount=0;
            for (Player player : this.players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }
            if(botCount>=this.dimensions-1){
                return false;
            }
            if(players.size()>=this.dimensions-1){
                return false;
            }
            return true;
        }

        public Game build(){
            validateInputs();
            return new Game(this.dimensions,this.players,this.gameWinningRules);
        }
    }

}

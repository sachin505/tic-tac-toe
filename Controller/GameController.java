package Controller;

import model.Game;
import model.Player;
import strategy.GameWinningRule;

import java.util.List;

public class GameController {

    public Game startGame(List<Player> players, List<GameWinningRule> gameWinningRules,int dimensions) {
        return Game.getGameBuilder().setPlayers(players).setDimensions(dimensions).setGameWinningRules(gameWinningRules).build();
    }
    public void printBoard(Game game){
        game.printBoard();
    }
    public void makeMove(Game game){
          game.makeMove();
    }

    public Player getWinner(Game game){
        return game.getWinnerPlayer();
    }
}

import Controller.GameController;
import model.Game;
import model.Player;
import model.Symbol;
import model.types.GameState;
import model.types.PlayerType;
import strategy.ColumnWinningRule;
import strategy.GameWinningRule;
import strategy.RowWinningRule;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args){
        GameController gc=new GameController();
        List<Player> players=new ArrayList<>();
        players.add(new Player("sairam",new Symbol('O'),PlayerType.HUMAN));
        players.add(new Player("sachin",new Symbol('X'), PlayerType.HUMAN));
        List<GameWinningRule> gameWinningRules=new ArrayList<>();
        gameWinningRules.add(new ColumnWinningRule());
        gameWinningRules.add(new RowWinningRule());
        Game game = gc.startGame(players,gameWinningRules,3);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            gc.printBoard(game);
            gc.makeMove(game);
        }
        if(game.getGameState().equals(GameState.END)){
            System.out.println(gc.getWinner(game).getName()+" won");
            return;
        }
        if(game.getGameState().equals(GameState.DRAW)){
            System.out.println("the game is a draw");
            return;
        }
    }
}

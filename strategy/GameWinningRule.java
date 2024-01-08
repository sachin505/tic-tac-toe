package strategy;

import model.Board;
import model.Move;
import model.Player;

public interface GameWinningRule {
    boolean CheckForWinner(Board borad, Move move);
}

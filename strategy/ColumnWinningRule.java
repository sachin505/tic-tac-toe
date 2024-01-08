package strategy;

import model.Board;
import model.Move;
import model.Player;
import model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningRule implements GameWinningRule{
    Map<Integer,Map<Character,Integer>> columnMap;
    public ColumnWinningRule(){
        columnMap=new HashMap<>();
    }
    @Override
    public boolean CheckForWinner(Board borad, Move move) {
        int col=move.getCell().getCol();
        Integer count=0;
        if(columnMap.containsKey(col)){
            Map<Character,Integer> map =columnMap.get(col);
            if(!map.containsKey('X')){
                map.put('X',0);
            }
            if(!map.containsKey('O')){
                map.put('O',0);
            }
            Character ch=move.getPlayer().getSymbol().getSymbol();
            count=map.get(ch);
            count=count+1;
            map.put(ch, count);
        }
        else{
            columnMap.put(col,new HashMap<Character,Integer>());
            Map<Character,Integer> map =columnMap.get(col);
            map.put(move.getPlayer().getSymbol().getSymbol(), 1);
        }
        return count == borad.getColRowSize();
    }
}

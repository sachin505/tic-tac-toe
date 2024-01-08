package strategy;

import model.Board;
import model.Move;
import model.Player;
import model.Symbol;

import java.util.HashMap;
import java.util.Map;

public class RowWinningRule implements GameWinningRule{
    Map<Integer,Map<Character,Integer>> rowMap;
    public RowWinningRule(){
        rowMap=new HashMap<>();
    }
    @Override
    public boolean CheckForWinner(Board borad, Move move) {
        int row=move.getCell().getRow();
        Integer count=0;
        if(rowMap.containsKey(row)){
            Map<Character,Integer> map = rowMap.get(row);
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
            rowMap.put(row,new HashMap<Character,Integer>());
            Map<Character,Integer> map =rowMap.get(row);
            map.put(move.getPlayer().getSymbol().getSymbol(), 1);
        }
        return count == borad.getColRowSize();
    }
}

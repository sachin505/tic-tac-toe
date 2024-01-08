package model;

import model.types.CellState;
import model.types.PlayerType;

import java.util.Scanner;

public class Player {
    String name;
    Symbol symbol;
    PlayerType playerType;

    public Player(String name,Symbol symbol,PlayerType playerType){
        this.name=name;
        this.symbol=symbol;
        this.playerType=playerType;
    }

    public Move makeMove(Board board) throws Exception {
        int row=0;
        int col=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the row number ");
        row=sc.nextInt();
        System.out.println("enter the column number ");
        col=sc.nextInt();

        if(!validateMove(board,row,col)){
            throw new Exception();
        }

        Cell cell=board.getBoard().get(row).get(col);
        cell.setPlayer(this);
        cell.setCellState(CellState.FILLED);

        return new Move(cell,this);
    }
    public boolean validateMove(Board board,int row,int col){
        int boardSize=board.getBoard().size();
        if(row >=boardSize || col>=boardSize || row<0 || col<0){
            return false;
        }
        Cell cell=board.getBoard().get(row).get(col);
        if(cell.getCellState().equals(CellState.FILLED)){
            System.out.println("inside the if condition");
            return false;
        }
        return true;
    }
    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }
}

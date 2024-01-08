package model;

import model.types.CellState;

public class Cell {
    Player player;
    int row;
    int col;
    CellState cellState;

    public Cell(Player player,int row,int col){
        this.player=player;
        this.row=row;
        this.col=col;
        this.cellState=CellState.EMPTY;
    }

    public Player getPlayer() {
        return player;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }
}

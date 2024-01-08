package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    List<List<Cell>> board;

    public int getColRowSize() {
        return colRowSize;
    }

    int size;
    int colRowSize=0;

    public Board(int dimensions){
        colRowSize = dimensions;
        this.size = dimensions*dimensions;
        board=new ArrayList<>();
        for(int i=0;i<dimensions;i++){
            List<Cell> row=new ArrayList<>();
            for(int j=0;j<dimensions;j++) {
                row.add(new Cell(null,i,j));
            }
            board.add(row);
        }
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public int getSize() {
        return size;
    }
}

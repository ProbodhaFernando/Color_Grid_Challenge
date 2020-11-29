package model;

import java.util.LinkedList;

public class ColorGrid {
    private int numRows;
    private int numCols;
    private LinkedList<ColorNode> grid;

    public ColorGrid(int numRows, int numCols, LinkedList<ColorNode> grid) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.grid = grid;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public LinkedList<ColorNode> getGrid() {
        return grid;
    }

    public void setGrid(LinkedList<ColorNode> grid) {
        this.grid = grid;
    }
}

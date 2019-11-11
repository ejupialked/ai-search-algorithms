package Puzzle;

import java.awt.*;

/**
 * Basic representation of a single cell
 * defining its positions (X, y) and its {@code CellType}
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 *
 */
public class Cell extends Point{


    private String symbol;
    private CellType cellType;


    /**
     * Enum class for representing
     * the cell type.
     */
    public enum CellType {
        A("A"),
        B("B"),
        C("C"),
        AGENT("@"),
        EMPTY("x");

        private  String text;

        CellType(String text) {
            this.text = text;
        }
        public String getText() {
            return this.text;
        }
    }


    public Cell(int x, int y, CellType cellType){
        super(x, y);
        this.cellType = cellType;
    }

    public CellType getCellType() {
        return cellType;
    }

    public Point getPoint() {
        return super.getLocation();
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

}




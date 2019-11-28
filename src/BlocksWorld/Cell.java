package BlocksWorld;

import java.awt.*;

/**
 * Basic representation of a single cell
 * defining its positions (X, y) and its {@code CellType}
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 *
 */
public class Cell extends Point implements ManhattanDistance {

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
        EMPTY("-");

        private  String text;

        CellType(String text) {
            this.text = text;
        }
        public String getText() {
            return this.text;
        }
    }

    /**
     * Calculates Manhattan Distance between two cells
     * @param c the cell to calculate the distance
     * @return the manhattan distance
     */
    @Override
    public int manhattanDistance(Cell c) {
        return Math.abs(this.x - c.x) + Math.abs(this.y - c.y);
    }


    public Cell(Point point, CellType cellType){
        super(point);
        this.cellType = cellType;
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




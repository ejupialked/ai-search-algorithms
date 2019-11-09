package Game;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * Basic representation of a single cell
 * defining its positions (X, y) and its {@code CellType}
 */
public class Cell extends Point{

    /* Constants */
    private static String A = "A";
    private static String B = "B";
    private static String C = "C";
    private static String O = "O";
    private static String X = "x";

    /* Types of a cell */
    enum CellType {A, B, C, O, x}

    private CellType cellType;

    public Cell(int x, int y){
        super(x, y);

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


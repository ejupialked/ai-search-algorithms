package Game;

import java.awt.*;

/**
 * Basic representation of a single cell
 * defining its positions (X, y) and its {@code CellType}
 */
public class Cell extends Point{


    /**
     * Enum class for representing
     * the cell type.
     */
    public enum CellType {
        A("A"),
        B("B"),
        C("C"),
        AGENT("a"),
        EMPTY("x");

        private  String text;

        CellType(String text) {
            this.text = text;
        }
        public String getText() {
            return this.text;
        }
    }

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




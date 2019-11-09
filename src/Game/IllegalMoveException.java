package Game;

import java.awt.*;

public class IllegalMoveException extends Exception {

    private Actions.AgentMoves a;
    private Point p;

    private String detailMessage;



    IllegalMoveException(Actions.AgentMoves a, Point p){
        super();
        this.a = a;
        this.p = p;
    }



    @Override
    public String getMessage() {




        return super.getMessage();
    }


}

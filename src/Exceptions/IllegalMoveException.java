package Exceptions;

import Game.Actions;

import java.awt.*;

public class IllegalMoveException extends Exception {

    private Actions.AgentMoves a;
    private Point p;

    private String detailMessage;



    public IllegalMoveException(Actions.AgentMoves a, Point p){
        super();
        this.a = a;
        this.p = p;
    }



    @Override
    public String getMessage() {




        return super.getMessage();
    }


}

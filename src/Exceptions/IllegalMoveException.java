package Exceptions;

import Game.Actions;

import java.awt.*;

public class IllegalMoveException extends Exception {

    private Actions.AgentMove a;
    private Point p;

    private String detailMessage;



    public IllegalMoveException(Actions.AgentMove a, Point p){
        super();
        this.a = a;
        this.p = p;
    }



    @Override
    public String getMessage() {
        return super.getMessage();
    }


}

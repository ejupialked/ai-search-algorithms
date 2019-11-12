package Exceptions;

import Puzzle.TransitionModel;
import java.awt.*;

/**
 * Exception for an illegal move of the agent.
 */
public class IllegalMoveException extends Exception {

    private TransitionModel.Action a;
    private Point p;

    public IllegalMoveException(TransitionModel.Action a, Point p){
        super();
        this.a = a;
        this.p = p;
    }


    @Override
    public String getMessage() {
        return "["+a+"]"+" is an illegal move. Point ("+ p.x +", "+ p.y + ");";
    }
}

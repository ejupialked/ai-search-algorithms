package Exceptions;

import Puzzle.Actions;
import java.awt.*;

/**
 * Exception for an illegal move of the agent.
 */
public class IllegalMoveException extends Exception {

    private Actions.AgentMove a;
    private Point p;

    public IllegalMoveException(Actions.AgentMove a, Point p){
        super();
        this.a = a;
        this.p = p;
    }


    @Override
    public String getMessage() {
        return "["+a+"]"+" is an illegal move. Point ("+ p.x +", "+ p.y + ");";
    }
}

package Exceptions;

import Problem.TransitionModel.Action;
import java.awt.*;

/**
 * Exception for an illegal move of the agent.
 */
public class IllegalMoveException extends Exception {

    private Action a;

    public IllegalMoveException(Action a){
        super();
        this.a = a;
    }

    @Override
    public String getMessage() {
        return "["+a+"]"+" is an illegal move.";
    }
}

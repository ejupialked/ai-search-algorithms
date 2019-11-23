package Problem;

import Exceptions.IllegalMoveException;
import BlocksWorld.Board;
import BlocksWorld.Cell;
import java.awt.Point;

/**
 * Represents all possible actions
 * that can be taken in puzzle game
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public class TransitionModel {

    /* Enum class for agent moves */
    public enum Action {UP, DOWN, LEFT, RIGHT}


    public void performTransitionCells(Action move, State state) throws IllegalMoveException {
        Board board = state.getBoard();
        Cell destination = null;

        switch (move){
            case UP:   destination = up(board); break;
            case DOWN: destination = down(board); break;
            case LEFT: destination = left(board); break;
            case RIGHT:destination = right(board); break;
        }

        if(destination == null){
            throw new IllegalMoveException(move);
        }else{
            moveAgent(board, destination);
            state.setActionTaken(move);

            //update configuration
            board.computeConfiguration();
        }
    }

    private void moveAgent(Board board, Cell destination){

        Cell[][] cells = board.getGridCells();
        Point agent = board.getAgent().getPoint();

        Point tempAgent = new Point(((int) agent.getX()), ((int) agent.getY()));
        Point tempDestination = new Point(((int) destination.getX()), ((int) destination.getY()));

        Cell temp = cells[agent.x][agent.y];
        cells[agent.x][agent.y] = cells[destination.x][destination.y];
        cells[agent.x][agent.y].setLocation(tempAgent);

        cells[tempDestination.x][tempDestination.y] = temp;
        cells[tempDestination.x][tempDestination.y].setLocation(tempDestination);

    }

    private Cell left(Board board) {
        Cell agent = board.getAgent(); // remember to reset
        int newY = (int) (agent.getY() - 1);
        Point left = new Point(agent.x, newY);

        Cell destination;

        try {
            destination = board.getGridCells()[left.x][left.y];
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }

        return destination;

    }

    private Cell right(Board board) {
        Cell agent = board.getAgent(); // remember to reset
        int newY = (int) (agent.getY() + 1);
        Point right = new Point(agent.x, newY);
        Cell destination;
        try {
            destination = board.getGridCells()[right.x][right.y];
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
        return destination;
    }

    private Cell down(Board board) {
        Cell agent = board.getAgent(); // remember to reset
        int newX = (int) (agent.getX() + 1);
        Point down = new Point(newX, agent.y);
        Cell destination;
        try {
            destination = board.getGridCells()[down.x][down.y];
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }
        return destination;
    }

    private Cell up(Board board){
        Cell agent = board.getAgent(); // remember to reset
        int newX = (int) (agent.getX() - 1);
        Point up = new Point(newX, agent.y);
        Cell destination;

        try {
            destination = board.getGridCells()[up.x][up.y];
        }catch (ArrayIndexOutOfBoundsException e){
            return null;
        }

        return destination;
    }
}

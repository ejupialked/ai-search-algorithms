package Puzzle;

import Exceptions.IllegalMoveException;
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

    /**
     * Moves the agent based on {@link Action}
     * on the {@link Board}.
     *
     * @param move the type of move of the agent
     * @param b the {@link Board}
     * @throws  IllegalMoveException if move cannot be done
     */
    public void moveAgent(Action move, Board b) throws IllegalMoveException {
        Cell agent = b.getAgent();

        switch (move){
            case UP:    up(b, agent);    break;
            case DOWN:  down(b, agent);  break;
            case LEFT:  left(b, agent);  break;
            case RIGHT: right(b, agent); break;
        }

        b.updateGrid();
        b.updateBoard();

    }

    /**
     * Agent moves up
     *
     * @param board the board
     * @param agent the agent of the {@code board}
     * @throws IllegalMoveException if {@code agent} cannot go up
     */
    private void up(Board board, Cell agent) throws IllegalMoveException {
        int newX = (int) (agent.getX() - 1);
        Point up = new Point(newX, agent.y);

        if(up.x < 0) {
            throw new IllegalMoveException(Action.UP, up);
        }else{
            moveAgent(board, up);
        }
    }


    /**
     * Agent moves down
     *
     * @param board the board
     * @param agent the agent of the {@code board}
     * @throws IllegalMoveException if {@code agent} cannot go down
     */
    private void down(Board board, Cell agent) throws IllegalMoveException {
        int newX = (int) (agent.getX() + 1);
        Point down = new Point(newX, agent.y);

        if(down.x >= board.getN()) {
            throw new IllegalMoveException(Action.DOWN, down);
        }else{
            moveAgent(board, down);
        }
    }

    /**
     * Agent moves left
     *
     * @param board the board
     * @param agent the agent of the {@code board}
     * @throws IllegalMoveException if {@code agent} cannot go left
     */
    private void left(Board board, Cell agent) throws IllegalMoveException {
        int newY = (int) (agent.getY() - 1);
        Point left = new Point(agent.x, newY);

        if(left.y < 0) {
            throw new IllegalMoveException(Action.LEFT, left);
        }else{
            moveAgent(board, left);
        }
    }

    /**
     * Agent moves right
     *
     * @param board the board
     * @param agent the agent of the {@code board}
     * @throws IllegalMoveException if {@code agent} cannot go right
     */
    private void right(Board board, Cell agent) throws IllegalMoveException {
        int newY = (int) (agent.getY() + 1);

        Point right = new Point(agent.x, newY);

        if(right.y >= board.getN()) {
            throw new IllegalMoveException(Action.RIGHT, right);
        }else{
            moveAgent(board, right);
        }
    }

    /**
     * Move the agent in a specific point
     * @param board the board
     * @param p future cell of the agent
     */
    private void moveAgent(Board board, Point p){
        Cell cellToSwap = board.getCells()[p.x][p.y];
        Point agent = board.getAgent().getPoint();

        swapCell(board, agent, cellToSwap.getPoint());

        // reset the location of tiles
        switch (cellToSwap.getCellType()){
            case A: board.setALocation(agent); break;
            case B: board.setBLocation(agent); break;
            case C: board.setCLocation(agent); break;
        }
    }

    /**
     * Swap two given point in the board
     * @param board the board
     * @param a point a
     * @param b point b
     */
    private void swapCell(Board board, Point a, Point b){
        Cell[][] cells = board.getCells();

        Cell c1  = cells[b.x][b.y];
        Cell c2 = cells[a.x][a.y];

        cells[b.x][b.y] = c2;
        cells[a.x][a.y] = c1;
        c2.setLocation(b);
        c1.setLocation(a);
    }
}

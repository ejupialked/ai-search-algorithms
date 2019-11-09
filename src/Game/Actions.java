package Game;

import Exceptions.IllegalMoveException;
import java.awt.Point;


/**
 * Represents all possible actions
 * that can be taken in puzzle game
 */
public class Actions {

    /* Enum class for agent moves */
    public enum AgentMoves {UP, DOWN, LEFT, RIGHT}


    /**
     *
     * @param move the type of move of the agent
     * @param b the {@link Board}
     * @throws  IllegalMoveException if move cannot be done
     */
    public void moveAgent(AgentMoves move, Board b) throws IllegalMoveException {
        Cell agent = b.getAgent();

        switch (move){
            case UP:    up(b, agent);    break;
            case DOWN:  down(b, agent);  break;
            case LEFT:  left(b, agent);  break;
            case RIGHT: right(b, agent); break;
        }
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
            throw new IllegalMoveException(AgentMoves.UP, up);
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
            throw new IllegalMoveException(AgentMoves.DOWN, down);
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
            throw new IllegalMoveException(AgentMoves.LEFT, left);
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
            throw new IllegalMoveException(AgentMoves.RIGHT, right);
        }else{
            moveAgent(board, right);
        }
    }


    /**
     * Move the agent in a specific point
     * @param b the board
     * @param p future cell of the agent
     */
    private void moveAgent(Board b, Point p){
        Cell cellToSwap = b.getCells()[p.x][p.y];
        Point agent = b.getAgent().getPoint();
        switch (cellToSwap.getCellType()){
            case A:
                swapCell(b, agent, cellToSwap);
                b.setA(b.getAgent());
                break;
            case B:
                swapCell(b, agent, cellToSwap);
                b.setB(b.getAgent());
                break;
            case C:
                swapCell(b, agent, cellToSwap);
                b.setC(b.getAgent());
                break;
            case EMPTY:
                swapCell(b, agent, cellToSwap);
                break;
        }

        b.setAgent(cellToSwap);
    }

    /**
     * Swap two given point in the board
     * @param board the board
     * @param a point a
     * @param b point b
     */
    private void swapCell(Board board, Point a, Point b){
        Cell[][] cells = board.getCells();
        Cell temp = cells[b.x][b.y];
        cells[b.x][b.y] =  cells[a.x][a.y];
        board.setAgent(cells[b.x][b.y]);
        cells[a.x][a.y] = temp;

    }
}

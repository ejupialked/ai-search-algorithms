package Game;

import Exceptions.IllegalMoveException;

import java.awt.Point;


/**
 * Represents all possible actions
 * that can be taken in puzzle game
 */
public class Actions {

    /* Enum class for agent moves */
    public enum AgentMove {UP, DOWN, LEFT, RIGHT}

    /**
     *
     * @param move the type of move of the agent
     * @param b the {@link Board}
     * @throws  IllegalMoveException if move cannot be done
     */
    public void moveAgent(AgentMove move, Board b) throws IllegalMoveException {
        Cell agent = b.getAgent();

        switch (move){
            case UP:    up(b, agent);    break;
            case DOWN:  down(b, agent);  break;
            case LEFT:  left(b, agent);  break;
            case RIGHT: right(b, agent); break;
        }

        b.updateBoard();
        b.updateGrid();
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
            throw new IllegalMoveException(AgentMove.UP, up);
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
            throw new IllegalMoveException(AgentMove.DOWN, down);
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
            throw new IllegalMoveException(AgentMove.LEFT, left);
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
            throw new IllegalMoveException(AgentMove.RIGHT, right);
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

        switch (cellToSwap.getCellType()){
            case A:
                swapCell(board, agent, cellToSwap.getPoint());
                board.setALocation(board.getAgent());
                break;
            case B:
                swapCell(board, agent, cellToSwap.getPoint());
                board.setBLocation(agent);
                break;
            case C:
                swapCell(board, agent, cellToSwap.getPoint());
                board.setCLocation(agent);
                break;
            case EMPTY:
                swapCell(board, agent, cellToSwap.getPoint());
                break;
        }
    }

    /**
     * Swap two given point in the board
     * @param board the board
     * @param curr point curr
     * @param next point next
     */
    private void swapCell(Board board, Point curr, Point next){
        Cell[][] cells = board.getCells();

        Cell c1  = cells[next.x][next.y];
        Cell c2 = cells[curr.x][curr.y];

        cells[next.x][next.y] = c2;
        cells[curr.x][curr.y] = c1;
        c2.setLocation(next);
        c1.setLocation(curr);
    }
}

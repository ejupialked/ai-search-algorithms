package Game;

import java.awt.Point;

public class Actions {

    public enum AgentMoves {UP, DOWN, LEFT, RIGHT}

    private final static int UP = 1;
    private final static int DOWN = 2;
    private final static int LEFT = 3;
    private final static int RIGHT = 4;

    public void moveAgent(AgentMoves move, Board b) throws IllegalMoveException{
        Cell agent = b.getAgent();

        switch (move){
            case UP:
                up(b, agent);
                break;
            case DOWN:
                down(b, agent);
                break;
            case LEFT:
                left(b, agent);
                break;
            case RIGHT:
                right(b, agent);
                break;
        }
    }


    private void up(Board board, Cell agent) throws IllegalMoveException {

        int newX = (int) (agent.getX() - 1);
        Point up = new Point(newX, agent.y);

        if(up.x < 0) {
            throw new IllegalMoveException(AgentMoves.UP, up);
        }else{
            move(board, up);
        }
    }

    private void down(Board board, Cell agent) throws IllegalMoveException {
        int newX = (int) (agent.getX() + 1);
        Point down = new Point(newX, agent.y);

        if(down.x >= board.getN()) {
            throw new IllegalMoveException(AgentMoves.DOWN, down);
        }else{
            move(board, down);
        }
    }

    private void left(Board board, Cell agent) throws IllegalMoveException {
        int newY = (int) (agent.getY() - 1);
        Point left = new Point(agent.x, newY);

        if(left.y < 0) {
            throw new IllegalMoveException(AgentMoves.LEFT, left);
        }else{
            move(board, left);
        }
    }

    private void right(Board board, Cell agent) throws IllegalMoveException {
        int newY = (int) (agent.getY() + 1);

        Point right = new Point(agent.x, newY);

        if(right.y >= board.getN()) {
            throw new IllegalMoveException(AgentMoves.RIGHT, right);
        }else{
            move(board, right);
        }
    }


    private void move(Board b, Point p){

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
            case C: swapCell(b, agent, cellToSwap);
                b.setC(b.getAgent());
                break;
            case x:
                swapCell(b, agent, cellToSwap);
                break;
        }

        b.setAgent(cellToSwap);

    }

    private void swapCell(Board board, Point a, Point b){
        Cell[][] cells = board.getCells();
        Cell temp = cells[b.x][b.y];
        cells[b.x][b.y] =  cells[a.x][a.y];
        board.setAgent(cells[b.x][b.y]);
        cells[a.x][a.y] = temp;

    }




}

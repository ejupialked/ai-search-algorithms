package Problem;

import BlocksWorld.Cell;
import Exceptions.IllegalMoveException;
import BlocksWorld.Board;
import Problem.TransitionModel.Action;
import TreeSearchAlgorithm.Node;
import Utils.Utils;

import java.awt.*;

import static BlocksWorld.Cell.*;
import static Utils.Utils.generateBoard;

/**
 *  This class defines the problem to solve.
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public class BlocksWorldTileProblem implements Problem {

    private static int N = 4;

    public TransitionModel transitionModel;

    public Board goal;
    public State startState;

    private static String a = CellType.A.getText();
    private static String b = CellType.B.getText();
    private static String c = CellType.C.getText();
    private static String ag = CellType.AGENT.getText();
    private static String x = CellType.EMPTY.getText();


    private static CellType A = CellType.A;
    private static CellType B = CellType.B;
    private static CellType C = CellType.C;
    private static CellType AGENT = CellType.AGENT;
    private static CellType EMPTY = CellType.EMPTY;




    public BlocksWorldTileProblem(){
        this.transitionModel = transitionModel();
        this.goal = intiGoalState();
        this.startState = initStartState();
    }



    public State initCellsStart(Point pointTileA, Point pointTileB, Point pointTileC, Point pointAgent){
        Cell a = new Cell(pointTileA, A);
        Cell b = new Cell(pointTileB, B);
        Cell c = new Cell(pointTileC, C);
        Cell ag = new Cell(pointAgent, AGENT);
        Board board = generateBoard(a, b, c, ag, N);
        return new State(board);

    }

    public Board initCellsGoal(Point pointTileA, Point pointTileB, Point pointTileC, Point pointAgent){
        Cell a = new Cell(pointTileA, A);
        Cell b = new Cell(pointTileB, B);
        Cell c = new Cell(pointTileC, C);
        Cell ag = new Cell(pointAgent, AGENT);
        return generateBoard(a, b, c, ag, N);
    }



    public State initStartState(){
      String[][] grid = new String[][]
                       {{x, x, x , x},
                        {x, x, ag, x},
                        {b, a, x, x},
                        {x, c, x, x}};

        /*String[][] grid = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {

                if( i == 2 && j == 2)
                    grid[i][j] = ag;
                else if( i == 3 && j == 0)
                    grid[i][j] = a;
                else if( i == 3 && j == 1)
                    grid[i][j] = b;
                else if( i == 3 && j == 2)
                    grid[i][j] = c;
                else
                    grid[i][j] = x;

            }
        }*/



        Board board = new Board(N, grid);
        return new State(board);
    }

    public Board intiGoalState() {
        String[][] grid = new String[][]
                       {{x, x, x, x},
                        {x, a, x, x},
                        {x, b, x, x},
                        {x, c, x, ag}};


       /* String[][] grid = new String[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N ; j++) {

                if( i == 0 && j == 0 )
                    grid[i][j] = ag;
                else if( i ==  1 && j == 1)
                    grid[i][j] = a;
                else if( i == 2 && j == 1)
                    grid[i][j] = b;
                else if( i == 3 && j == 1)
                    grid[i][j] = c;
                else
                    grid[i][j] = x;

            }
        }*/


        Board board = new Board(N, grid);
        return board;
    }


    @Override
    public TransitionModel transitionModel() {
        return new TransitionModel();
    }

    @Override
    public Action[] actions() {
        return Action.values();
    }


    @Override
    public State startState() {
        return startState;
    }

    @Override
    public Board goal() {
        return goal;
    }

    @Override
    public State generateState(State parent, Action action) throws IllegalMoveException {
        Board board = new Board(parent.getBoard().getN(),
                parent.getBoard().getGrid());

        State newState = new State(board);

        transitionModel.performTransition(action, newState);

        return newState;
    }

    @Override
    public int actionCost() {
        return 1;
    }


    /**
     * Checks by just comparing
     * the String configuration (of the Board)
     *
     * Replaces the string of the agent with
     * the string that represents an empty space
     * since the position of the agent does not matter
     * when checking the goal state
     * @param solution the node to check
     * @return
     */
    @Override
    public boolean checkGoal(Node solution) {
        State state = solution.getState();
        return goal().getConfiguration().replace(ag, x).equals(state.toString().replace(ag, x));
    }
}

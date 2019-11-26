package Problem;

import BlocksWorld.Cell;
import Exceptions.IllegalMoveException;
import BlocksWorld.Board;
import Problem.TransitionModel.Action;
import TreeSearchAlgorithm.Node;

import java.awt.*;

import static BlocksWorld.Cell.*;
import static Utils.Utils.*;

/**
 *  This class defines the problem to solve.
 *
 *  @author Alked Ejupi Copyright (2019). All rights reserved.
 */

public class BlocksWorldTileProblem implements Problem {

    private static int N = 4;
    private static int STEP_COST = 1;

    public TransitionModel transitionModel;

    public String goalConfiguration;

    public Board goalBoard;
    public State startState;

    private static CellType A = CellType.A;
    private static CellType B = CellType.B;
    private static CellType C = CellType.C;
    private static CellType AGENT = CellType.AGENT;
    private static CellType EMPTY = CellType.EMPTY;


    public BlocksWorldTileProblem(Point...points){
        this.transitionModel = transitionModel();
        this.startState = initStart(points[0], points[1], points[2], points[3]);
        this.goalConfiguration = initGoal(points[4], points[5], points[6], points[7]);
    }


    public State initStart(Point pointTileA, Point pointTileB, Point pointTileC, Point pointAgent){
        Cell a = new Cell(pointTileA, A);
        Cell b = new Cell(pointTileB, B);
        Cell c = new Cell(pointTileC, C);
        Cell ag = new Cell(pointAgent, AGENT);
        Board board = generateBoard(a, b, c, ag, N);
        return new State(board);

    }

    public String initGoal(Point pointTileA, Point pointTileB, Point pointTileC, Point pointAgent){
        Cell a = new Cell(pointTileA, A);
        Cell b = new Cell(pointTileB, B);
        Cell c = new Cell(pointTileC, C);
        Cell ag = new Cell(pointAgent, AGENT);
        this.goalBoard = generateBoard(a, b, c, ag, N);
        return goalBoard.getConfiguration();
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
        return goalBoard;
    }



    public void setGoal(String goal) {
        this.goalConfiguration = goal;
    }

    @Override
    public State generateState(State parent, Action action) throws IllegalMoveException {

        Board parentBoard = parent.getBoard();

        // new cells for A, B, C and agent
        Cell An = cloneCell(parentBoard.getA());
        Cell Bn = cloneCell(parentBoard.getB());
        Cell Cn = cloneCell(parentBoard.getC());
        Cell AGn = cloneCell(parentBoard.getAgent());

        //new Board
        Board board = generateBoard(An, Bn, Cn, AGn, parentBoard.getN());

        //new State
        State newState = new State(board);

        transitionModel.performTransition(action, newState);

        return newState;
    }

    public String getGoalConfiguration() {
        return goalConfiguration;
    }




    @Override
    public int actionCost() {
        return STEP_COST;
    }

    public Board getGoalBoard() {
        return goalBoard;
    }

    @Override
    public boolean checkGoal(Node solution) {
        State state = solution.getState();
        return getGoalConfiguration().replace(AGENT.getText(), EMPTY.getText())
                .equals(state.getBoard().getConfiguration().replace(AGENT.getText(), EMPTY.getText()));
    }

}

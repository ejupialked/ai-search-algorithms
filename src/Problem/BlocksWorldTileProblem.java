package Problem;

import BlocksWorld.Cell;
import Exceptions.IllegalMoveException;
import BlocksWorld.Board;
import Problem.TransitionModel.Action;
import TreeSearchAlgorithm.Node;

import java.awt.*;

import static BlocksWorld.Cell.*;
import static BlocksWorld.Cell.CellType.EMPTY;
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


    public BlocksWorldTileProblem(Point...points){
        this.transitionModel = transitionModel();
        this.startState = initStart(points[0], points[1], points[2], points[3]);
        this.goalConfiguration = initGoal(points[4], points[5], points[6], points[7]);
    }

    public BlocksWorldTileProblem(String startConfiguration, String goalConfiguration){
        this.transitionModel = transitionModel();
        this.startState = initStart(startConfiguration);
        this.goalConfiguration = initGoal(goalConfiguration);
    }


    public State initStart(Point...points){
        Cell a = new Cell(points[0], A);
        Cell b = new Cell(points[1], B);
        Cell c = new Cell(points[2], C);
        Cell ag = new Cell(points[3], AGENT);
        Cell[][] cells = generateGridCells(a, b, c, ag, N);
        Board board = generateBoard(cells, N);
        return new State(board);
    }

    public String initGoal(Point...points){
        Cell a = new Cell(points[0], A);
        Cell b = new Cell(points[1], B);
        Cell c = new Cell(points[2], C);
        Cell ag = new Cell(points[3], AGENT);
        Cell[][] cells = generateGridCells(a, b, c, ag, N);
        this.goalBoard = generateBoard(cells, N);
        return goalBoard.getConfiguration();
    }

    public State initStart(String startConfiguration){
        Cell[][] cells = convert1DTo2DCells(convertStringTo1DCells(startConfiguration));
        Board board = generateBoard(cells, N);
        return new State(board);
    }

    public String initGoal(String goalConfiguration){
        Cell[][] cells = convert1DTo2DCells(convertStringTo1DCells(goalConfiguration));
        this.goalBoard = generateBoard(cells, N);
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
        //new cells
        Cell[][] cells = generateGridCells(An, Bn, Cn, AGn, parentBoard.getN());
        //new Board
        Board board = generateBoard(cells, parentBoard.getN());
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

        // return getGoalConfiguration().equals(state.board.getConfiguration());

        return getGoalConfiguration().replace(AGENT.getText(), EMPTY.getText())
               .equals(state.getBoard().getConfiguration().replace(AGENT.getText(), EMPTY.getText()));
    }

}

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

    public TransitionModel transitionModel;

    public Board goal;
    public State startState;

    private static CellType A = CellType.A;
    private static CellType B = CellType.B;
    private static CellType C = CellType.C;
    private static CellType AGENT = CellType.AGENT;
    private static CellType EMPTY = CellType.EMPTY;


    public BlocksWorldTileProblem(Point...points){
        this.transitionModel = transitionModel();
        this.startState = initCellsStart(points[0], points[1], points[2], points[3]);
        this.goal = initCellsGoal(points[4], points[5], points[6], points[7]);
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

        transitionModel.performTransitionCells(action, newState);

        return newState;
    }


    @Override
    public int actionCost() {
        return 1;
    }


    //1164684252
    @Override
    public boolean checkGoal(Node solution) {

        if(solution.hashCode() == 1164684252) print(solution.getState().getBoard().getConfiguration());
        if(solution.hashCode() == 1164626592) print(solution.getState().getBoard().getConfiguration());

        State state = solution.getState();
        return goal().getConfiguration().replace(AGENT.getText(), EMPTY.getText()).equals(state.toString().replace(AGENT.getText(), EMPTY.getText()));
    }
}

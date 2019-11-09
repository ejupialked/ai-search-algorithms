package Game;

import Game.Actions;
import Game.Board;
import Exceptions.IllegalMoveException;
import Game.State;

import static Utils.Utils.*;

public class BlocksWorldTilePuzzle {

    private static int N = 4;
    public static State START_STATE = startState();
    public static State GOAL_STATE =  goalState();

    private Actions actions;

    public BlocksWorldTilePuzzle(){
        this.actions = new Actions();
    }


    private static State startState(){

        String[][] grid = new String[][]
                {{"x", "x", "x", "x"},
                        {"a", "x", "C", "x"},
                        {"x", "B", "x", "x"},
                        {"x", "A", "x", "x"}};


        Board board = new Board(N, grid);

        return new State(board, grid);
    }

    private static State goalState(){
        String[][] grid = new String[][]
                {{"x", "x", "x", "x"},
                        {"x", "x", "C", "x"},
                        {"x", "B", "x", "x"},
                        {"x", "A", "x", "a"}};


        Board board = new Board(N, grid);

        return new State(board, grid);
    }

    public Actions getActions() {
        return actions;
    }

    public static void main(String[] args) {

        print(START_STATE.toString());

        Actions actions = new Actions();

        try {
            actions.moveAgent(Actions.AgentMoves.UP, START_STATE.getBoard());
            print(START_STATE.toString());
            actions.moveAgent(Actions.AgentMoves.RIGHT, START_STATE.getBoard());
            print(START_STATE.toString());
            actions.moveAgent(Actions.AgentMoves.RIGHT, START_STATE.getBoard());
            print(START_STATE.toString());
            actions.moveAgent(Actions.AgentMoves.DOWN, START_STATE.getBoard());
            print(START_STATE.toString());

        } catch (IllegalMoveException e) {
            e.printStackTrace();
        }

    }
}

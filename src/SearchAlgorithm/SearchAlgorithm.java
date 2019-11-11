package SearchAlgorithm;

import Puzzle.Board;
import Puzzle.State;
import Problem.Problem;

import java.util.LinkedList;


/**
 * Abstract class for a search algorithm,
 * Contains all methods and attributes that
 * every search methods should have.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */
public abstract class SearchAlgorithm {

    protected int nodes;
    protected int depth;

    protected long start;
    protected long end;

    StringBuilder solutionMoves;
    StringBuilder solutionASCII;


    public String searchDebug(Problem problem){
        start();
        LinkedList<Node> solution = search(problem);

        int i = 0;
        for (Node node: solution) {
            solutionASCII
                    .append("Step ")
                    .append(i++)
                    .append(": ")
                    .append(node.state.getActionTaken())
                    .append("\n")
                    .append(node.state.ascii())
                    .append("\n");
        }

        end();

        return toString();
    }

    protected abstract LinkedList<Node> search(Problem problem);

    protected abstract LinkedList<Node> solution(Node node);

    SearchAlgorithm(){
        this.nodes = 0;
        this.depth = 0;
        this.solutionASCII = new StringBuilder();
    }



    public void start(){
        this.start =  System.currentTimeMillis();
    }

    public void end(){
        this.end = System.currentTimeMillis();
    }

    public long time(){
        return end - start;
    }


    @Override
    public String toString() {
        return solutionASCII + "\nTime elapsed: " + time() + "ms\n" +
                "Number nodes: " + nodes + "\n" +
                "Depth : " + depth + "\n";
    }

    public static class Node {
        State state;
        Node parent;

        Node(State startState, Node parent){
            Board board = new Board(startState.getBoard().getN(),startState.getBoard().getGrid());
            this.state = new State(board);
            this.parent = parent;
        }

        /**
         * Returns the state of the board
         * as a String.
         * @return the state of board
         */
        @Override
        public String toString() {
            return Integer.toString(hashCode());
        }

        public State getState() {
            return state;
        }


        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Node){
                return getState().getBoard().getConfiguration().equals(
                        ((Node) obj).getState().getBoard().getConfiguration());
            }
            return false;
        }

        @Override
        public int hashCode() {
            return this.state.getBoard().getConfiguration().hashCode();
        }
    }
}

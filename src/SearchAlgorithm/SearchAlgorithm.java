package SearchAlgorithm;

import Game.Board;
import Game.State;
import PuzzleProbem.Puzzle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class SearchAlgorithm {

    protected int nodes;
    protected int depth;

    protected long start;
    protected long end;


    SearchAlgorithm(){
        this.nodes = 0;
        this.depth = 0;
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

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Time elapsed: ").append(time()).append("ms\n");
        stringBuilder.append("Number nodes: ").append(nodes).append("\n");
        stringBuilder.append("Depth : ").append(depth).append("\n");




        return stringBuilder.toString();
    }

    public static class Node {
        State state;
        Node parent;


        public Node(State startState){

            Board board = new Board(startState.getBoard().getN(),startState.getBoard().getGrid());
            this.state = new State(board);
            this.parent = null;
        }

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


    public abstract LinkedList<Node> search(Puzzle problem);

    public abstract LinkedList<Node> solution(Node node);


}

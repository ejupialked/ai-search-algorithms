package SearchAlgorithm;

import Problem.Problem;
import Utils.Utils;

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

        Utils.print("I'm searching your solution..");
        start();

        LinkedList<Node> solution = treeSearch(problem);



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

    protected abstract LinkedList<Node> treeSearch(Problem problem);

    protected abstract LinkedList<Node> graphSearch(Problem problem);

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


}

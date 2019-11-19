package TreeSearchAlgorithm;

import Exceptions.IllegalMoveException;
import Problem.Problem;
import Utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Problem.TransitionModel.Action;


/**
 * Abstract class for a search algorithm,
 * Contains all methods and attributes that
 * every search methods should have.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */
public abstract class TreeSearchAlgorithm {

    protected int nodes;
    protected int depth;

    protected long start;
    protected long end;

    protected long startMemory;
    protected long endMemory;

    StringBuilder solutionMoves;
    StringBuilder solutionASCII;


    protected abstract LinkedList<Node> search(Problem problem);





    TreeSearchAlgorithm(){
        this.nodes = 1;
        this.depth = 0;
        this.solutionASCII = new StringBuilder();
        this.solutionMoves = new StringBuilder();
    }


    private Node generateChildNode(Problem problem, Node parent,Action action) throws IllegalMoveException {
        return new Node(problem, parent, action);
    }

    protected List<Node> generateSuccessors(Node nodeToExpand, Problem problem){
        ArrayList<Node> successors = new ArrayList<Node>();


        for (Action action: problem.actions()) {
            Node child = null;
            try {
                child = generateChildNode(problem, nodeToExpand, action);
            } catch (IllegalMoveException e) {
            }

            if(child != null)
                successors.add(child);

        }

        return successors;
    }

    public String solveProblem(Problem problem){

        Utils.print("I'm searching your solution..");

        start();
        startMemory = Runtime.getRuntime().totalMemory();

        LinkedList<Node> solution = search(problem);
        end();
        endMemory = Runtime.getRuntime().totalMemory() - startMemory;

        int i = 0;
        for (Node node: solution) {
            solutionMoves.append(node.action).append(" ");
            solutionASCII
                    .append("Step ")
                    .append(i++)
                    .append(": ")
                    .append(node.state.getActionTaken())
                    .append("\n")
                    .append(node.state.ascii())
                    .append("\n");
        }


        return toString();
    }
    protected LinkedList<Node> solution(Node solution) {
        LinkedList<Node> path = new LinkedList<>();

        path.add(solution);
        while (solution.parent != null) {
            path.add(solution.parent);
            solution = solution.parent;
        }

        Collections.reverse(path);

        depth = path.size();
        return path;
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
        return solutionASCII +
                "\nTime elapsed: " + time() + "ms" +
                "\nNumber nodes generated: " + nodes +
                "\nDepth solution : " + depth +
                "\nMoves: " + solutionMoves
               ;
    }
}

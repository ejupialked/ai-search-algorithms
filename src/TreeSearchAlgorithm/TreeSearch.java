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
public abstract class TreeSearch {

    int nodes;
    int depth;

    protected long start;
    protected long end;

    private StringBuilder solutionMoves;
    private StringBuilder solutionASCII;


    protected abstract List<Node> search(Problem problem);

    TreeSearch(){
        this.nodes = 1;
        this.depth = 0;
        this.solutionASCII = new StringBuilder();
        this.solutionMoves = new StringBuilder();
    }


    private Node generateChildNode(Problem problem, Node parent,Action action) throws IllegalMoveException {
        return new Node(problem, parent, action);
    }


    protected List<Node> generateRandomSuccessors(Node nodeToExpand, Problem problem){
        ArrayList<Node> successors = new ArrayList<Node>();

        for (Action action: Utils.shuffle(problem.actions())) {
            Node child = null;
            try {
                child = generateChildNode(problem, nodeToExpand, action);
                nodes++;
            } catch (IllegalMoveException e) {
            }

            if(child != null)
                successors.add(child);

        }

        return successors;
    }

    protected List<Node> generateSuccessors(Node nodeToExpand, Problem problem){
        ArrayList<Node> successors = new ArrayList<Node>();


        //Utils.print("Expanding: " + nodeToExpand.hashCode());
        //Utils.print(nodeToExpand.state.ascii());

        //Utils.print("-----------start expansion------------");


        for (Action action: problem.actions()) {
            Node child = null;
            try {
                child = generateChildNode(problem, nodeToExpand, action);
                nodes++;
               // Utils.print("Node: "+ child.state.hashCode());

                //Utils.print(child.state.ascii());
            } catch (IllegalMoveException e) {
            }

            if(child != null)
                successors.add(child);

        }

       // Utils.print("-----------end expansion------------");


        return successors;
    }

    public String solveProblem(Problem problem){

        Utils.print("I'm solving the puzzle...");


        start = System.currentTimeMillis();
        List<Node> solution = search(problem);
        end = System.currentTimeMillis();



        int i = 1;
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

    protected List<Node> solution(Node solution) {
        LinkedList<Node> path = new LinkedList<>();

        path.add(solution);
        while (solution.parent != null) {
            path.add(solution.parent);
            solution = solution.parent;
        }

        Collections.reverse(path);

        //remove start node from the solution
        path.remove(0);

        depth = path.size();
        return path;
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

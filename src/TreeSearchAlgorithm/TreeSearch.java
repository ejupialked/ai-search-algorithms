package TreeSearchAlgorithm;

import Exceptions.IllegalMoveException;
import Problem.Problem;
import Problem.State;
import Utils.Debug;

import java.util.*;

import Problem.TransitionModel.Action;
import Utils.Utils;



/**
 * Abstract class for a search algorithm,
 * Contains all methods and attributes that
 * every search methods should have.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */
public abstract class TreeSearch {

    int nodesGenerated;

    int depth;

    protected long start;
    protected long end;

    private List<Node> solution;
    private StringBuilder solutionMoves;
    private StringBuilder solutionASCII;


    protected abstract List<Node> treeSearch(Problem problem);

    TreeSearch(){
        this.nodesGenerated = 0;
        this.depth = 0;
        this.solutionASCII = new StringBuilder();
        this.solutionMoves = new StringBuilder();

    }

    public int getNodesGenerated() {
        return nodesGenerated;
    }

    protected Node makeNode(State initialState){
        nodesGenerated++;
        return new Node(initialState);
    }

    private Node generateChildNode(Problem problem, Node parent, Action action) throws IllegalMoveException {
        return new Node(problem, parent, action, false);
    }

    private Node generateHeuristicChildNode(Problem problem, Node parent, Action action) throws IllegalMoveException {
        return new Node(problem, parent, action, true);
    }

    protected List<Node> generateRandomSuccessors(Node nodeToExpand, Problem problem){
        List<Node> random = generateSuccessors(nodeToExpand, problem, false);
        Debug.showShuffling();
        Collections.shuffle(random);
        return random;
    }

    protected List<Node> generateSuccessors(Node nodeToExpand, Problem problem, boolean heuristic){

        ArrayList<Node> successors = new ArrayList<Node>();

        Debug.showStartExpansion(nodeToExpand.state);

        for (Action action: problem.actions()) {
            Node child;
            try {
                if(!heuristic){
                    child = generateChildNode(problem, nodeToExpand, action);
                }else{
                    child = generateHeuristicChildNode(problem, nodeToExpand, action);
                }
            } catch (IllegalMoveException e) {
                child = null;
            }

            if(child != null) {
                successors.add(child);
                Debug.showChildGenerated(child);
                nodesGenerated++;
            }
        }

        Debug.showEndExpansion(nodeToExpand.state, successors);

        return successors;
    }

    // TODO: 26/11/2019
    public String solveProblem(Problem problem){
        start = System.currentTimeMillis();
        this.solution = treeSearch(problem);
        end = System.currentTimeMillis();

        // return "Nodes generated: " + nodesGenerated + "\n Nodes expanded: " + nodesExpanded;
         return Utils.solutionToString(this);
    }

    protected List<Node> solution(Node solution) {
        LinkedList<Node> path = new LinkedList<>();

        path.add(solution);
        while (solution.parent != null) {
            path.add(solution.parent);
            solution = solution.parent;
        }

        Collections.reverse(path);
        path.remove(0);

        depth = path.size();
        return path;
    }

    public List<Node> getSolution() {
        return solution;
    }

    public int getDepth() {
        return depth;
    }

    public StringBuilder getSolutionMoves() {
        return solutionMoves;
    }

    public StringBuilder getSolutionASCII() {
        return solutionASCII;
    }

    public long time(){
        return end - start;
    }
}

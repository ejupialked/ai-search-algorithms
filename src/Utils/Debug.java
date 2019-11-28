package Utils;

import Problem.State;
import TreeSearchAlgorithm.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import static Utils.Utils.newLine;
import static Utils.Utils.println;

/**
 * Debug class
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */


public class Debug {

    public static boolean ON = true;
    public static boolean OFF = false;

    public static boolean DEBUGGER;

    public static void setDEBUGGER(boolean DEBUGGER) {
        Debug.DEBUGGER = DEBUGGER;
    }

    public static void showRemoveNodeFromFringe(Node nodeToRemove){

        if(DEBUGGER){
            println("Removing node " + nodeToRemove.getState().getBoard().getConfiguration() + " from the fringe");
            println(" ");
        }
    }

    public static void showHeuristicFringe(Collection<Node> fringe){
        if(DEBUGGER){
            println("     FRINGE     ");
            println("╔════════════════╗");

            Iterator<Node> it = fringe.iterator();

            int j = 1;
            if(fringe.size() == 0){
                println("║     empty      ║");
            }else{
                while (it.hasNext()) {
                    Node node = it.next();
                    println("║"+node.getState().getBoard().getConfiguration() + "║"+" (cost=" + node.getEstimatedCost() + ")");
                }
            }
            println("╚════════════════╝");
        }

    }

    public static void showFringe(Collection<Node> fringe){
        if(DEBUGGER) {
            if (fringe instanceof PriorityQueue) {
                showHeuristicFringe(fringe);
            } else {
                println("     FRINGE     ");
                println("╔════════════════╗");

                Iterator<Node> it = fringe.iterator();

                int j = 1;
                if (fringe.size() == 0) {
                    println("║     empty      ║");
                } else {
                    while (it.hasNext()) {
                        Node node = it.next();
                        println("║" + node.getState().getBoard().getConfiguration()
                                + "║" + " (" + j++ + ")");
                    }
                }
                println("╚════════════════╝");
            }
        }

    }

    public static void showCheckGoal(Node nodeToExpand) {
        if(DEBUGGER)
            println("Check if " + nodeToExpand.getState().getBoard().getConfiguration() + " is the goal...");
    }

    public static void showAddingRoot(Node node) {
        if(DEBUGGER) {
            println("Adding root " + node.getState().getBoard().getConfiguration() + "to the fringe.");

        }
    }

    public static void showGoal(Node nodeGoal) {
        if(DEBUGGER){
            println("Node " + nodeGoal.getState().getBoard().getConfiguration() + " is the goal!");
            println(" ");
            println("Solution:");
        }
    }

    public static void showIsNotGoal(Node node) {
        if(DEBUGGER)
            println("It is not the goal, " + " then expand node "+ node.getState().getBoard().getConfiguration());
    }

    public static void showStartExpansion(State state) {
        if(DEBUGGER){
            Utils.newLine();
            println("Start expanding node "  + state.getBoard().getConfiguration());
            Utils.newLine();
        }

    }

    public static void showAddAllSuccessors(int size) {
        if(DEBUGGER){
            println("Adding " + size + " successors to the fringe.");
        }
    }

    public static void showChildGenerated(Node child) {
        if(DEBUGGER){
            println("Child: " + child.getState().getBoard().getConfiguration());
            if(child.isHeuristic()){
                println("estimated cost : "+ child.getEstimatedCost());
            }
            println("Action taken: " + child.getState().getActionTaken().name());
            println(child.getState().ascii());
            Utils.newLine();
        }
    }

    public static void showEndExpansion(State state, List<Node> successors) {
        if(DEBUGGER){
            println("End expansion of " + state.getBoard().getConfiguration());
            println("No. successors generated: " + successors.size());
            Utils.newLine();
        }
    }


    public static void showShuffling() {
        if(DEBUGGER){
            println("Shuffling the order of the successors...");
        }
    }

    public static void showLimitIteration(int depth) {
        if(DEBUGGER){
            newLine();
            println("Performing IDS at depth limit " + depth);
            newLine();
        }
    }

    public static void showStartDLSCall(Node node, int depth) {
        if(DEBUGGER){
            println("Performing recursive DLS calls (d=" + depth +") on root node "+ node.getState().getBoard().getConfiguration());
        }
    }

    public static void showEndDLSCalls(int depth) {
        if(DEBUGGER){
            newLine();
            println("End of recursive DLS calls with (d=" + depth +")");
            newLine();
        }
    }

    public static void showSolutionFoundDLS(int depth) {

        if(DEBUGGER){
            println("Solution found at (d=" + depth +")");
        }
    }

    public static void showNoSolutionFoundDLS(int depth) {
        if(DEBUGGER){
            println("Solution not found at depth limit "+ depth);
            println("End performing IDS at depth limit "+ depth);
        }
    }

    public static void showCallDLSOnChild(Node state) {
        if(DEBUGGER){
            newLine();
            println("Performing recursive DLS on " + state.getState().getBoard().getConfiguration());
        }
    }

    public static void showGoalDFS(Node current) {
        if(DEBUGGER){
            println("Ending recursive DLS at " + current.getState().getBoard().getConfiguration());
            println("Solution found, return value to IDS.");
        }
    }

    public static void creatingRoot(String config) {
        if(DEBUGGER){
            println("Creating root with initial state: " + config);
            newLine();
        }
    }

    public static void showDFSCallOnSuccessors(List<Node> successors) {
        if(DEBUGGER){
            println("Calling DFS on " + successors.size() + " successors");
        }
    }



}

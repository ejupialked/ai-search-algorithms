package Utils;

import Problem.State;
import TreeSearchAlgorithm.Node;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

import static Utils.Utils.newLine;
import static Utils.Utils.print;

public class DEBUG {

    public static boolean ON = true;
    public static boolean OFF = false;

    public static boolean DEBUGGER;

    public static void setDEBUGGER(boolean DEBUGGER) {
        DEBUG.DEBUGGER = DEBUGGER;
    }

    public static void showRemoveNodeFromFringe(Node nodeToRemove){

        if(DEBUGGER){
            print("Removing node " + nodeToRemove.getState().getBoard().getConfiguration() + " from the fringe");
            print(" ");
        }
    }

    public static void showHeuristicFringe(Collection<Node> fringe){
        if(DEBUGGER){
            print("     FRINGE     ");
            print("╔════════════════╗");

            Iterator<Node> it = fringe.iterator();

            int j = 1;
            if(fringe.size() == 0){
                print("║     empty      ║");
            }else{
                while (it.hasNext()) {
                    Node node = it.next();
                    print("║"+node.getState().getBoard().getConfiguration() + "║"+" (cost=" + node.getEstimatedCost() + ")");
                }
            }
            print("╚════════════════╝");
        }

    }


    public static void showFringe(Collection<Node> fringe){
        if(DEBUGGER) {
            if (fringe instanceof PriorityQueue) {
                showHeuristicFringe(fringe);
            } else {
                print("     FRINGE     ");
                print("╔════════════════╗");

                Iterator<Node> it = fringe.iterator();

                int j = 1;
                if (fringe.size() == 0) {
                    print("║     empty      ║");
                } else {
                    while (it.hasNext()) {
                        Node node = it.next();
                        print("║" + node.getState().getBoard().getConfiguration()
                                + "║" + " (" + j++ + ")");
                    }
                }
                print("╚════════════════╝");
            }
        }

    }

    public static void showCheckGoal(Node nodeToExpand) {
        if(DEBUGGER)
            print("Check if " + nodeToExpand + " is the goal...");
    }

    public static void showAddingRoot(Node node) {
        if(DEBUGGER) {
            print("Adding root " + node.getState().getBoard().getConfiguration() + "to the fringe.");

        }
    }

    public static void showGoal(Node nodeGoal) {
        if(DEBUGGER){
            print("Node " + nodeGoal.getState().getBoard().getConfiguration() + " is the goal!");
            print(" ");
            print("Solution:");
        }
    }

    public static void showIsNotGoal(Node node) {
        if(DEBUGGER)
            print("It is not the goal, " + " then expand node "+ node.getState().getBoard().getConfiguration());
    }

    public static void showStartExpansion(State state) {
        if(DEBUGGER){
            Utils.newLine();
            print("Start expanding node "  + state.getBoard().getConfiguration());
            Utils.newLine();
        }

    }

    public static void showAddAllSuccessors(int size) {
        if(DEBUGGER){
            print("Adding " + size + " successors to the fringe.");
        }
    }

    public static void showChildGenerated(State state) {
        if(DEBUGGER){
            print("Child: " + state.getBoard().getConfiguration());
            print("Action taken: " + state.getActionTaken().name());
            print(state.ascii());
            Utils.newLine();
        }
    }

    public static void showEndExpansion(State state, List<Node> successors) {
        if(DEBUGGER){
            print("End expansion of " + state.getBoard().getConfiguration());
            print("No. successors generated: " + successors.size());
            Utils.newLine();
        }
    }


    public static void showShuffling() {
        if(DEBUGGER){
            print("Shuffling the order of the successors...");
        }
    }

    public static void showLimitIteration(int depth) {
        if(DEBUGGER){
            newLine();
            print("Performing IDS at depth limit " + depth);
            newLine();
        }
    }

    public static void showStartDLSCall(Node node, int depth) {
        if(DEBUGGER){
            print("Performing recursive DLS calls (d=" + depth +") on root node "+ node.getState().getBoard().getConfiguration());
        }
    }

    public static void showEndDLSCalls(int depth) {
        if(DEBUGGER){
            newLine();
            print("End of recursive DLS calls with (d=" + depth +")");
            newLine();
        }
    }

    public static void showSolutionFoundDLS(int depth) {

        if(DEBUGGER){
            print("Solution found at (d=" + depth +")");
        }
    }

    public static void showNoSolutionFoundDLS(int depth) {
        if(DEBUGGER){
            print("Solution not found at depth limit "+ depth);
            print("End performing IDS at depth limit "+ depth);
        }
    }

    public static void showCallDLSOnChild(Node state) {
        if(DEBUGGER){
            newLine();
            print("Performing recursive DLS on " + state.getState().getBoard().getConfiguration());
        }
    }

    public static void showGoalDFS(Node current) {
        if(DEBUGGER){
            print("Ending recursive DLS at " + current.getState().getBoard().getConfiguration());
            print("Solution found, return value to IDS.");
        }
    }

    public static void creatingRoot(String config) {
        if(DEBUGGER){
            print("Creating root with initial state: " + config);
            newLine();
        }
    }

    public static void showDFSCallOnSuccessors(List<Node> successors) {
        if(DEBUGGER){
            print("Calling DFS on " + successors.size() + " successors");
        }
    }
}

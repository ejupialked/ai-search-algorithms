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

    public static void showRemoveNodeFromFringe(Collection<Node> fringe, String nodeToRemove){

        if(DEBUGGER){
            print("Removing node " + nodeToRemove + " from the fringe");
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

    public static void showCheckGoal(String nodeToExpand) {
        if(DEBUGGER)
            print("Check if " + nodeToExpand + " is the goal...");
    }

    public static void showAddingRoot(String configuration) {
        if(DEBUGGER) {
            print("Adding root " + configuration + "to the fringe.");

        }
    }

    public static void showGoal(String toString) {
        if(DEBUGGER){
            print("Node " + toString + " is the goal!");
            print(" ");
            print("Solution:");
        }
    }

    public static void showIsNotGoal(String toString) {
        if(DEBUGGER)
            print("It is not the goal, " + " then expand node "+ toString);
    }

    public static void showStartExpansion(State state) {
        if(DEBUGGER){
            Utils.newLine();
            print("Start expanding node "  + state.toString());
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
            print("Child: " + state.toString());
            print("Action taken: " + state.getActionTaken().name());
            print(state.ascii());
            Utils.newLine();
        }
    }

    public static void showEndExpansion(State state, List<Node> successors) {
        if(DEBUGGER){
            print("End expansion of " + state.toString());
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

    public static void showStartDLSCall(Node toString, int depth) {
        if(DEBUGGER){
            print("Performing recursive DLS calls (d=" + depth +") on root node "+ toString);
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
            print("Performing recursive DLS on " + state.toString());
        }
    }

    public static void showGoalDFS(Node current) {
        if(DEBUGGER){
            print("Ending recursive DLS at " + current.getState().toString());
            print("Solution found, return value to IDS.");
        }
    }

    public static void creatingRoot(String toString) {
        if(DEBUGGER){
            print("Creating root with initial state: " + toString);
            newLine();
        }
    }

    public static void showDFSCallOnSuccessors(List<Node> successors) {
        if(DEBUGGER){
            print("Calling DFS on " + successors.size() + " successors");
        }
    }
}

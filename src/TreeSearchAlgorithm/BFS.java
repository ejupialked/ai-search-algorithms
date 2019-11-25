package TreeSearchAlgorithm;

import Problem.Problem;
import Utils.Utils;

import java.util.*;

public class BFS extends TreeSearch {

    //Uses a queue to store the fringe
    Queue<Node> fringe;

    public BFS(){
        super();
        this.fringe = new LinkedList<>();
    }

    @Override
    protected List<Node> search(Problem problem) {
        Node root = makeNode(problem.startState());


        Utils.print("Adding root " + root.state.getBoard().getConfiguration() + "to the fringe.");
        fringe.add(root);

        Utils.print(" ");
        Utils.showFringe(fringe);
        Utils.print(" ");





        while(!fringe.isEmpty()){

            Node nodeToExpand = fringe.remove();
            Utils.print("Removing node " + nodeToExpand.state.getBoard().getConfiguration() + " from the fringe");


                    Utils.print(" ");
            Utils.showFringe(fringe);
                    Utils.print(" ");



            Utils.print("Check if " + nodeToExpand.state.getBoard().getConfiguration() + " is the goal...");
            if(problem.checkGoal(nodeToExpand)) {
                Utils.print("Node " + nodeToExpand.state.getBoard().getConfiguration() + " is the goal!");
                Utils.print("Solution:");
                return solution(nodeToExpand);
            }

            Utils.print("It is not the goal, " + " then expand node "+ nodeToExpand.state.getBoard().getConfiguration());

            List<Node> successors = generateSuccessors(nodeToExpand, problem);
            Utils.print("Adding all successors to the fringe.");
            fringe.addAll(successors);

                    Utils.print(" ");
            Utils.showFringe(fringe);
                    Utils.print(" ");

        }
        return null;
    }



}

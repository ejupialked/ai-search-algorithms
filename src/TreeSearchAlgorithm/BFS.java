package TreeSearchAlgorithm;

import Problem.Problem;


import java.util.*;

import static Utils.Utils.print;
import static Utils.Utils.showFringe;

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


        print("Adding root " + root.state.getBoard().getConfiguration() + "to the fringe.");
        fringe.add(root);

        print(" ");
        showFringe(fringe);
        print(" ");





        while(!fringe.isEmpty()){

            Node nodeToExpand = fringe.remove();
            print("Removing node " + nodeToExpand.state.getBoard().getConfiguration() + " from the fringe");


                    print(" ");
            showFringe(fringe);
                    print(" ");



            print("Check if " + nodeToExpand.state.getBoard().getConfiguration() + " is the goal...");

            if(problem.checkGoal(nodeToExpand)) {
                print("Node " + nodeToExpand.state.getBoard().getConfiguration() + " is the goal!");
                                    print(" ");
                print("Solution:");
                 return solution(nodeToExpand);
            }

            print("It is not the goal, " + " then expand node "+ nodeToExpand.state.getBoard().getConfiguration());

            List<Node> successors = generateSuccessors(nodeToExpand, problem);
            print("Adding all successors to the fringe.");
            fringe.addAll(successors);

                    print(" ");
            showFringe(fringe);
                    print(" ");

        }
        return null;
    }



}

package TreeSearchAlgorithm;

import Problem.Problem;
import Problem.TransitionModel.Action;
import static Utils.Utils.shuffle;
import java.util.*;

public class DFS extends TreeSearchAlgorithm {

    private Stack<Node> frontier;

    public DFS(){
        super();
        this.frontier = new Stack<Node>();
    }


    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

        frontier.add(root);

        while (!frontier.isEmpty()){

            Node nodeToExpand = frontier.pop();

            if(problem.checkGoal(nodeToExpand)){
                return solution(nodeToExpand);
            }

            for (Action a: shuffle(problem.actions())) {
                Node child = new Node(nodeToExpand, a);
                nodes++;

                if(!child.state.performAction(a)) continue;

                frontier.add(child);
            }
        }
        return null;
    }
}

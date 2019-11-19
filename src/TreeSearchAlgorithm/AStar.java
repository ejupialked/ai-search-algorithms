package TreeSearchAlgorithm;

import Problem.Problem;
import Problem.TransitionModel.Action;
import java.util.LinkedList;
import java.util.PriorityQueue;


public class AStar extends TreeSearchAlgorithm {

    private PriorityQueue<Node> frontier;

    public AStar(){
        super();
        this.frontier = new PriorityQueue<>();
    }

    @Override
    protected LinkedList<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

        frontier.add(root);

        if(problem.checkGoal(root)){
            return solution(root);
        }


        while(!frontier.isEmpty()){

            Node nodeToExpand = frontier.poll();

            for(Action action: problem.actions()){

                Node child = new Node(nodeToExpand,problem.goal(), action);
                nodes++;

                if(!child.state.performAction(action)) continue;

                if (problem.checkGoal(child)) {
                    return solution(child);
                }
                frontier.add(child);
            }
        }
        return null;
    }
}

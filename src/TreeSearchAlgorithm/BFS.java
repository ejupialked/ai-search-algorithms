package TreeSearchAlgorithm;

import Problem.Problem;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS extends TreeSearch {

    //Uses a queue to store the fringe
    Queue<Node> fringe;

    public BFS(){
        super();
        this.fringe = new LinkedList<>();
    }

    @Override
    protected List<Node> search(Problem problem) {
        Node root = new Node(problem.startState());
        nodes++;

        fringe.add(root);

        while(!fringe.isEmpty()){
            Node nodeToExpand = fringe.remove();

            if(problem.checkGoal(nodeToExpand)) {
                return solution(nodeToExpand);
            }

            List<Node> successors = generateSuccessors(nodeToExpand, problem);
            fringe.addAll(successors);
        }
        return null;
    }
}

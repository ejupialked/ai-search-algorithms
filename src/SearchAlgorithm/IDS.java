package SearchAlgorithm;

import Problem.Problem;
import Puzzle.TransitionModel.*;
import java.util.LinkedList;

public class IDS extends SearchAlgorithm {

    @Override
    protected LinkedList<Node> search(Problem problem) {

        Node root = new Node(problem.startState());
        Node solution;

        for (int depth = 1; depth < Integer.MAX_VALUE ; depth++) {

            solution = DLS(problem, root, depth);

            if (solution != null) {
                return solution(solution);
            }
        }
        return null;
    }


    public Node DLS(Problem problem, Node current, int depth) {

        if (depth == 0 && problem.checkGoal(current.state)) {
            return current;
        }

        if (depth > 0) {
            for (Action action : problem.randomiseActions()) {

                Node child = new Node(current, action);
                nodes++;

                if(!child.state.performAction(action)) continue;

                Node found = DLS(problem, child,depth - 1);

                if (found != null) {
                    return found;
                }
            }
        }

        return null;
    }
}

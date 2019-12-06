package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.List;

public class IDS extends TreeSearch {
    //Finite limit of IDS
    int LIMIT = Integer.MAX_VALUE;

    @Override
    protected List<Node> treeSearch(Problem problem) {

        Node root = makeNode(problem, problem.startState(), false);

        Node solution;

        for (int depth = 0; depth < LIMIT; depth++) {
            nodesGenerated = 1;
            solution = DLS(problem, root, depth);

            if (solution != null) {
                return solution(solution);
            }
        }
        return null;
    }


    private Node DLS(Problem problem, Node current, int depth) {

        if (depth == 0 && problem.checkGoal(current)) {
            return current;
        }

        if (depth > 0) {
            List<Node> successors = generateSuccessors(current, problem, false);

            for(Node successor : successors) {
                Node result = DLS(problem, successor, depth - 1);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}

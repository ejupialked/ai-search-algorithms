package TreeSearchAlgorithm;

import Problem.Problem;

import java.util.List;

public class IDS extends TreeSearch {

    @Override
    protected List<Node> search(Problem problem) {

        Node root = new Node(problem.startState());
        nodes++;

        Node solution;

        for (int depth = 1; depth < Integer.MAX_VALUE ; depth++) {

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

            List<Node> successors = generateSuccessors(current, problem);

            for(Node successor : successors){

                Node result = DLS(problem, successor,depth - 1);

                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}

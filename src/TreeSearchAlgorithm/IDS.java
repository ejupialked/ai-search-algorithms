package TreeSearchAlgorithm;

import Problem.Problem;
import java.util.List;

public class IDS extends TreeSearch {

    private int LIMIT = 30;

    @Override
    protected List<Node> search(Problem problem) {

        Node solution;

        for (int d = 0; d < LIMIT; d++) {

            solution = DLS(problem, d);

            if (solution != null) {
                return solution(solution);
            }
        }
        return null;
    }


    private Node DLS(Problem problem, int depthLimit){
        Node root = makeNode(problem.startState());
        return recursiveDLS(problem,root, depthLimit);
    }


    private Node recursiveDLS(Problem problem, Node current, int limit) {

        if (limit == 0 && problem.checkGoal(current)) {
            return current;
        }else {

            List<Node> successors = generateSuccessors(current, problem);

            for(Node successor : successors){

                Node result = recursiveDLS(problem, successor,limit - 1);

                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}

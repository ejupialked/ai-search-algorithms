package TreeSearchAlgorithm;

import Problem.Problem;
import Utils.Debug;
import java.util.List;

public class IDS extends TreeSearch {

    @Override
    protected List<Node> treeSearch(Problem problem) {

        Node root = makeNode(problem.startState());
        Debug.creatingRoot(root.state.getBoard().getConfiguration());

        Node solution;

        for (int depth = 0; depth < Integer.MAX_VALUE ; depth++) {
            nodesGenerated = 1;
            Debug.showLimitIteration(depth);
            Debug.showStartDLSCall(root, depth);
            solution = DLS(problem, root, depth);

            Debug.showEndDLSCalls(depth);

            if (solution != null) {
                Debug.showSolutionFoundDLS(depth);
                return solution(solution);
            }
            Debug.showNoSolutionFoundDLS(depth);

        }
        return null;
    }


    private Node DLS(Problem problem, Node current, int depth) {

        Debug.showCheckGoal(current);
        if (depth == 0 && problem.checkGoal(current)) {
            Debug.showGoalDFS(current);
            return current;
        }

        Debug.showIsNotGoal(current);

        if (depth > 0) {

            List<Node> successors = generateSuccessors(current, problem, false);

            Debug.showDFSCallOnSuccessors(successors);
            for(Node successor : successors){

                Debug.showCallDLSOnChild(successor);
                Node result = DLS(problem, successor,depth - 1);


                if (result != null) {
                    return result;
                }

            }
        }
        return null;
    }
}

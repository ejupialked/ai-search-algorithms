package TreeSearchAlgorithm;

import Problem.Problem;
import Utils.DEBUG;
import java.util.List;

public class IDS extends TreeSearch {

    @Override
    protected List<Node> treeSearch(Problem problem) {

        Node root = makeNode(problem.startState());
        DEBUG.creatingRoot(root.state.getBoard().getConfiguration());

        Node solution;

        for (int depth = 0; depth < Integer.MAX_VALUE ; depth++) {
            nodes = 1;
            DEBUG.showLimitIteration(depth);
            DEBUG.showStartDLSCall(root, depth);
            solution = DLS(problem, root, depth);
            DEBUG.showEndDLSCalls(depth);

            if (solution != null) {
                DEBUG.showSolutionFoundDLS(depth);
                return solution(solution);
            }
            DEBUG.showNoSolutionFoundDLS(depth);

        }
        return null;
    }


    private Node DLS(Problem problem, Node current, int depth) {

        DEBUG.showCheckGoal(current);
        if (depth == 0 && problem.checkGoal(current)) {
            DEBUG.showGoalDFS(current);
            return current;
        }

        DEBUG.showIsNotGoal(current);

        if (depth > 0) {

            List<Node> successors = generateSuccessors(current, problem);

            DEBUG.showDFSCallOnSuccessors(successors);
            for(Node successor : successors){

                DEBUG.showCallDLSOnChild(successor);
                Node result = DLS(problem, successor,depth - 1);


                if (result != null) {
                    return result;
                }

            }
        }
        return null;
    }
}

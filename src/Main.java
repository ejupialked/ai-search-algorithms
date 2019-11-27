import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import TreeSearchAlgorithm.*;
import Utils.DEBUG;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Utils.DEBUG.*;
import static Utils.Utils.*;

/**
 * Run the algorithms here.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */
public class Main {



    public static void main(String[] args){

        List<String> problems = problems();


        Point a = new Point(3,0);
        Point b = new Point(3,1);
        Point c = new Point(3,2);
        Point agent = new Point(3,3);

        Point aGoal = new Point(1,1);
        Point bGoal = new Point(2,1);
        Point cGoal = new Point(3,1);
        Point agentGoal = new Point(2,0);


        BlocksWorldTileProblem problem1 = new BlocksWorldTileProblem(a, b, c, agent, aGoal, bGoal, cGoal, agentGoal);
        String algorithm = args[0];


        DEBUG.setDEBUGGER(OFF);
       // problem1.setGoal("----BA---@----C-");
        //solveUserProblem(problem1,algorithm);

         solveDifferentPuzzle(problems, algorithm);
    }

    private static void solveDifferentPuzzle(List<String> problems, String algorithm) {
        int i = 1;
        Point a = new Point(3,0);
        Point b = new Point(3,1);
        Point c = new Point(3,2);
        Point agent = new Point(3,3);

        Point aGoal = new Point(1,1);
        Point bGoal = new Point(2,1);
        Point cGoal = new Point(3,1);
        Point agentGoal = new Point(3,3);

        BlocksWorldTileProblem problem1 = new BlocksWorldTileProblem(a, b, c, agent, aGoal, bGoal, cGoal, agentGoal);

        for (String problem: problems) {
            if(i > 0) {
                print(" ");
                print("I'm solving the puzzle with " + algorithm + "...");
                print("Problem: " + i++);
                problem1.setGoal(problem);
                solvePuzzle(problem1, algorithm);
            }else
                i++;
        }


    }

    private static void solveUserProblem(BlocksWorldTileProblem problem, String algorithm) {

        print("INITIAL STATE");
        print(problem.startState().ascii());

         print("--------GOAL STATE--------");
        print(drawGridCells(convert2DCellsTo1DCells(problem.getGoalBoard().getCells()),
         problem.getGoalBoard().getN()));


        print("I'm solving the puzzle with "+ algorithm + "...");
            solvePuzzle(problem, algorithm);
    }


    /**
     * Solve problem.
     *
     * @param problem   the problem
     * @param algorithm the algorithm
     */
    public static void solvePuzzle(Problem problem, String algorithm){

        String output = null;
            switch (algorithm) {
                case "BFS":
                    TreeSearch bfs = new BFS();
                    output = bfs.solveProblem(problem);
                    break;
                case "DFS":

                    List<Integer> average = new ArrayList<>();
                    for (int i = 0; i < 12; i++) {
                        TreeSearch dfs = new DFS();
                        output = dfs.solveProblem(problem);
                        average.add(dfs.getNodes());
                    }


                    Collections.sort(average);
                    double median;
                    if (average.size() % 2 == 0)
                        median = ((double) average.get(average.size() / 2) + (double) average.get(average.size() / 2 - 1)) / 2;
                    else
                        median = (double) average.get(average.size() / 2);

                    print("Median: " + String.valueOf(median));
                    /*
                    TreeSearch dfs = new DFS();
                    output = dfs.solveProblem(problem);
                    print(String.valueOf(dfs.getNodes()));
                    */
                    break;
                case "IDS":
                    TreeSearch ids = new IDS();
                    output = ids.solveProblem(problem);


                    break;
                case "AStar":
                    TreeSearch ashs = new AStar();
                    output = ashs.solveProblem(problem);

            }

            print(output);
    }




    private static List<String> problems(){
        List<String> problems = new ArrayList<>();



        problems.add("-----------@ABC-"); //1
        problems.add("----------@-ABC-"); //2
        problems.add("----------C-AB@-"); //3
        problems.add("---------@--ABC-"); //4
        problems.add("---------B--A@C-"); //5
        problems.add("--------@B---AC-"); //6
        problems.add("--------B@---AC-"); //7
        problems.add("--------BA---@C-"); //8
        problems.add("--------BA---C@-"); //9
        problems.add("--------BA@--C--"); //10
        problems.add("------@-BA---C--"); //11
        problems.add("-----@--BA---C--");  //12
        problems.add("-----A--B@---C--"); //13
        problems.add("-----A--@B---C--"); //14

        /*
        problems.add("------------AB@C"); //1
        problems.add("------------A@BC"); //2
        problems.add("----------C-AB@-"); //3
        problems.add("----------C-A@B-"); //4
        problems.add("----------B-A-@C"); //5
        problems.add("---------C@-A-B-"); //6
        problems.add("--------A---BC@-"); //7
        problems.add("--------BA---@C-"); //8
        problems.add("--------BA---C@-"); //9
        problems.add("--------AB---@-C"); //10
        problems.add("----------C@-A-B"); //11
        problems.add("--------BC--A@--");  //12
        problems.add("--------B@--CA--"); //13
        problems.add("--------AC@B----"); //14
        problems.add("----A---@C---B--"); //15
*/
        return problems;

    }

}

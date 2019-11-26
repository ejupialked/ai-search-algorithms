import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import TreeSearchAlgorithm.*;

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

        List<String> problems = new ArrayList<>();


        problems.add("-----------@ABC-");
        problems.add("----------@-ABC-");
        problems.add("---------@--ABC-");
        problems.add("---------B--A@C-");
        problems.add("---------B--@AC-");
        problems.add("--------@B---AC-");
        problems.add("--------B@---AC-");
        problems.add("--------BA---@C-");
        problems.add("--------BA---C@-");
        problems.add("--------BA@--C--");
        problems.add("------@-BA---C--");
        problems.add("-----@--BA---C--");
        problems.add("-----A--B@---C--");
        problems.add("-----A--@B---C--");


        Point a = new Point(3,0);
        Point b = new Point(3,1);
        Point c = new Point(3,2);
        Point agent = new Point(3,3);

        Point aGoal = new Point(1,1);
        Point bGoal = new Point(2,1);
        Point cGoal = new Point(3,1);
        Point agentGoal = new Point(2,0);


        BlocksWorldTileProblem problem1 = new BlocksWorldTileProblem(a, b, c, agent, aGoal, bGoal, cGoal, agentGoal);



         print("INITIAL STATE");
        print(problem1.startState().ascii());

       print("GOAL STATE");
         print(drawGridCells(convert2DCellsTo1DCells(problem1.getGoalBoard().getCells()),
                 problem1.getGoalBoard().getN()));



        if(args.length != 0){
            String algorithm = args[0];
            int i = 1;

            print("I'm solving the puzzle with "+ algorithm + "...");
            print(" ");

            problem1.setGoal("------------A@BC");
            Utils.DEBUG.setDEBUGGER(ON);
            solvePuzzle(problem1, algorithm);


           /* for(String problem: problems) {

                print( " ");
                print( " ");

                print( " ");

                print("Solving problem " + i++ + ": " + problem);
                problem1.setGoal(problem);
                solvePuzzle(problem1, algorithm);
            }

*/
        }
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
                    /*
                    List<Integer> average = new ArrayList<>();
                    for (int i = 0; i < 25 ; i++) {
                        TreeSearch dfs = new DFS();
                        output = dfs.solveProblem(problem);
                        average.add(dfs.getNodes());
                    }


                    Collections.sort(average);
                    double median;
                    if (average.size() % 2 == 0)
                        median = ((double)average.get(average.size()/2)+ (double) average.get(average.size()/2 - 1)) / 2;
                    else
                        median = (double) average.get(average.size()/2);

                    print(String.valueOf(median));*/

                    TreeSearch dfs = new DFS();
                    output = dfs.solveProblem(problem);
                    print(String.valueOf(dfs.getNodes()));
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

}

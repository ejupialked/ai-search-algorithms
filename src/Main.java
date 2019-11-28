import Problem.BlocksWorldTileProblem;
import Problem.Problem;
import TreeSearchAlgorithm.*;
import Utils.Debug;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Utils.Debug.*;
import static Utils.Utils.*;

/**
 * Run the algorithms here.
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 */
public class Main {



    public static void main(String[] args){

        Point a = new Point(3,0);
        Point b = new Point(3,1);
        Point c = new Point(3,2);
        Point agent = new Point(3,3);

        Point aGoal = new Point(1,1);
        Point bGoal = new Point(2,1);
        Point cGoal = new Point(3,1);
        Point agentGoal = new Point(2,0);

      /*  Point aGoal = new Point(1,0);
        Point bGoal = new Point(2,1);
        Point cGoal = new Point(3,2);
        Point agentGoal = new Point(2,0);*/



        BlocksWorldTileProblem problem1 = new BlocksWorldTileProblem(a, b, c, agent, aGoal, bGoal, cGoal, agentGoal);


        int i = 1;

        for (BlocksWorldTileProblem p:problems()) {
            println("p: "+ i++);
            println(p.getGoalConfiguration());
            println(p.startState().getBoard().getASCIIString());
        }


        String algorithm = args[0];

        Debug.setDEBUGGER(OFF);

        //  solveUserProblem(problem1,algorithm);
         solveDifferentPuzzle(problems(), algorithm);



    }



    private static void solveDifferentPuzzle(List<BlocksWorldTileProblem> problems, String algorithm) {
        int i = 1;
        for (BlocksWorldTileProblem problem: problems) {
            if(i > 0) {
                println(" ");
                println("I'm solving the puzzle with " + algorithm + "...");
                println("Problem: " + i++);
               // printStartAndGoal(problem);
                solvePuzzle(problem, algorithm);
            }else
                i++;
        }
    }

    private static void solveUserProblem(BlocksWorldTileProblem problem, String algorithm) {
        printStartAndGoal(problem);
        println("I'm solving the puzzle with "+ algorithm + "...");
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
                    for (int i = 0; i < 20; i++) {
                        TreeSearch dfs = new DFS();
                        output = dfs.solveProblem(problem);
                        average.add(dfs.getNodesGenerated());
                    }


                    Collections.sort(average);
                    double median;
                    if (average.size() % 2 == 0)
                        median = ((double) average.get(average.size() / 2) + (double) average.get(average.size() / 2 - 1)) / 2;
                    else
                        median = (double) average.get(average.size() / 2);

                    print("Median: " + String.valueOf(median));
                    TreeSearch dfs = new DFS();
                    output = dfs.solveProblem(problem);
                    println(String.valueOf(dfs.getNodesGenerated()));

                    break;
                case "IDS":
                    TreeSearch ids = new IDS();
                    output = ids.solveProblem(problem);


                    break;
                case "AStar":
                    TreeSearch ashs = new AStar();
                    output = ashs.solveProblem(problem);

            }

            println(output);
    }




    private static List<BlocksWorldTileProblem> problems(){
        List<BlocksWorldTileProblem> problems = new ArrayList<>();

        String start = "------------ABC@";

        problems.add(new BlocksWorldTileProblem(start,"------------AB@C"));
        problems.add(new BlocksWorldTileProblem(start,"------------A@BC"));
        problems.add(new BlocksWorldTileProblem(start,"----------C-AB@-"));
        problems.add(new BlocksWorldTileProblem(start,"----------C-A@B-"));
        problems.add(new BlocksWorldTileProblem(start,"----------B-A-@C"));
        problems.add(new BlocksWorldTileProblem(start,"---------C@-A-B-"));
        problems.add(new BlocksWorldTileProblem(start,"--------A---BC@-"));
        problems.add(new BlocksWorldTileProblem(start,"--------BA---@C-"));
        problems.add(new BlocksWorldTileProblem(start,"--------BA---C@-"));
        problems.add(new BlocksWorldTileProblem(start,"--------AB---@-C"));
        problems.add(new BlocksWorldTileProblem(start,"----------C@-A-B"));
        problems.add(new BlocksWorldTileProblem(start,"--------BC--A@--"));
        problems.add(new BlocksWorldTileProblem(start,"--------B@--CA--"));
        problems.add(new BlocksWorldTileProblem(start,"--------AC@B----"));
        problems.add(new BlocksWorldTileProblem(start,"----A---@C---B--"));



        return problems;

    }

}

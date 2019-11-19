package TreeSearchAlgorithm;

import Puzzle.Board;

public interface Heuristic {


    /**
     * Path cost from start node to {@code n}
     */
    int g();

    /**
     * estimated cost of the cheapest path from {@code n} to goal
     */
    int h(Board goal);

    /**
     *  estimated cost of the cheapest solution through {@code n}
     */
    int f(int g, int h);
}

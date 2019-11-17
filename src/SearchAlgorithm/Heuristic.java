package SearchAlgorithm;

import Puzzle.State;

public interface Heuristic {


    /**
     * Path cost from start node to {@code n}
     */
    int g();

    /**
     * estimated cost of the cheapest path from {@code n} to goal
     */
    int h(State goal);

    /**
     *  estimated cost of the cheapest solution through {@code n}
     */
    int f(int g, int h);
}

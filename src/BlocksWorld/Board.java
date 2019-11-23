package BlocksWorld;

import Utils.Utils;

import java.awt.*;

import static Utils.Utils.*;

/**
 * Represents a board containing NxN cells.
 * It remembers the position of tiles a, b, c and the agent.
 *
 * the {@code configuration} attribute represents the
 * arrangements of tiles and agent as a single {@code String}
 *
 * @author Alked Ejupi Copyright (2019). All rights reserved.
 *
 *
 */
public class Board {

    int N;

    private Cell[][] gridCells;
    private String configuration;

    Cell a, b, c, agent;

    public Board(int N, Cell[][] gridCells) {
        this.N = N;
        this.gridCells = gridCells;
        this.configuration = convert1DCellsToString(convert2DCellsTo1DCells(gridCells));
    }


    public void computeConfiguration(){
        this.configuration = convert1DCellsToString(convert2DCellsTo1DCells(getGridCells()));
    }


    public String getConfiguration() {
        return configuration;
    }

    public Cell[][] getGridCells() {
        return gridCells;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Board){
            return toString().equals(obj);
        }
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return configuration;
    }

    @Override
    public int hashCode() {
        return configuration.hashCode();
    }

    public int getN() {
        return N;
    }


    public String asciiCells(){
        return Utils.drawGridCells(Utils.convert2DCellsTo1DCells(getGridCells()), getN());
    }

    public void setA(Cell a) {
        this.a = a;
    }

    public void setB(Cell b) {
        this.b = b;
    }

    public void setC(Cell c) {
        this.c = c;
    }

    public void setAgent(Cell agent) {
        this.agent = agent;
    }

    public Cell getA() {
        return a;
    }

    public Cell getB() {
        return b;
    }

    public Cell getC() {
        return c;
    }

    public Cell getAgent() {
        return agent;
    }

}

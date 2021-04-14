package com.prdcv.study.chess.board.dto;

/**
 * Specify a Position on the Chess Board
 */
public class Position implements Cloneable<Position>, Comparable<Position> {

    @Override
    public Position cloneObj() {
        return null;
    }

    @Override
    public int hashCode() {
        // TODO: Generate Hash Code from File + Rank
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        // TODO: Compare File and Rank
        if (!(obj instanceof Position)) return false;
        return this.compareTo((Position)obj) == 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.cloneObj();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public int compareTo(Position o) {
        // TODO: Compare File and Rank
        return 0;
    }
}

package com.prdcv.study.chess.board.dto;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void cloneObj_nonNullAndNonSame() {
        Position p = new Position();
        Position cloneObj = p.cloneObj();
        assertNotNull(p.cloneObj());
        assertNotSame( cloneObj, p );
    }

    @Test
    public void equals_nullObject_false() {
        Position p = new Position();
        assertFalse( p.equals(null));
    }

    @Test
    public void equals_nonPositionObject_false() {
        Position p = new Position();
        assertFalse( p.equals("XXX"));
    }

    @Test
    public void equals_noMatchFile_false() {
    }

    @Test
    public void equals_noMatchRank_false() {
    }


}
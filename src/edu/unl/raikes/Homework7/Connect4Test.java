package edu.unl.raikes.homework7;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Handles all testing for the Connect4.java class.
 *
 */
public class Connect4Test {

    @Test
    public void testEhhhh() {
        // Setup

        BoardState[][] board = new BoardState[6][6];
        board[3][2] = BoardState.USER;
        board[5][5] = BoardState.COMPUTER;
        
        Connect4.printBoard(board);
        
        // Execute
        // Test
    }

}

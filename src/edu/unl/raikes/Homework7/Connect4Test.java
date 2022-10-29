package edu.unl.raikes.homework7;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Handles all testing for the Connect4.java class.
 *
 */
public class Connect4Test {

    @Test
    public void testBoardPrint() {

        BoardState[][] board = new BoardState[6][6];
        
        Connect4.printBoard(board);
        
    }
    
    // These tests handle all testing for the method playAPiece
    @Test
    public void testPlayAPieceUserHappyPath() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        final int COLUMN_PLACE = 3;
        final int ROW_PLACE = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        BoardState player = BoardState.USER;
        
        // Execute
        
        Connect4.playAPiece(board, COLUMN_PLACE, player);
        
        // Test
        
        assertEquals("Expected a user piece at row 5, and column 3, but the "
                + "piece was not placed correctly", player, board[ROW_PLACE][COLUMN_PLACE]);
        
    }

    @Test
    public void testPlayAPieceComputerHappyPath() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        final int COLUMN_PLACE = 4;
        final int ROW_PLACE = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        BoardState player = BoardState.COMPUTER;
        
        // Execute
        
        Connect4.playAPiece(board, COLUMN_PLACE, player);
        
        // Test
        
        assertEquals("Expected a computer piece at row 5, and column 4, but the "
                + "piece was not placed correctly", player, board[ROW_PLACE][COLUMN_PLACE]);
        
    }

    @Test
    public void testPlayAPieceLeftEdgeCase() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        final int COLUMN_PLACE = 0;
        final int ROW_PLACE = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        BoardState player = BoardState.USER;
        
        // Execute
        
        Connect4.playAPiece(board, COLUMN_PLACE, player);
        
        // Test
        
        assertEquals("Expected a piece at row 5, and column 0, but the "
                + "piece was not placed correctly", player, board[ROW_PLACE][COLUMN_PLACE]);
        
    }

    @Test
    public void testPlayAPieceRightEdgeCase() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        final int COLUMN_PLACE = 0;
        final int ROW_PLACE = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        BoardState player = BoardState.USER;
        
        // Execute
        
        Connect4.playAPiece(board, COLUMN_PLACE, player);
        
        // Test
        
        assertEquals("Expected a piece at row 5, and column 0, but the "
                + "piece was not placed correctly", player, board[ROW_PLACE][COLUMN_PLACE]);
        
    }

    @Test
    public void testPlayAPieceOnTopAnother() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        final int COLUMN_PLACE = 2;
        final int ROW_PLACE = 4;
        
        final int ROW_SIX = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        BoardState player = BoardState.USER;
        board[ROW_SIX][COLUMN_PLACE] = player;
        
        // Execute
        
        Connect4.playAPiece(board, COLUMN_PLACE, player);
        
        // Test
        
        assertEquals("Expected a piece at row 4, and column 2, but the "
                + "piece was not placed correctly", player, board[ROW_PLACE][COLUMN_PLACE]);
        
    }

    @Test
    public void testPlayAPieceOnTopTwoOthers() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        final int COLUMN_PLACE = 0;
        final int ROW_PLACE = 3;
        
        final int ROW_SIX = 5;
        final int ROW_FIVE = 4;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        BoardState player = BoardState.USER;
        board[ROW_FIVE][COLUMN_PLACE] = player;
        board[ROW_SIX][COLUMN_PLACE] = player;
        
        // Execute
        
        Connect4.playAPiece(board, COLUMN_PLACE, player);
        
        // Test
        
        assertEquals("Expected a piece at row 3, and column 0, but the "
                + "piece was not placed correctly", player, board[ROW_PLACE][COLUMN_PLACE]);
        
    }

    @Test
    public void testPlayAPieceFullColumn() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        final int COLUMN_PLACE = 0;
        
        final int ROW_ONE = 0;
        final int ROW_TWO = 1;
        final int ROW_THREE = 2;
        final int ROW_FOUR = 3;
        final int ROW_FIVE = 4;
        final int ROW_SIX = 5;
        
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        BoardState player = BoardState.USER;
        board[ROW_ONE][COLUMN_PLACE] = player;
        board[ROW_TWO][COLUMN_PLACE] = player;
        board[ROW_THREE][COLUMN_PLACE] = player;
        board[ROW_FOUR][COLUMN_PLACE] = player;
        board[ROW_FIVE][COLUMN_PLACE] = player;
        board[ROW_SIX][COLUMN_PLACE] = player;
        
        boolean expectedPlace = false;
        
        // Execute
        
        boolean actualPlace = Connect4.playAPiece(board, COLUMN_PLACE, player);
        
        // Test
        
        assertEquals("Expected to not be able to place a piece, but the method returned true.", 
                expectedPlace, actualPlace);
        
    }




}

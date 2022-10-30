package edu.unl.raikes.homework7;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Handles all testing for the Connect4.java class.
 *
 */
public class Connect4Test {
    
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


    // These tests handle all testing for the method checkBoardForWinner
    
    @Test
    public void testCheckBoardForWinnerHorizontalWinBLCorner() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        
        final int TOKEN_ONE = 0; // Represents either a column or a row at index 0
        final int TOKEN_TWO = 1;
        final int TOKEN_THREE = 2;
        final int TOKEN_FOUR = 3;
        final int TOKEN_FIVE = 4;
        final int TOKEN_SIX = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        board[TOKEN_SIX][TOKEN_ONE] = BoardState.COMPUTER;
        board[TOKEN_SIX][TOKEN_TWO] = BoardState.COMPUTER;
        board[TOKEN_SIX][TOKEN_THREE] = BoardState.COMPUTER;
        board[TOKEN_SIX][TOKEN_FOUR] = BoardState.COMPUTER;
        boolean expectWin = true;
        
        // Execute
        
        boolean actualWin = Connect4.checkBoardForWinner(board, BoardState.COMPUTER);
        
        // Test
        assertEquals("Expected a win with a horizontal connect 4 on the bottom left corner, "
                + "but no win was detected", expectWin, actualWin);
        
    }
    
    @Test
    public void testCheckBoardForWinnerVerticalWinBLCorner() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        
        final int TOKEN_ONE = 0; // Represents either a column or a row at index 0
        final int TOKEN_TWO = 1;
        final int TOKEN_THREE = 2;
        final int TOKEN_FOUR = 3;
        final int TOKEN_FIVE = 4;
        final int TOKEN_SIX = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        board[TOKEN_SIX][TOKEN_ONE] = BoardState.COMPUTER;
        board[TOKEN_FIVE][TOKEN_ONE] = BoardState.COMPUTER;
        board[TOKEN_FOUR][TOKEN_ONE] = BoardState.COMPUTER;
        board[TOKEN_THREE][TOKEN_ONE] = BoardState.COMPUTER;
        boolean expectWin = true;
        
        // Execute
        
        boolean actualWin = Connect4.checkBoardForWinner(board, BoardState.COMPUTER);
        
        // Test
        assertEquals("Expected a win with a vertical connect 4 on the bottom left corner, "
                + "but no win was detected", expectWin, actualWin);
        
    }

    @Test
    public void testCheckBoardForWinnerHorizontalWinTRCorner() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        
        final int TOKEN_ONE = 0; // Represents either a column or a row at index 0
        final int TOKEN_TWO = 1;
        final int TOKEN_THREE = 2;
        final int TOKEN_FOUR = 3;
        final int TOKEN_FIVE = 4;
        final int TOKEN_SIX = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        board[TOKEN_ONE][TOKEN_SIX] = BoardState.COMPUTER;
        board[TOKEN_ONE][TOKEN_FIVE] = BoardState.COMPUTER;
        board[TOKEN_ONE][TOKEN_FOUR] = BoardState.COMPUTER;
        board[TOKEN_ONE][TOKEN_THREE] = BoardState.COMPUTER;
        boolean expectWin = true;
        
        // Execute
        
        boolean actualWin = Connect4.checkBoardForWinner(board, BoardState.COMPUTER);
        
        // Test
        assertEquals("Expected a win with a horizontal connect 4 on the top right corner, "
                + "but no win was detected", expectWin, actualWin);
        
    }

    @Test
    public void testCheckBoardForWinnerVerticalWinTRCorner() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        
        final int TOKEN_ONE = 0; // Represents either a column or a row at index 0
        final int TOKEN_TWO = 1;
        final int TOKEN_THREE = 2;
        final int TOKEN_FOUR = 3;
        final int TOKEN_FIVE = 4;
        final int TOKEN_SIX = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        board[TOKEN_ONE][TOKEN_SIX] = BoardState.COMPUTER;
        board[TOKEN_TWO][TOKEN_SIX] = BoardState.COMPUTER;
        board[TOKEN_THREE][TOKEN_SIX] = BoardState.COMPUTER;
        board[TOKEN_FOUR][TOKEN_SIX] = BoardState.COMPUTER;
        boolean expectWin = true;
        
        // Execute
        
        boolean actualWin = Connect4.checkBoardForWinner(board, BoardState.COMPUTER);
        
        // Test
        assertEquals("Expected a win with a vertical connect 4 on the top right corner, "
                + "but no win was detected", expectWin, actualWin);
        
    }
    
    @Test
    public void testCheckBoardForWinnerHorizontalWinMiddle() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        
        final int TOKEN_ONE = 0; // Represents either a column or a row at index 0
        final int TOKEN_TWO = 1;
        final int TOKEN_THREE = 2;
        final int TOKEN_FOUR = 3;
        final int TOKEN_FIVE = 4;
        final int TOKEN_SIX = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        board[TOKEN_THREE][TOKEN_THREE] = BoardState.COMPUTER;
        board[TOKEN_THREE][TOKEN_FOUR] = BoardState.COMPUTER;
        board[TOKEN_THREE][TOKEN_FIVE] = BoardState.COMPUTER;
        board[TOKEN_THREE][TOKEN_SIX] = BoardState.COMPUTER;
        boolean expectWin = true;
        
        // Execute
        
        boolean actualWin = Connect4.checkBoardForWinner(board, BoardState.COMPUTER);
        
        // Test
        assertEquals("Expected a win with a horizontal connect 4 in the middle of the board, "
                + "but no win was detected", expectWin, actualWin);
        
    }
    
    @Test
    public void testCheckBoardForWinnerVerticalWinMiddle() {
        
        // Setup
        
        final int BOARD_SIZE = 6;
        
        final int TOKEN_ONE = 0; // Represents either a column or a row at index 0
        final int TOKEN_TWO = 1;
        final int TOKEN_THREE = 2;
        final int TOKEN_FOUR = 3;
        final int TOKEN_FIVE = 4;
        final int TOKEN_SIX = 5;
        
        BoardState[][] board = Connect4.initializeBoard(BOARD_SIZE);
        board[TOKEN_TWO][TOKEN_THREE] = BoardState.COMPUTER;
        board[TOKEN_THREE][TOKEN_THREE] = BoardState.COMPUTER;
        board[TOKEN_FOUR][TOKEN_THREE] = BoardState.COMPUTER;
        board[TOKEN_FIVE][TOKEN_THREE] = BoardState.COMPUTER;
        boolean expectWin = true;
        
        // Execute
        
        boolean actualWin = Connect4.checkBoardForWinner(board, BoardState.COMPUTER);
        
        // Test
        assertEquals("Expected a win with a vertical connect 4 in the middle of the board, "
                + "but no win was detected", expectWin, actualWin);
        
    }

    @Test
    public void testCheckBoardForWinnerNoWinner() {
        
        // Setup

        BoardState computer = BoardState.COMPUTER;
        BoardState player = BoardState.USER;
        
        BoardState[] boardLine1 = {computer, computer, computer, player, computer, player};
        BoardState[] boardLine2 = {computer, player, player, player, computer, player};
        BoardState[] boardLine3 = {player, player, player, computer, player, player};
        BoardState[] boardLine4 = {player, player, computer, computer, player, computer};
        BoardState[] boardLine5 = {player, computer, computer, computer, player, computer};
        BoardState[] boardLine6 = {computer, computer, computer, player, computer, computer};
        BoardState[][] board = {boardLine1, boardLine2, boardLine3, boardLine4, boardLine5, boardLine6};
        
        boolean expectWin = false;
        
        // Execute
        
        boolean actualWin = Connect4.checkBoardForWinner(board, BoardState.COMPUTER);
        
        // Test
        assertEquals("Expected no win, but a win was detected", expectWin, actualWin);
        
    }

}

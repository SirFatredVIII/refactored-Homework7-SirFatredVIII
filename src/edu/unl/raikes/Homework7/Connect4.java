package edu.unl.raikes.Homework7;

/**
 * Contains the logic for the game Connect 4.
 * 
 * @author Stephanie Valentine
 */
public class Connect4 {
    
    /**
     * A value representing the board's columns or the board's rows (it's a square board).
     */
    public static final int BOARD_SIZE = 6;
    
    /**
     * Initializes and returns a new gameboard with all cells set as EMPTY.
     * 
     * @return a new gameboard with all cells set as EMPTY.
     */
    public static BoardState[][] initializeBoard() {
        // TODO: YOUR LOGIC HERE
        return null;
    }

    /**
     * Plays a piece in a given column. Returns true if successfully played, false
     * if column is already full.
     * 
     * @param board
     *            the board on which to make the play
     * @param column
     *            the column in which to add the piece
     * @param state
     *            the player whose piece is being added
     * @return true if successfully able to play a piece, false otherwise
     */
    public static boolean playAPiece(BoardState[][] board, int column, BoardState state) {
        // TODO: YOUR LOGIC HERE
        return false;
    }

    /**
     * Returns the column in which the computer will choose to play its next piece.
     * 
     * @param board
     *            the board on which the computer will play its next piece.
     * @return
     */
    public static int getComputerColumnChoice(BoardState[][] board) {
        // TODO: YOUR LOGIC HERE
        return 0;
    }

    /**
     * Checks whether the board is in a win state (4 in a row either horizontally or
     * vertically) for that particular player.
     * 
     * @param board
     *            the board in which to check the state
     * @param player
     *            the player who just made a play
     * @return true if the user has four in a row, false otherwise
     */
    public static boolean checkBoardForWinner(BoardState[][] board, BoardState player) {
        // TODO: YOUR LOGIC HERE
        return false;
    }

    /**
     * Prints a gameboard to the console.
     * 
     * @param board
     *            the board to print.
     */
    public static void printBoard(BoardState[][] board) {
        // TODO: YOUR LOGIC HERE
    }

    /**
     * Controls gameplay and logic.
     */
    public static void main(String[] args) {
        // TODO: YOUR LOGIC HERE
    }
}
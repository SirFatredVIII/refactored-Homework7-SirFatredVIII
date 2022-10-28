package edu.unl.raikes.homework7;

import java.util.Arrays;

/**
 * Contains the logic for the game Connect 4.
 * 
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

        final BoardState EMPTY = BoardState.EMPTY; // Represents an empty board piece
        BoardState[][] gameBoard = new BoardState[BOARD_SIZE][BOARD_SIZE]; 
        // This is a truly empty board filled with null.

        // This for loop fills each row and column up with empty spots.
        for (int currentRow = 0; currentRow < BOARD_SIZE; currentRow++) {
            Arrays.fill(gameBoard[currentRow], EMPTY);
        }

        return gameBoard;
    }

    /**
     * Plays a piece in a given column. Returns true if successfully played, false if column is already full.
     * 
     * @param board the board on which to make the play
     * @param column the column in which to add the piece
     * @param state the player whose piece is being added
     * @return true if successfully able to play a piece, false otherwise
     */
    public static boolean playAPiece(BoardState[][] board, int column, BoardState state) {
        // TODO: YOUR LOGIC HERE
        return false;
    }

    /**
     * Returns the column in which the computer will choose to play its next piece.
     * 
     * @param board the board on which the computer will play its next piece.
     * @return
     */
    public static int getComputerColumnChoice(BoardState[][] board) {
        // TODO: YOUR LOGIC HERE
        return 0;
    }

    /**
     * Checks whether the board is in a win state (4 in a row either horizontally or vertically) for that particular
     * player.
     * 
     * @param board the board in which to check the state
     * @param player the player who just made a play
     * @return true if the user has four in a row, false otherwise
     */
    public static boolean checkBoardForWinner(BoardState[][] board, BoardState player) {
        // TODO: YOUR LOGIC HERE
        return false;
    }

    /**
     * Prints a gameboard to the console.
     * 
     * @param board the board to print.
     */
    public static void printBoard(BoardState[][] board) {

        
        
    }
    
    /**
     * Prints the game board's main body of tokens.
     * 
     * @param board the board to print a body of tokens from.
     */
    public static void printBoardBody(BoardState[][] board) {
        
        for (int currentRow = 0; currentRow < board.length; currentRow++) {
            
            final char VERT_BORDER = '|';
            
            char nextToken; // Finds the next token to print on the board
            String margin = determineBodyMargin(); // Finds the appropriately sized margin.
            
            System.out.print(VERT_BORDER + margin);
            
            for (int currentCol = 0; currentCol < board[currentRow].length; currentCol++) {
                
                // This determines the next type of token to place on the board (player, computer, or empty)
                nextToken = determinePlayer(board, currentRow, currentCol);
                System.out.print(nextToken + margin);
                
            }
            
            System.out.println(VERT_BORDER);
            
        }
        
    }
    
    /**
     * Finds the current enum of the game board, and returns a char representation of the player's token.
     * 
     * @param board The game board.
     * @return a char representation of the character's piece.
     */
    public static char determinePlayer(BoardState[][] board, int row, int col) {
        final BoardState USER = BoardState.USER; // Enum representation of a user token.
        final char USER_TOKEN = '+'; // Char representation of a user token.
        
        final BoardState COMPUTER = BoardState.COMPUTER; // Enum representation of a computer token.
        final char COM_TOKEN = 'X'; // Char representation of a computer token.

        // Enum not necessary due to fall-through if-else statement. (If the piece isn't a user or computer, it's empty)
        final char EMPTY_TOKEN = 'O'; // Char representation of an empty token.
        
        if (board[row][col] == USER) {
            return USER_TOKEN;
            
        } else if (board[row][col] == COMPUTER) {
            return COM_TOKEN;
            
        }
        
        return EMPTY_TOKEN;
        
    }
    
    /**
     * Given the board's size (the field above the methods), finds the appropriate margin for tokens in the body.
     * 
     * @return the appropriately-sized margin.
     */
    public static String determineBodyMargin() {
        
        final int START_PLACE = 10;
        final String START_MARGIN = " ";
        
        String margin = START_MARGIN; // Increases until the end is found.
        int place = START_PLACE; // Increases to the next size place (10s, 100s) until the end is found.
        int exponent = 1; // Grows to continue searching for number places.
        
        while (BOARD_SIZE >= place) {
            exponent++;
            margin += START_MARGIN;
            place = (int) Math.pow(START_PLACE, exponent);
        }
        
        return margin;
        
    }

    /**
     * Controls gameplay and logic.
     */
    public static void main(String[] args) {
        // TODO: YOUR LOGIC HERE
    }
    
    
    
    
    
}

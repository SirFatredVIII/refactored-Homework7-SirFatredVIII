package edu.unl.raikes.homework7;

import java.util.Arrays;
import java.util.Random;

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
    public static BoardState[][] initializeBoard(int boardSize) {

        final BoardState EMPTY = BoardState.EMPTY; // Represents an empty board piece
        BoardState[][] gameBoard = new BoardState[boardSize][boardSize]; 
        // This is an empty board filled with null.

        // This for loop fills each row and column up with empty spots.
        for (int currentRow = 0; currentRow < boardSize; currentRow++) {
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
        
        // This for loop checks for the first empty column, and places a piece there.
        for (int currentRow = board.length - 1; currentRow >= 0; currentRow--) {
            
            if (board[currentRow][column] == BoardState.EMPTY) {
                board[currentRow][column] = state;
                return true;
            }
        }
        
        return false;
    }

    /**
     * Returns the column in which the computer will choose to play its next piece.
     * 
     * @param board the board on which the computer will play its next piece.
     * @return the index of the column to play on
     */
    public static int getComputerColumnChoice(BoardState[][] board) {

        Random random = new Random();
        
        int computerChoice = random.nextInt(BOARD_SIZE); // Gets a random number between 0 and board's length
        
        return computerChoice;
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

        for (int currentRow = 0; currentRow < board.length; currentRow++) {
            if (checkBoardForHorizontalWins(board, player, currentRow)) {
                return true;
            }
        }
        
        for (int currentCol = 0; currentCol < board.length; currentCol++) {
            if (checkBoardForVerticalWins(board, player, currentCol)) {
                return true;
            }
        }
        
        return false;
    }

    /**
     * Checks the current row of the board to see if there are any horizontal wins.
     * 
     * @param board the board in which to check the state
     * @param player the player who just made a play
     * @param row the current row of the board checks
     * @return true if the user has four in a row, false otherwise
     */
    public static boolean checkBoardForHorizontalWins(BoardState[][] board, BoardState player, int row) {
        
        final int TOKENS_NEEDED = 4; // The total tokens needed to win
        
        // This for loop looks for any of the player's tokens in the row
        for (int currentCol = 0; currentCol < board.length; currentCol++) {
            
            int totalTokensFound = 0; // This keeps track of how many of the player's tokens were in a row
            
            // If a player's token is found, it enters this if statement
            if (board[row][currentCol] == player) {
                
                totalTokensFound++; // A player token was found
                
                // This for loop loops ahead for up to three spaces ahead of the player's token found
                for (int subsequentCol = 1; subsequentCol <= TOKENS_NEEDED - 1; subsequentCol++) {
                    
                    // If accessing the index ahead would result in an index error, it breaks this loop.
                    if (subsequentCol + currentCol >= board.length) {
                        return false;
                    }
                    
                    // Increments total tokens found if another token is found to the right
                    if (board[row][currentCol + subsequentCol] == player) {
                        totalTokensFound++; 
                        
                    }
                }
            }
            
            // If four are found in a row, this lets the game know that the player won!
            if (totalTokensFound == TOKENS_NEEDED) {
                return true;
            }
            
        }
        return false;
    }
    
    /**
     * Checks the current column of the board to see if there are any vertical wins.
     * 
     * @param board the board in which to check the state
     * @param player the player who just made a play
     * @param col the current column of the board checks
     * @return true if the user has four in a row, false otherwise
     */
    public static boolean checkBoardForVerticalWins(BoardState[][] board, BoardState player, int col) {
        
        final int TOKENS_NEEDED = 4; // The total tokens needed to win
        
        // This for loop looks for any of the player's tokens in the column
        for (int currentRow = 0; currentRow < board.length; currentRow++) {
            
            int totalTokensFound = 0; // This keeps track of how many of the player's tokens were in a row
            
            // If a player's token is found, it enters this if statement
            if (board[currentRow][col] == player) {
                
                totalTokensFound++; // A player token was found
                
                // This for loop loops ahead for up to three spaces ahead of the player's token found
                for (int subsequentRow = 1; subsequentRow <= TOKENS_NEEDED - 1; subsequentRow++) {
                    
                    // If accessing the index ahead would result in an index error, it breaks this loop.
                    if (subsequentRow + currentRow >= board.length) {
                        return false;
                        
                    }
                    
                    // Increments total tokens found if another token is found below
                    if (board[currentRow + subsequentRow][col] == player) {
                        totalTokensFound++; 
                        
                    }
                    
                }
                
            }
            
            // If four are found in a row, this lets the game know that the player won!
            if (totalTokensFound == TOKENS_NEEDED) {
                return true;
            }
            
        }
        
        return false;
        
    }
    
    
    /**
     * Prints a gameboard to the console.
     * 
     * @param board the board to print.
     */
    public static void printBoard(BoardState[][] board) {

        printBoardBody(board);
        printBoardEnd(board);
        
    }
    
    /**
     * Prints the game board's main body of tokens.
     * 
     * @param board the board to print a body of tokens from.
     */
    public static void printBoardBody(BoardState[][] board) {
        
        for (int currentRow = 0; currentRow < board.length; currentRow++) {
            
            final char VERT_BORDER = '|'; // Starts the wall on each row
            
            char nextToken; // Finds the next token to print on the board
            String margin = determineBodyMargin(); // Finds the appropriately sized margin.
            
            System.out.print(VERT_BORDER + margin);
            
            for (int currentCol = 0; currentCol < board[currentRow].length; currentCol++) {
                
                // This determines the next type of token to place on the board (player, computer, or empty)
                nextToken = determinePlayer(board, currentRow, currentCol);
                System.out.print(nextToken + margin);
                
            }
            
            System.out.println(VERT_BORDER); // Finishes the wall after each row
            
        }
        
    }
    
    /**
     * Prints the game board's final line of numbers.
     * 
     * @param board the board from which to print the final line.
     */
    public static void printBoardEnd(BoardState[][] board) {
        
        final char DASH = '-'; // Begins and ends the last line
        String margin = ""; // Found at the start of every 
        margin = determineBodyMargin();
        
        System.out.print(DASH + margin); // Beginning dash at the start of the line
        
        for (int currentCol = 1; currentCol <= BOARD_SIZE; currentCol++) {
            
            margin = determineEndMargin(currentCol); // Finds the margin of each number
            System.out.print(currentCol + margin); 
            
        }
        
        System.out.print(DASH); // Ending dash at the end of the line
        
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
     * Given the board's size (the field above the methods), finds the appropriate margin for numbers at the bottom.
     * 
     * @return the appropriately-sized margin
     */
    public static String determineEndMargin(int currentCol) {
        
        final int START_PLACE = 10; // The starting place, finds digits between 1-9.
        final String START_MARGIN = " "; // The starting margin, which prints adequate margins between 1-9 columns.
        
        boolean isMoreThanOneDigit = false; // Used to determine if a number should get different margins if it is large
        
        int place = START_PLACE; // Increases to the next size place (10s, 100s) until the end is found.
        int exponent = 0; // Grows to continue searching for number places, and is used to shrink margin size.
        
        String margin = determineBodyMargin(); // Finds the starting margin
        int marginSize = margin.length(); // Finds the size of the starting margin.
        
        // This determines how many places currentCol has.
        while (currentCol >= place) {
            isMoreThanOneDigit = true; 
            exponent++;
            place = (int) Math.pow(START_PLACE, exponent + 1);
        }
        
        // This if statement is for numbers of currentCol that are bigger than 9.
        if (isMoreThanOneDigit) {
            margin = "";
            
            // This for loop shrinks the margin so that numbers fit within the space they are allotted.
            for (int currentMargin = 0; currentMargin < marginSize - exponent; currentMargin++) {
                margin += START_MARGIN;
            }
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

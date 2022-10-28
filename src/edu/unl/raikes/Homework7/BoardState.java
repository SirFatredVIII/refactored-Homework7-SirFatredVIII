package edu.unl.raikes.Homework7;

/**
 * The possible states of a Connect 4 board.
 * 
 * @author Dr. Stephanie Valentine
 */
public enum BoardState {
    /**
     * Represents the user's token on the Connect 4 board.
     */
    USER,
    /**
     * Represents the computer AI's token on the Connect 4 board.
     */
    COMPUTER,
    /**
     * Represents an empty token on the game board where neither computer nor user has laid a piece.
     */
    EMPTY
}

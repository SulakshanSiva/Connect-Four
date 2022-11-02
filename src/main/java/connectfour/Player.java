package connectfour;

 /**
 * Represent a class for a Player for the Connect 4 game.
 * 2 players will be active in a game of Connect 4.
 */
public class Player {
    // declare and initialize variable for player symbol, name and their turn
    private char playerSymbol;
    private String playerName;
    private boolean playerTurn;
    /**
     * Constructor to create a player
     * 
     * @param pSymbol - For player symbol which will be "R" or "B"
     * @param pName   - For player name
     * @param pTurn   - For player turn, to see if its their turn or not
     */
    public Player(char pSymbol, String pName, boolean pTurn) {
        // set symbol to player symbol
        playerSymbol = pSymbol;
        // set name to player name
        playerName = pName;
        // set turn to player turn
        playerTurn = pTurn;
    }//end constructor
    /*
     * Getter to get player symbol
     * 
     * @return the player symbol
     */
    public char getPlayerSymbol() {
        return playerSymbol;
    }//end getter
    /*
     * Setter to set player symbol
     * 
     * @param symbol - Player symbo as a char: "R" or "B"
     */
    public void setPlayerSymbol(char symbol) {
        playerSymbol = symbol;
    }//end setter
    /*
     * Getter to get player name
     * 
     * @return the player name
     */
    public String getPlayerName() {
        return playerName;
    }//end getter
    /*
     * Setter to set the player name
     * 
     * @param pName - Takes in the player name as a string
     */
    public void setPlayerName(String pName) {
        playerName = pName;
    }//end setter
    /*
     * Getter to get the player turn
     * 
     * @return true if it is the players turn, false otherwise
     */
    public boolean getPlayerTurn() {
        return playerTurn;
    }//end getter
    /*
     * Setter to set the player turn
     * 
     * @param pTurn - Takes in a boolean to see if it is the players turn
     */
    public void setPlayerTurn(boolean pTurn) {
        playerTurn = pTurn;
    }//end setter
    /*
     * Method to convert all player data into a string to be used to display player data 
     * 
     *  @return the string containing the Player object data
     */
    public String toString(){
        return playerName + " is represented by the symbol " + playerSymbol + ". Your Turn: " + playerTurn;
    }//end to String method

}

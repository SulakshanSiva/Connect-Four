package connectfour;

 /*
  * Represent a class that handles all board functionality from creating board, checking for wins 
  * and making player moves on the board
  */
public class Board {
    // declare and initialize variables for the rows of the board and for the game state
    private int[][] rows = new int[6][7];
    private boolean gameEnd = false;
    /*
     * createBoard(): constructor to create the game board
     * 
     * @param gameState - state of game, true if game is done, false if game is ongoing
     */
    public void createBoard(boolean gameState) {
        //declare counter
        int counter = 1;
        //loop through board positions
        for (int i = 0; i < getRows().length; i++) {
            //reset counter
            counter = 1;
            for (int j = 0; j < getRows()[i].length; j++) {
                //initialize board position
                rows[i][j] = counter;
                //add 1 to counter
                counter++;
            }
        }
        //set gamestate
        setGameEnd(gameState);
    }//end createBoard function

    /*
     * makeMove(): makes player Move on the board
     * 
     * @param boardPosition - players desired move
     * @param player - player that is currently playing their turn
     */
    public void makeMove(int boardPosition, Player player){    
        //loop through board position    
        for(int i = getRows().length - 1; i >= 0; i--){
            //if at desired player board position
            if(getRows()[i][boardPosition] == boardPosition + 1){
                //set chip at player desired column
                getRows()[i][boardPosition] = player.getPlayerSymbol();
                break;
            } else {
                continue;
            }
        }//end for
    }//end makeMove function

    /*
     * gameWin(): sets game to end and displays a win message
     * 
     * @param player - player that has just won
     * @param display - textUI object to display message to user
     */
    public void gameWin(Player player, TextUI display){
        setGameEnd(true);
        display.winMessage(player);
    }//end gameWin()

    /*
     * checkRowWin(): checks if player has won by a row condition
     * 
     * @param player - player that is currently having a turn
     * @param display - textUI object to display message to user
     */
    public void checkRowWin(Player player, TextUI display) {
        // declare and initialize variable for win
        boolean win = true;

        int counter = 0;
        //if game has not ended yet
        if (!getGameEnd()){
            //loop through board rows
            for (int i = 0; i < getRows().length; i++) {
                //reset counter
                counter = 0;
                //loop for 4 chips (win condition)
                while(counter < 4){
                    //reset win
                    win = true;
                    //loop through row
                    for (int j = counter; j < (counter + 4) - 1; j++) {
                        //if board chips are not the same
                        if (getRows()[i][j] != getRows()[i][j + 1]) {
                            //player has not won
                            win = false;
                            //exit loop
                            break;
                        }
                    } // end inner for
                    //if player has won
                    if (win) {
                        //end game, display win message
                        gameWin(player, display);
                        break;
                    } else {
                        //add 1 to counter
                        counter++; 
                    }
                }//end while loop
                //if player has won
                if(win){
                    //exit loop
                    break;
                }
            } // end outer for
        }//end if
    }//end checkRowWin function
    
    /*
     * checkColumnWin(): checks if player has won by a column condition
     * 
     * @param player - player that is currently having a turn
     * @param display - textUI object to display message to user
     */
    public void checkColumnWin(Player player, TextUI display) {
        // declare and initialize variable for win
        boolean win = true;

        int counter = 0;
        //if game has not ended yet
        if (!getGameEnd()) {
            //loop through board rows
            for (int i = 0; i < getRows().length; i++) {
                //reset counter
                counter = 0;
                //loop for 4 chips(win condition)
                while (counter < 3) {
                    //reset win state
                    win = true;
                    //loop through columns
                    for (int j = counter; j < (counter + 4) - 1; j++) {
                        //if board chips are not equals
                        //set win to false
                        if (getRows()[j][i] != getRows()[j + 1][i]){
                            win = false;
                            break;
                        } else if(getRows()[j][i] != player.getPlayerSymbol()) {
                            win = false;
                            break;
                        } else if(getRows()[j + 1][i] != player.getPlayerSymbol()){
                            win = false;
                            break;
                        }
                    } // end inner for
                    //if player won
                    if (win) {
                        //end game, display win message
                        gameWin(player, display);
                        //exit loop
                        break;
                    } else {
                        //add 1 to counter
                        counter++;
                    }
                } // end while loop
                //if player has won
                if (win) {
                    //exit loop
                break;
                }
              } // end outer for
          } // end if
    }//end checkColumnWin function

    /*
     * checkLeftDiagonalWin(): checks if player has won by a left to right diagonal condition
     * 
     * @param player - player that is currently having a turn
     * @param display - textUI object to display message to user
     */
    public void checkLeftDiagonalWin(Player player, TextUI display) {
        boolean win = true;
        //if game has not ended yet
        if (!getGameEnd()) {
            //loop through the possible digonals that lead to wins
            for (int i = 3; i < getRows().length; i++) {
                    //loop through 4 diagonals of possible wins
                    for(int col = 0; col < 4; col++){
                        //set counter
                        int counter = col;
                        //loop through rows
                        for(int j = i; j > i - 3; j--){
                            //reset win
                            win = true;
                            //if board chips do not match
                            if(getRows()[j][counter] != getRows()[j - 1][counter + 1]){
                                //player has not won
                                win = false;
                                //exit loop
                                break;
                            }
                            //add 1 to counter
                            counter++;
                        }
                        //if player has won
                        if(win){
                            //exit loop
                            break;
                        }
                    }
                //if player has won
                if (win) {
                    //end game, display win messaage
                    gameWin(player, display);
                    //exit loop
                    break;
                }  
            }//end for
        }
      }//end checkLeftDiagonalWin function

    /*
    * checkRightDiagonalWin(): checks if player has won by a right to left diagonal condition
    * 
    * @param player - player that is currently having a turn
    * @param display - textUI object to display message to user
    */
    public void checkRightDiagonalWin(Player player, TextUI display){
        boolean win = true;
        // if game has not ended yet
        if (!getGameEnd()) {
            //loop through the possible digonals that lead to wins
            for (int i = 3; i < getRows().length; i++) {
                // loop through 4 diagonals of possible wins
                for (int col = 6; col > 2; col--) {
                    //set counter
                    int counter = col;
                    //loop through rows
                    for (int j = i; j > i - 3; j--) {
                        //reset win
                        win = true;
                        //if board chips do not match
                        if (getRows()[j][counter] != getRows()[j - 1][counter  - 1]) {
                            //player has not won
                            win = false;
                            //exit loop
                            break;
                        }
                        //subtract 1 from counter
                        counter--;
                      }
                    //if player has won
                    if (win) {
                        //exit loop
                        break;
                    }
                  }
                //if player has won
                if (win) { 
                    gameWin(player, display);
                    break;
                }
              } 
          }
      }//end checkRightDiagonalWin function

    /*
     * checkTieGame(): checks if game has ended in a tie
     * 
     * @param display: textUI object to display message to user
     */
    public void checkTieGame(TextUI display){
        // declare and initialize variable for tie game
        boolean tie = true;
        //loop through board positions
        for (int i = 0; i < getRows().length; i++) {
            for (int j = 0; j < getRows()[i].length; j++) {
                //if board position has not been filled with a player chip
               if(getRows()[i][j] <= 7){
                //game is not tied
                tie = false;
                break;
               }
            }//end inner for
            //if game is not tied
            if(!tie){
                //exit loop
                break;
            }
        }//end outer for
        // if tie is true
        if (tie){
            // set game to end
            setGameEnd(true);
            // dispay tie game message
            display.tieMessage();
        }
      }//end checkTieGame function
     
    /*
     * checkGameState(): checks if a game win or tie has occured yet
     * 
     * @param currPlayer - player who is currently playing
     * @param game - the board that is being played on
     * @param display - textUI object to display message to user
     */
    public void checkGameState(Player currPlayer, Board game, TextUI display) {
        // check for win by row
        checkRowWin(currPlayer, display);
        //check for win by column
        checkColumnWin(currPlayer, display);
        //check for win by diagonal
        checkLeftDiagonalWin(currPlayer, display);
        checkRightDiagonalWin(currPlayer, display);
        // if game has not been won yet
        if (!game.getGameEnd()) {
            // check for a tie game
            checkTieGame(display);
        }
    }//end checkGameState method

    /*
     * loadBoard(): loads a prevoius saved game onto the board
     * 
     * @param tempBoard - array containing board game from file
     */
    public void loadBoard(int[][] tempBoard){
        //loop through board rows and columns
        for (int i = 0; i < getRows().length; i++) {
            for (int j = 0; j < getRows()[i].length; j++) {
                //set board position element as players chip or column number
                if (tempBoard[i][j] == 1) {
                    getRows()[i][j] = 82;
                } else if (tempBoard[i][j] == 2) {
                    getRows()[i][j] = 66;
                } else if (tempBoard[i][j] == 0) {
                    getRows()[i][j] = j + 1;
                }
            }//end inner for
        }//end outer for
    }//end loadBoard method

    /*
     * setter to set the game state
     * 
     * @param gameCondition - Takes in a boolean to see if game has ended or not
     */
    public void setGameEnd(boolean gameCondition) {
        gameEnd = gameCondition;
    }

    /*
     * getter to get the game state
     * 
     * @return a boolean that tells us if the game has ended or not
     */
    public boolean getGameEnd() {
        return gameEnd;
    }

    /*
     * getter to get the board
     * 
     * @return the array that contains the board position
     */
    public int[][] getRows() {
        return rows;
    }

    /*
     * setter to set the board positions
     * 
     * @param twoDArr - Takes in a 2d array that will be the base of our board
     */
    public void setRows(int[][] twoDArr) {
        rows = twoDArr;
    }

    /*
     * boardToString(): method to display the board in a string
     */
    public String boardToString(){
        //initialize string
        String board = "";

        // loop through rows of array/ game board rows
        for (int i = 0; i < getRows().length; i++) {
            for (int j = 0; j < getRows()[i].length; j++) {
                //if board position has a player chip
                if (getRows()[i][j] == 66 || getRows()[i][j] == 82) {
                    //display chip
                    board = board.concat((char) getRows()[i][j] + " ");
                } else {
                    // display board position to user
                    board = board.concat(getRows()[i][j] + " ");
                }
            }//end for
            // move to next line
            if(i != getRows().length - 1){
                board = board.concat("\n");
            }
        }
        //return string
        return board;
    }//end boardToString method

    /*
     * toString(): method to display all board data in a string
     */
    public String toString(){
        //initialize string
        String board = "";

        // loop through rows of array/ game board rows
        for (int i = 0; i < getRows().length; i++) {
            for (int j = 0; j < getRows()[i].length; j++) {
                //if board position has a player chip
                if (getRows()[i][j] == 66 || getRows()[i][j] == 82) {
                    //display chip
                    board = board.concat((char) getRows()[i][j] + " ");
                } else {
                    // display board position to user
                    board = board.concat(getRows()[i][j] + " ");
                }
            }//end for
            // move to next line
            if(i != getRows().length - 1){
                board = board.concat("\n");
            }
        }
        //return string with board data
        return board + " game Win: " + "gameEnd";
    }//end toString method

}

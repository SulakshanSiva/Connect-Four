package connectfour;

import java.io.IOException;
import java.util.Scanner;

 /*
  * Represents a class to hand player turn functionality and run the actual game
  */
public class ConnectFour {
    /*
     * checkPlayerTurn(): checks which player turn it is
     * 
     * @param pOne - first player that is currently playing the game
     * @param pTwo - second player that is currently playing the game
     * 
     * @returns the player that currently has a turn
     */
    public static Player checkPlayerTurn(Player pOne, Player pTwo) {
        // if player one has just had a turn
        if (pOne.getPlayerTurn()) {
            // set player two to have a turn
            pTwo.setPlayerTurn(true);
            pOne.setPlayerTurn(false);
            // return player two
            return pTwo;
        } else {
            // set player one to have a turn
            pTwo.setPlayerTurn(false);
            pOne.setPlayerTurn(true);
            // return player one
            return pOne;
        }
    }// end checkPlayerTurn method

    public static void main(String[] args) throws FileFormatException {
        // declare and initialize objects
        Scanner input = new Scanner(System.in);
        Board gameBoard = new Board();
        TextUI text = new TextUI();
        FileFeature saveGame = new FileFeature();
        // declare player objects and initialize using constructor
        Player playerOne = new Player('R', "Player One", false);
        Player playerTwo = new Player('B', "Player Two", true);
        // declare variable for current player on board
        Player currPlayer = checkPlayerTurn(playerOne, playerTwo);
        text.startGameMessage(playerOne, playerTwo);
        // create gameboard and initialize board positions
        gameBoard.createBoard(false);
        //prompt user to load a game save
        String file = text.promptForLoadFile(input);
        if (file != "") {
            try{
                saveGame.loadFromFile(file, gameBoard, text);
            }catch (IOException e) {
                text.loadFileError(e.getMessage());
            }
            gameBoard.checkGameState(currPlayer, gameBoard, text);
        }
        // loop until the game has concluded
        while (!gameBoard.getGameEnd()) {
            //display board to user
            text.displayBoard(gameBoard);
            // prompt for player move and make move
            gameBoard.makeMove(text.promptPlayerMove(input, currPlayer, gameBoard), currPlayer);
            // check for game win or tie
            // set game state
            gameBoard.checkGameState(currPlayer, gameBoard, text);
            // prompt user to save game to file
            file = text.promptForSaveFile(input);
            if(file != ""){
                try{
                    saveGame.saveToFile(file, gameBoard, text);
                } catch(IOException e) {
                    text.saveFileError(e.getMessage());
                }
            }
            //get next player to move
            currPlayer = checkPlayerTurn(playerOne, playerTwo);
        }
        text.displayBoard(gameBoard);
        text.endGameMessage();
        // close scanner
        input.close();
    }
}

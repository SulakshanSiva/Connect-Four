package connectfour;

import java.util.InputMismatchException;
import java.util.Scanner;

 /*
  * Represent a class to handle user input and display message to user.
  */
public class TextUI {
    /*
     *  displayBoard(): displays all board poisitions and their states to the user
     *  
     * @param game - the game board that is currently being played on 
     */
    public void displayBoard(Board game) {
        System.out.println(game.boardToString());
    }// end displayBoard method

    /*
     * promptPlayerMove(): prompts player for the board position that they would like to move to
     * 
     * @param in - Scanner to enable for user input
     * @param player - player that is currently playing(their turn)
     * @param game - the game board that is currently being played on
     * 
     * @return the board position that they would like to move to
     */
    public int promptPlayerMove(Scanner in, Player player, Board game){
        //initialize and declare variables for player move and if player move is allowed
        int move;
        boolean spotTaken = true;
        // prompt player for move
        System.out.println("Turn = " + player.getPlayerSymbol());
        System.out.println("Enter a number from 1 to 7 to select the column you would like to drop your chip in : ");
        //loop until user enters valid input
        do {
            move = -1;
            while(move < 1 || move > 7){
                try {
                // get user input
                move = in.nextInt();
                } catch (InputMismatchException e) {
                // display error message
                System.out.println("Invalid input.");
                // clear invalid input
                in.nextLine();
                }
                //if move is out of range
                if(move < 1 || move > 7){
                    //display error
                    System.out.println("Error. Enter a column number between 1 to 7.");
                }
            }//end while loop
            
            move = move - 1;
            // check to see if board spot has not already been selected
            if(game.getRows()[0][move] == 66 || game.getRows()[0][move] == 82){
                System.out.println("This game position has already been taken. Try again!");
            } else {
                spotTaken = false;
            }
        }
        // loop until user enters valid input
        while (spotTaken);
        //return player move
        return move;
    }//end promptPlayerMove function

    /*
     * promptForSaveFile(): prompts player to save their current board state to a file
     * 
     * @param in - Scanner to enable for user input
     * 
     * @return name of file or empty string if they do not want to save
     */
    public String promptForSaveFile(Scanner in){
        //initialize and declare variables for player choice
        int choice = -1;
        int count = 0;
        //loop until user enters valid input
        while(choice < 0 || choice > 1){
            //display prompt messages and errror messages to user
            if(count > 0){
                System.out.println("Error. Enter 1 if you would like to save the game or 0 to continue");
                try {
                    //get user input
                    choice = in.nextInt();
                } catch (Exception e) {
                    // display error message
                    System.out.println("Invalid input.");
                    // clear invalid input
                    in.nextLine();
                }
            } else {
            System.out.println("Would you like to save the current board to a file?");
            System.out.println("Enter 1 if you would like to save the game or 0 to continue");
            try {
                choice = in.nextInt();
            } catch (Exception e) {
                // display error message
                System.out.println("Invalid input.");
                // clear invalid input
                in.nextLine();
                }
            }
            //add 1 to count
            count++;
        }
        //if user wants to save to file
        if(choice == 1){
            //prompt for file name
            System.out.println("Please enter a file name.");
            //take in user input and save file name
            String fileName;
            fileName = in.next();
            return fileName;
        } else {
            return "";
        }
    }//end promptForSaveFile function

    /*
     * promptForLoadFile(): prompts user for if they want to load a previous game from a file
     * 
     * @param in - Scanner to enable for user input
     * 
     * @return name of file or empty string if they do not want to load
     */
    public String promptForLoadFile(Scanner in){
        //declare and initialize variables for player choice
        int choice = -1;
        int count = 0;

        //loop until user enters valid input
        while(choice < 0 || choice > 1){
            //display prompt messages and errror messages to user
            if(count > 0){
                System.out.println("Error. Enter 1 if you would like to load a game or 0 to continue");
                try {
                    //get user input
                    choice = in.nextInt();
                } catch (Exception e) {
                    // display error message
                    System.out.println("Invalid input.");
                    // clear invalid input
                    in.nextLine();
                }
            } else{
                //prompt user to load a previous game
                System.out.println("Would you like to load a game from a file and continue playing?");
                System.out.println("Enter 1 if you would like to load a game or 0 to continue");
                try {
                    //get user input
                    choice = in.nextInt();
                } catch (Exception e) {
                    // display error message
                    System.out.println("Invalid input.");
                    // clear invalid input
                    in.nextLine();
                }
            }
            //add 1 to count
            count++;
        }
    
        //if user wants to load a game
        if(choice == 1){
            //prompt for file name
            System.out.println("Please enter a file name.");
            //get and save file name
            String fileName;
            fileName = in.next();
            return fileName;
        } else {
            return "";
        }
    }//end promptForLoadFile function

    /*
     * loadFileError(): display an error message if file was not able to be loaded
     * 
     * @param error - name of file that was unable to be loaded/found
     */
    public void loadFileError(String error) {
        //display error message
        System.out.println("File " + error + " not found.");
    }//end loadFileError function

    /*
     * saveFileError(): display an error message if file was unable to be written to
     * 
     * @param error - name of file that was unable to be written to 
     */
    public void saveFileError(String error) {
        //display error message
        System.out.println("File " + error + " was unable to be written to. Game was not saved.");
    }//end saveFileError function

    /*
     * startGameMessage(): displays an intro message to the game and shows player symbols
     * 
     * @param one - player that is playing in the game
     * @param two - player that is playing in the game
     */
    public void startGameMessage(Player one, Player two){
        //display start game messages
        System.out.println("Welcome to Connect 4. Get 4 chips in a row to win. Grab a friend and lets play!");
        System.out.println(one.toString());
        System.out.println(two.toString());
    }//end startGameMessage function

    /*
     * endGameMessage(): Displays end of game message
     */
    public void endGameMessage(){
        System.out.println("Game has ended. Thanks for playing!");
    }//end endGameMessage function

    /*
     * winMessage(): display player win message
     * 
     * @param player - player that has won
     */
    public void winMessage(Player player){
        //display win message
        System.out.println(player.getPlayerName() + ": " + player.getPlayerSymbol() + " has won!");
    }//end winMessage function

    /*
     * tieMessage(): display tie game message
     */
    public void tieMessage(){
        //display tie game message to user
        System.out.println("Tie Game!");
    }//end tieMessage function

    /*
     * errorMessage(): displays an error message to user
     */
    public void errorMessage(){
        // display error message
        System.out.println("An error occurred.");
    }//end ErrorMessage method

    /*
    * toString(): returns a string representation of this class
    *             This class has no instance variables thus the string will represent the function of this class.
    */
    public String toString(){
        return "Prompt for user input and display game messages.";
    }//end toString method
    
}

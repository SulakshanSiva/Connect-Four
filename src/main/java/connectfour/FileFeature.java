package connectfour;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.StringTokenizer;
/**
 * Name: Sulakshan Sivakumaran
 * Student ID: 1185052
 * Class: CIS*2430
 * Email: sulaksha@uoguelph.ca
 * Date: October 18, 2022
 */

 /*
  * Class to represent functions that deal with all things to do with file.
  * Deals with loading, reading and file errors.
  */
public class FileFeature {
    /*
     * saveToFile(): Writes to a file and save the current board state. 
     * 
     * @param fileName - name of the file being written to
     * @param game - board of game that is currently being written to
     */ 
    public void saveToFile(String fileName, Board game, TextUI display) throws IOException{
        //string of file folder location
        String location = "assets";
        //get path of folder with files to save in 
        Path path = FileSystems.getDefault().getPath(location, fileName);
    
        try {
            //initialize writer to file
            BufferedWriter myWriter = Files.newBufferedWriter(path);
            //loop through board rows
            for (int i = 0; i < game.getRows().length; i++) {
                for (int j = 0; j < game.getRows()[i].length; j++) {
                    //write number to file depending on board index element
                    if(game.getRows()[i][j] == 82){
                        myWriter.write("1");
                    } else if(game.getRows()[i][j] == 66){
                        myWriter.write("2");
                    } else{
                        myWriter.write("0");
                    }
                    //write comma after every number excluding the last one
                    if(j != game.getRows()[i].length - 1){
                        myWriter.write(",");
                    }
                }//end inner for
                if(i != game.getRows().length - 1){
                    myWriter.write("\n");
                }
            }//end outer for
            myWriter.close();
        } catch (IOException e) {
            display.errorMessage();
        }
    }//end saveToFile method

    /*
     * loadFromFile(): Reads from a file and continues a presaved board game
     * 
     * @param fileName - name of file that we are reading from 
     * @param game - board of game that is current being played
     */
    public void loadFromFile(String fileName, Board game, TextUI display) throws IOException, FileFormatException{
        int row = 0;
        int column = 0;
        //String for folder in which files will be loaded from 
        String location = "assets";
        //path to files
        Path path = FileSystems.getDefault().getPath(location, fileName);
        
        try {
            //initialize writer to file and temp array
            BufferedReader myReader = Files.newBufferedReader(path);
            int[][] tempBoard = new int[game.getRows().length][game.getRows()[0].length];
            String rowInfo;
            boolean fileError = false;
            //get file lines until last line
            while((rowInfo = myReader.readLine()) != null) {
                //load file line contents into temp Array
                StringTokenizer token = new StringTokenizer(rowInfo,",");
                column = 0;
                while(token.hasMoreTokens()){
                    int value = Integer.parseInt(token.nextToken());
                    tempBoard[row][column] = value;
                    column++;
                }
                row++;
            }
            //loop through array to see if file has incorrect formatting
            for (int i = 0; i < tempBoard.length; i++) {
                for (int j = 0; j < tempBoard[i].length; j++) {
                    if (tempBoard[i][j] != 1 && tempBoard[i][j] != 2 && tempBoard[i][j] != 0) {
                        fileError = true;
                    }
                } // end inner for
            } // end outer for
            //if file had errors throw custom exception
           if(fileError){
            throw new FileFormatException("File Format Error!");
           } else {
            //load saved game board
            game.loadBoard(tempBoard);
            //close reader
            myReader.close();
           }
        } catch (FileNotFoundException e) {
            display.errorMessage();
        }
    }//end loadFromFile method

    /*
     * toString(): returns a string representation of this class
     * This class has no instance variables thus the string will represent the
     * function of this class.
     */
    public String toString(){
        return "Loads a pre-saved game from a file and can save a game to a file.";
    }//end toString method
}

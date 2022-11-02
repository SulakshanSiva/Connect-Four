package connectfour;

/**
 * Name: Sulakshan Sivakumaran
 * Student ID: 1185052
 * Class: CIS*2430
 * Email: sulaksha@uoguelph.ca
 * Date: October 18, 2022
 */

/*
 * Represent a class that throws an a custom exception
 * when a incorrect file format is given.
 */
public class FileFormatException extends Exception{
    /*
     * FileFormatException(): throws a custom exceptions
     * 
     * @param message - error message
     */
    public FileFormatException(String message) {
        //display message in terminal when error is found
        super(message);
    }//end FileFormatException method
}

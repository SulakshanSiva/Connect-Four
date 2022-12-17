# Connect Four

This program is a Connect Four game. It is a game that involves 2 players trying to get 4 chips in a row to win. All that is needed to play this game is a terminal and a friend.

## Description

As mentioned before this is a simple Connect Four Game. It is a player vs player game that is played between 2 people. Each player will be represented by a symbol, "R" or "B". Player one is "R" and player two is "B". The goal of the game is to get 4 chips(your symbol) in a row to win. This can be done by 4 in a row, 4 in a column, or 4 in a diagonal either from left to right or right to left. The game will end in a win for the player to first complete this. The game will end in a tie if all board spots are filled with chips but no player has achieved the win condition yet.
It is a turn based game system played between 2 people, you and a friend. This game can be played in the terminal. All player moves will take place in the terminal by entering your desired move and all user messages and board will be displayed in the terminal to the user. Games can be saved to or loaded from files.

## Getting Started

### Dependencies
The only things needed to run this program are an IDE and a Docker to access the container. Knowledge of file names are also necessary if you wish to load or save games. These files can be found in the "assets" folder.

### Executing program

- Download all necessary files from this gitlab repository
- Start your Docker and open terminal
- Enter the followining in the terminal to open your container
```
scioer start
```
- Then type
```
scioer shell
```
to move into the container
- Cd to the A2 folder that your files are in 
- Once in the folder, type the following in the terminal to start compiling the program
```
gradle build
```
- Then type 
```
gradle run
```
- Finnaly, copy and paste the command that is in the terminal after running "gradle run". It should look like the following:
```
java -cp build/classes/java/main connectfour.ConnectFour
```
- You are done! You are now ready to play Connect Four. Follow the instructions in the terminal to play the game. Have fun!

## Limitations

In this program, there are a few limitations that could hinder the user's playing experience. One of the limitations that my program has is that I am unable to check for all incorrect file formats. Currently, if a user enters a file with a number other than 0, 1 or 2, I am able to recognize that the file format is incorrect and stop the program accordingly. However, if a user were to enter a file with strings instead of numbers or a file with extra lines at the bottom of the file, my program would not be able to handle this. This downplays the user experience and essentially forces the user to enter a valid file or an invalid file with invalid numbers. Another limitation that my program has is that the user interface is based in the terminal. I prompt the user to enter a number in the terminal for move choices, choice to save a file, and for the choice to load a file. This means that I am constantly asking the user to enter a number which is very inefficient and is very non-user friendly. This could be fixed by implementing a GUI with buttons which makes the game much more appealing and easy to run/play. Finally, another limitation that my program has is that when loading a pre-saved game it defaults to the player one moving first. My program does not find whose turn it is and automatically sets the player one to move. So, for example, if it is player two's turn to go in the pre-saved game, my program will load the game as if player one is next to move. This puts player two in a disadvantage and puts the game win in favor of player one.

## Author Information

Name: Sulakshan Sivakumaran

## Development History
* 0.8.2
    * Commented
* 0.8.1
    * Added test for toString method
* 0.8.0
    * Created toString methods
* 0.7.2
    * Commented and added more junit tests
* 0.7.1
    * Fixed import error
* 0.7.0
    * Implemented junit testing for board class
* 0.6.14
    * Updated ReadMe
* 0.6.13
    * Updated ReadMe
* 0.6.12
    * Added error messages
* 0.6.11
    * Commented files
* 0.6.10
    * Commented custom exception class
* 0.6.9
    * Created custom exception for file format errors
* 0.6.8
    * Commented board class
* 0.6.7
    * Fixed print win message bug
* 0.6.6
    * Commented main class
* 0.6.5
    * Commented text class
* 0.6.4
    * Commented player class
* 0.6.3
    * Added toString method for board class
* 0.6.2
    * Created start and end game message functions
* 0.6.1
    * Created right to left diagonal win function
* 0.6.0
    * Created left to right diagonal win check function
* 0.5.8
    * Added comments
* 0.5.7
    * Deleted createFile function
* 0.5.6
    * Fixed file functions
* 0.5.5
    * Created load from file and save to file functions
* 0.5.4
    * Added function to check for tie game
* 0.5.3
    * Added function to check for column win
* 0.5.2
    * Added function to check win by row
* 0.5.1
    * Added player move functions
* 0.4.1
    * Updated create board method
* 0.4.0
    * Created player class and implemented in main method along with scanner
* 0.3.2
    * Merged branched 'main' into main
* 0.3.1
    * Created player class
* 0.3.0
    * Added display board and created board methods
* 0.2.0
    * Started ReadMe file, updated author and title
* 0.1
    * Initial Release

## Acknowledgments

Inspiration, code snippets, etc.

[Objects and Classes]https://www.w3schools.com/java/java_classes.asp

[Java Documentation]https://docs.oracle.com/javase/specs/jls/se11/html/index.html

[Custom Exceptions]https://www.youtube.com/watch?v=OIozDnGYqIU&t=512s&ab_channel=CodingwithJohn

Certain Sections of Code were reused from A1. My A1 repository can be found below:

[A1 Repository]https://gitlab.socs.uoguelph.ca/2430f22/sulaksha/A1

The Sections of code that were reused were...
- ENTIRE Player Class
- Player Turn Function
- Game loop, setting up game, and checking game state in main
- Parts of the display and create board methods
- Comments for all of the above 


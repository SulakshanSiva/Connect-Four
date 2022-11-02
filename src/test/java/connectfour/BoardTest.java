package connectfour;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/* you will need to add test methods and likely change the
setup method as well.  The samples that are here are just so that
you can see how junit works.

Tests are run on build unless specifically excluded with -x test.
The test results are reported in the reports subfolder of the build directory */

/*
 * Class to run automated tests for the board class
 */
public class BoardTest {
    //declare variables
    private Board tester;
    private Board temp;
    private Player pOne;
    private Player pTwo;
    private TextUI display;

    @Before
    public void setup() {
        // set up for the test
        tester = new Board();
        temp = new Board();
        pOne = new Player('R', "Player One", false);
        pTwo = new Player('B', "Player Two", false);
        display = new TextUI();
    }
    
    /*
     * testCreateBoard(): tests to see if the board can be created and initialized
     */
    @Test
    public void testCreateBoard(){
        //create board
        tester.createBoard(false);
        //check if board is initialized
        Assert.assertNotNull(tester);
    }
    
    /*
     * testMakeMove(): tests to see if the player can move to a position on the board
     */
    @Test
    public void testMakeMove(){
        //create board
        tester.createBoard(false);
        //make player move
        tester.makeMove(0, pOne);
        //check if move has been  made
        Assert.assertEquals((tester.getRows()[5][0]), 82);
    }

    /*
     * testGameWin: Tests to see if the game condition has been set to WON
     */
    @Test
    public void testGameWin(){
        //create board
        tester.createBoard(false);
        //set game state to won
        tester.gameWin(pOne, display);
        //check if game has been won
        Assert.assertEquals(tester.getGameEnd(), true);
    }

    /*
     * testRowWin(): test to see if the player has won by a row condition
     */
    @Test
    public void testRowWin(){
        //create board
        tester.createBoard(false);
        //set 4 positions to chip R
        tester.makeMove(0, pOne);
        tester.makeMove(1, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(3, pOne);
        //check for win
        tester.checkRowWin(pOne, display);
        //check if game state is won/ended
        Assert.assertEquals(tester.getGameEnd(), true);
    }

    /*
     * testNoRowWin(): tests to see if the player has NOT won by a row condition
     */
    @Test
    public void testNoRowWin() {
        //create board
        tester.createBoard(false);
        //set 3 positions to chip R
        tester.makeMove(1, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(3, pOne);
        //check for row win
        tester.checkRowWin(pOne, display);
        //check if game state is NOT won/ended
        Assert.assertEquals(tester.getGameEnd(), false);
    }

    /*
     * testColumnwWin: tests to see if the player has won by a column condition
     */
    @Test
    public void testColumnwWin() {
        //create board
        tester.createBoard(false);
        //set 4 positions to chip R
        tester.makeMove(1, pOne);
        tester.makeMove(1, pOne);
        tester.makeMove(1, pOne);
        tester.makeMove(1, pOne);
        //check for column win
        tester.checkColumnWin(pOne, display);
        //check if game state is WON/ended
        Assert.assertEquals(tester.getGameEnd(), true);
    }

    /*
     * testNoColumnwWin(): tests to see if the player has NOT won by a column condition
     */
    @Test
    public void testNoColumnwWin() {
        // create board
        tester.createBoard(false);
        // set 4 positions to chip R
        tester.makeMove(2, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(2, pOne);
        // check for column win
        tester.checkColumnWin(pOne, display);
        //check if game state is NOT won/ended
        Assert.assertEquals(tester.getGameEnd(), false);
    }

    /*
     * testLeftDiagonalWin(): tests to see if the player has won by a left diagonal
     */
    @Test
    public void testLeftDiagonalWin() {
        //create board
        tester.createBoard(false);
        //make player board moves for a left diagonal win
        tester.makeMove(0, pOne);
        tester.makeMove(1, pOne);
        tester.makeMove(1, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pOne);
        //check for left diagnoal win
        tester.checkLeftDiagonalWin(pOne, display);
        //check if game has been won/ended
        Assert.assertEquals(tester.getGameEnd(), true);
    }

    /*
     * testNoLeftDiagonalWin(): tests to see if the player has NOT won by a left diagonal
     */
    @Test
    public void testNoLeftDiagonalWin() {
        // create board
        tester.createBoard(false);
        // make player board moves for a left diagonal win
        tester.makeMove(0, pOne);
        tester.makeMove(1, pOne);
        tester.makeMove(1, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(2, pOne);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pOne);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pTwo);
        // check for left diagonal win
        tester.checkLeftDiagonalWin(pOne, display);
        // check if game has been NOT won/ended
        Assert.assertEquals(tester.getGameEnd(), false);
    }

    /*
     * testRightDiagonalWin(): tests to see if the player has won by a right diagonal
     */
    @Test
    public void testRightDiagonalWin() {
        //create board
        tester.createBoard(false);
        // make player board moves for a right diagonal win
        tester.makeMove(6, pOne);
        tester.makeMove(5, pOne);
        tester.makeMove(5, pOne);
        tester.makeMove(4, pOne);
        tester.makeMove(4, pOne);
        tester.makeMove(4, pOne);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pOne);
        //check for a right diagonal win
        tester.checkRightDiagonalWin(pOne, display);
        //check if the game has been won/ended
        Assert.assertEquals(tester.getGameEnd(), true);
    }

    /*
     * testNoRightDiagonalWin(): test to see if the player has NOT won by a right diagnoal win
     */
    @Test
    public void testNoRightDiagonalWin() {
        //create board
        tester.createBoard(false);
        // make player board moves for a right diagonal win
        tester.makeMove(6, pOne);
        tester.makeMove(5, pOne);
        tester.makeMove(5, pOne);
        tester.makeMove(4, pOne);
        tester.makeMove(4, pOne);
        tester.makeMove(4, pOne);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pOne);
        tester.makeMove(3, pTwo);
        tester.makeMove(3, pTwo);
        //check for a right diagonal win 
        tester.checkRightDiagonalWin(pOne, display);
        //check if the game has NOT been won/ended
        Assert.assertEquals(tester.getGameEnd(), false);
    }

    /*
     * testTieGame(): checks to see if the game has ended in a tie
     */
    @Test
    public void testTieGame(){
        //create board
        tester.createBoard(false);
        //loop through board positions
        for(int i = 0; i < tester.getRows().length; i++){
            for(int j = 0; j < tester.getRows()[i].length; j++){
                //set chip at board position
                tester.makeMove(j, pOne);
            }
        }
        //check if game is a tie
        tester.checkTieGame(display);
        //check if game has ended in a tie
        Assert.assertEquals(tester.getGameEnd(), true);
    }

    /*
     * testNoTieGame(): test to see if game has not ENDED in a tie
     */
    @Test
    public void testNoTieGame() {
        //create board
        tester.createBoard(false);
        //loop through board poisitions
        for (int i = 0; i < tester.getRows().length; i++) {
            //exclude last column
            for (int j = 0; j < tester.getRows()[i].length - 1; j++) {
                //set chip at board position
                tester.makeMove(j, pOne);
            }
        }
        //check if game is tied
        tester.checkTieGame(display);
        //checks to see if game has NOT ended in a tie
        Assert.assertEquals(tester.getGameEnd(), false);
    }

    /*
     * testWinGameState(): tests to see if game has been won
     * - already tested row, columnn and diagonal win so we can just choose a single one to test here
     */
    @Test
    public void testWinGameState(){
        //create board
        tester.createBoard(false);
        //set 4 chips in a row 
        tester.makeMove(2, pOne);
        tester.makeMove(3, pOne);
        tester.makeMove(4, pOne);
        tester.makeMove(5, pOne);
        //check game state
        tester.checkGameState(pOne, tester, display);
        //checks if game has been won
        Assert.assertEquals(tester.getGameEnd(), true);
    }

    /*
     * testNoWinGameState(): tests to see if game has not been won
     */
    @Test
    public void testNoWinGameState() {
        //create board
        tester.createBoard(false);
        //set 2 chips in a row
        tester.makeMove(4, pOne);
        tester.makeMove(5, pOne);
        //checks game state
        tester.checkGameState(pOne, tester, display);
        //checks if game has NOT been won
        Assert.assertEquals(tester.getGameEnd(), false);
    }

    /*
     * testLoadBoard(): tests to see if the board has been loaded 
     */
    @Test
    public void testLoadBoard(){
        //create board
        temp.createBoard(false);
        //load board
        tester.loadBoard(temp.getRows());
        //check if board is initialized
        Assert.assertNotNull(tester);
    }
    /*
     * testBoardToString(): tests to see if board string is empty
     */
    @Test
    public void testBoardToString(){
        // create board
        temp.createBoard(false);
        // check if string is empty
        Assert.assertNotNull(temp.boardToString());
    }
    /*
     * testToString(): tests to see if board data string is empty
     */
    @Test
    public void testToString(){
        //create board
        temp.createBoard(false);
        //check if string is empty
        Assert.assertNotNull(temp.toString());
    }

}

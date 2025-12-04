
/**
 * This class will contain the gameplay methods and logic nessescary to run the game 
 *
 * @author ()
 * @version (November 4th, 2025)
 */
public class Gameplay
{
    //this is the main gameplay class that will bring all the methods together and let the player play the game
    //Christopher
    public static void gamePlay()
    {
        //this needs to be done -Chris
        //will work on descision structor late lmao
    }
    
    
    
    //This method will generate a grid for the user to see using a 2d array
    //Christopher
    public static void generateGrid()
    {
        //Create a 2d array of type byte to hold the numbers to display the grid
        //initialize the 2d array to be 4x4
        byte[][] bytDisplayGrid = new byte[4][4];
        
        //initialize and populate a variable of type byte to populate the grid
        byte bytNum = 1;
        
        //populate the grid with numbers 1-16 descending from top left to bottom right using for loops
        for (byte i = 0; i<bytDisplayGrid.length ;i++)
        {
            for(byte j = 0; j <bytDisplayGrid[0].length; j++)
            {
                bytDisplayGrid[i][j] = bytNum;
                bytNum ++;
            }
        }
    }
    
    //this method will print the current grid to the screen
    //Christopher
    public static void printGrid(byte [][] bytGrid)
    {
        //print to the screen the grid using a for loop
        for (byte i = 0; i<bytGrid.length ;i++)
        {
            for(byte j = 0; j <bytGrid[0].length; j++)
            {
                System.out.print(bytGrid[i][j] +  " ");
            }
            System.out.println("");
        }
    }
}
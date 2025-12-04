
/**
 * This class will contain the gameplay methods and logic nessescary to run the game 
 *
 * @author ()
 * @version (November 4th, 2025)
 */
public class Gameplay
{
    
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
        
        //print to the screen the grid using a for loop
        for (byte i = 0; i<bytDisplayGrid.length ;i++)
        {
            for(byte j = 0; j <bytDisplayGrid[0].length; j++)
            {
                System.out.print(bytDisplayGrid[i][j] +  " ");
            }
            System.out.println("");
        }
        
        
    }
}
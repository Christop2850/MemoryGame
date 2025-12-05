
/**
 * This class will contain the gameplay methods and logic nessescary to run the game 
 *
 * @author (Christopher)
 * @version (November 5th, 2025)
 */
//import Scanner to take in user input
import java.util.Scanner;
public class Gameplay
{
    //this is the main gameplay class that will bring all the methods together and let the player play the game
    //Christopher
    public static void gamePlay()
    {
        //initialize two final variables of type byte to hold the size of the grid
        final byte COL = 4, ROW = 4;
        
        //create two variables of type byte to hold the user's input
        byte bytInput1 = 0, bytInput2 = 0;
        
        //initialize a 2d array of type byte to hold the display grid to show the player
        byte[][] bytDisplay;
        
        //create a varaible of type boolean to error trap
        boolean bolError = false;
        
        //call the randomizeGrid method to populate the back end grid
        
        //call the generatGrid method and the printGrid method to generate and show to the player the grid visual
        bytDisplay = generateGrid(COL, ROW);
        printGrid(bytDisplay);
        
        //ask the user for the first card they want to flip
        System.out.println("Which first card do you want to pick (Please input the number)");
        
        //use a do while loop in case there is a error
        do
        {
            //populate the variable with the user's input and error trap using a try catch block
            try
            {
                bytInput1 = new Scanner(System.in).nextByte();
                bolError = false;
            }
            catch(Exception e)
            {
                System.out.println("Error, please try again");
                bolError = true;
            }
            
            //use a if block error trap
            if ((bytInput1 > 16 || bytInput1 < 1) && bolError == false)
            {
                System.out.println("Error, please try again");
                bolError = true;
            }
        } while (bolError);
        
        //ask the user for the first card they want to flip
        System.out.println("Which seconde card do you want to pick (Please input the number)");
        
        //use a do while loop in case there is a error
        do
        {
            //populate the variable with the user's input and error trap using a try catch block
            try
            {
                bytInput2 = new Scanner(System.in).nextByte();
                bolError = false;
            }
            catch(Exception e)
            {
                System.out.println("Error, please try again");
                bolError = true;
            }
            
            //use a if block error trap
            if ((bytInput2 > 16 || bytInput2 < 1) && bolError == false)
            {
                System.out.println("Error, please try again");
                bolError = true;
            }
        } while (bolError);
        
        
    }
    
    //this method will generate a 2d array with the object cards in them
    //Christopher
    public static void randomizeGrid()
    {
        //initialize a varaible of type byte to use to randomize the placement of the cards
        byte bytRandom = 0;
        
        //initialize 2 variables of type byte to move through the 2d array
        byte bytCol = 0, bytRow = 0;
        
        //initialize the objects and 2d array
        
        while (bytRandom == 0)
        {
            //randomly generate a 1 or 0 to populate the variable
            bytRandom = (byte) (Math.random()* 2);
            
            //use an if statement check if it should populate the 2d array
            //add the thing to check if it's already populated
            if (bytRandom == 1 )
            {
                //populate the 2d array
            }
            
            //move to the left in the 2d array
            bytCol++;
            
            //use an if statement to check if it should move down a row
            //add .length instead of 0
            if (bytCol == 0)
            {
                //reset the columb variable
                bytCol = 0;
                
                //use an if statement to error trap if the loops reaches the end of the 2d array
                //add .length instead of 0
                if (bytRow == 0)
                {
                    //reset the row variable
                    bytRow = 0;
                }
                else
                {
                    //move down one row
                    bytRow++;
                }
            }
        }
    }
    
    //This method will generate a grid for the user to see using a 2d array
    //Christopher
    public static byte[][] generateGrid(byte bytCol, byte bytRow)
    {
        //Create a 2d array of type byte to hold the numbers to display the grid
        //initialize the 2d array to be 4x4
        byte[][] bytDisplayGrid = new byte[bytCol][bytRow];
        
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
        
        //return the grid
        return bytDisplayGrid;
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
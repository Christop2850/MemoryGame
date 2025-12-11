
/**
 * This class will contain the gameplay methods and logic nessescary to run the game 
 *
 * @author (Christopher)
 * @version (November 5th, 2025)
 */
//import Scanner to take in user input
import java.util.*;
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

        //initialize variables of type byte to hold the indexs of the two cards chosen  
        byte bytColIndex1 = 0, bytRowIndex1 = 0 ,bytColIndex2 = 0, bytRowIndex2 = 0;

        //initialize a 2d array of type byte to hold the display grid to show the player
        byte[][] bytDisplay;

        //declare a constant of byte for health
        //final byte HEALTH = 10;
        byte bytHealth = 10;
        int intPairsLeft = 8;

        //declare a 2d array of type Cards to hold the randomized Cards
        Cards[][] Deck;

        //Atiqat
        ArrayList<Byte> usedNumbers = new ArrayList<>();

        //create a varaible of type boolean to error trap
        boolean bolError = false;
        
        //create a variable of tpye boolean to loop the game if the player wants to
        boolean bolPlayAgain = false;
        
        //create a variable of type string to hold the users input if they want to replay the game
        String strReplay;

        //declare a variable of type boolean to store if the cards are a match or not
        //boolean bolMatch;

        //call the randomizeGrid method to populate the back end grid
        Deck = randomizeGrid(COL,ROW);

        //call the generatGrid method and the printGrid method to generate and show to the player the grid visual
        bytDisplay = generateGrid(COL, ROW);
        
        do
        {
            //Atiqat
            while (bytHealth > 0 && intPairsLeft > 0 )
    
            {
                //Atiqat
                // PRINT UPDATED GRID
                System.out.println("---------------------------------------\n");
                printGrid(bytDisplay);
                System.out.println("\nHealth: " + bytHealth);
                System.out.println("Pairs left: " + intPairsLeft+"\n");
                
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
    
                    //Atiqat
                    // prevent choosing a matched card
                    //if the arrayList contains the number chosen then question is looped
                    if (usedNumbers.contains(bytInput1)) {
                        System.out.println("This card is already matched. Choose a different card.");
                        bolError = true;
                    }
                } while (bolError);
    
                //ask the user for the first card they want to flip
                System.out.println("Which second card do you want to pick (Please input the number)");
    
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
    
                    //Atiqat
                    //prevent choosing a matched card
                    //if the arrayList contains the number chosen then question is looped
                    if (usedNumbers.contains(bytInput2)) {
                        System.out.println("This card is already matched. Choose a different card.");
                        bolError = true;
                    }
                } while (bolError);
    
                //search through the display grid for the index containing the 2 cards the player asked for
                //Christopher
                for (byte i = 0; i< bytDisplay.length ;i++)
                {
                    for (byte j = 0; j< bytDisplay[0].length ;j++)
                    {
                        if (bytInput1 == bytDisplay[i][j])
                        {
                            bytColIndex1 = j;
                            bytRowIndex1 = i;
                        }
                    }
                }
                for (byte i = 0; i< bytDisplay.length ;i++)
                {
                    for (byte j = 0; j< bytDisplay[0].length ;j++)
                    {
                        if (bytInput2 == bytDisplay[i][j])
                        {
                            bytColIndex2 = j;
                            bytRowIndex2 = i;
                        }
                    }
                }
    
                //code an if statement to compare cards and tell user if the cards are a match or not, tell the user what the cards are, and add to health if correct and take away from health if incorrect
                //Farheen
                if(Deck[bytRowIndex1][bytColIndex1].equals(Deck[bytRowIndex2][bytColIndex2]))
                {
                    //Atiqat
                    //decreasing the pairs left for user to match
                    intPairsLeft--;
                    //increasing health
                    bytHealth++;
                    
                    //output that cards are a match
                    System.out.println("The cards are a match. Your health is now: " + bytHealth);
    
                    //tell user what match they found
                    System.out.println("The pair found is " + Deck[bytRowIndex1][bytColIndex1]);
    
                    //set correct cards on display grid to zero
                    bytDisplay[bytRowIndex1][bytColIndex1] = 0;
                    bytDisplay[bytRowIndex2][bytColIndex2] = 0;
    
                    //Atiqat 
                    //adding the used numbers to the arraylist to stop user from using the number again
                    usedNumbers.add(bytInput1);
                    usedNumbers.add(bytInput2);
                }
                else if ((Deck[bytRowIndex1][bytColIndex1].equals(Deck[bytRowIndex2][bytColIndex2])) && (Deck[bytRowIndex1][bytColIndex1]).toString() == "A")
                {
                    //decreasing the pairs left for user to match
                    intPairsLeft--;
                    //increasing health
                    bytHealth+= 2;
                    
                    //output that they foudn the lucky pair of A's
                    System.out.println("You found the lucky pair of A's, You gain 2 life");
                    
                    //output that cards are a match
                    System.out.println("The cards are a match. Your health is now: " + bytHealth);
    
                    //tell user what match they found
                    System.out.println("The pair found is " + Deck[bytRowIndex1][bytColIndex1]);
    
                    //set correct cards on display grid to zero
                    bytDisplay[bytRowIndex1][bytColIndex1] = 0;
                    bytDisplay[bytRowIndex2][bytColIndex2] = 0;
    
                    //adding the used numbers to the arraylist to stop user from using the number again
                    usedNumbers.add(bytInput1);
                    usedNumbers.add(bytInput2);
                }
                else
                {
    
                    //Atiqat 
                    //decreasing health
                    bytHealth--;
                    
                    //output that cards don't match
                    System.out.println("The cards are not a match. Your health is now: " + (bytHealth));
    
                    //tell user what cards are at locations chosen
                    System.out.println("Card 1 was " + Deck[bytRowIndex1][bytColIndex1] + "\nCard 2 was " + Deck[bytRowIndex2][bytColIndex2]);
    
                }
    
    
            }
            
            //Atiqat 
            //if there are no more pairs left and thier health is not 0 
            //then they win and game ends
            if (intPairsLeft == 0 && bytHealth >= 1)
            {
                endingMethod(true, bytHealth);
            }
            //if health is at 0, then game ends and they lose
            else
            {
                endingMethod(false, bytHealth);
            }
            
            //ask the player if they want to play again
            System.out.println("Would you like to play again? (Yes/No)");
            
            //use a do while block to error trap
            
            do
            {
                //populate the variable with the users awnser using a scanner
                strReplay = new Scanner (System.in).nextLine();
            
                //use an if statement to populate set the boolean depending on the user's awnser
                if (strReplay.equalsIgnoreCase("Yes"))
                {
                   bolPlayAgain = true;
                   bolError = false;
                }
                else if (strReplay.equalsIgnoreCase("No"))
                {
                    bolPlayAgain = false;
                    bolError = false;
                }
                else
                {
                    bolError = true; 
                }
            }
            while(bolError);
        } while(bolPlayAgain);
        
    }
    
    //this method will generate a 2d array with the object cards in them
    //Christopher
    public static Cards[][] randomizeGrid(byte bytColSize, byte bytRowSize)
    {
        //initialize a varaible of type byte to use to randomize the placement of the cards
        byte bytRandom = 0;

        //initialize a variable type boolean to check if the 2d array has been populated
        boolean bolPopulated = false;

        //initialize the 2d array of type card
        Cards[][] Deck = new Cards[bytRowSize][bytColSize];

        //initialize a array of type card to temporarily hold the cards so we can loop the population of the 2d array
        Cards[] TempDeck = new Cards[bytColSize + bytRowSize];

        //intialize one of each object of type card
        C1 c1 = new C1();
        C2 c2 = new C2();
        C3 c3 = new C3();
        C4 c4 = new C4();
        C5 c5 = new C5();
        C6 c6 = new C6();
        C7 c7 = new C7();
        C8 c8 = new C8();

        //populate the temporary deck
        TempDeck[0] = c1;
        TempDeck[1] = c2;
        TempDeck[2] = c3;
        TempDeck[3] = c4;
        TempDeck[4] = c5;
        TempDeck[5] = c6;
        TempDeck[6] = c7;
        TempDeck[7] = c8;

        //randomly populate the 2dArray
        for (byte i = 0; i < 2 ;i++)
        {            
            for (byte j = 0; j <TempDeck.length ;j++)
            {
                //reset boolean
                bolPopulated = false;
                while (bolPopulated == false)
                {
                    for(byte bytRow = 0; bytRow<bytRowSize ;bytRow++)
                    {
                        for (byte bytCol = 0; bytCol <bytColSize; bytCol++)
                        {
                            //randomly generate a 1 or 0 to populate the variable
                            bytRandom = (byte) (Math.random()* 2);

                            //use an if statement check if it should populate the 2d array
                            if ((bytRandom == 1) && (Deck[bytRow][bytCol] == null) && (bolPopulated == false))
                            {
                                //populate the 2d array
                                Deck[bytRow][bytCol] = TempDeck[j];

                                bolPopulated = true;
                            } 
                        }
                    } 
                }
            }
        }        

        //return the 2d array
        return Deck;    
    }

    //This method will generate a grid for the user to see using a 2d array
    //Christopher
    public static byte[][] generateGrid(byte bytColSize, byte bytRowSize)
    {
        //Create a 2d array of type byte to hold the numbers to display the grid
        //initialize the 2d array to be 4x4
        byte[][] bytDisplayGrid = new byte[bytRowSize][bytColSize];

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
                System.out.print(bytGrid[i][j] +  " \t");
            }
            System.out.println();
        }
    }

    //this method will tell the user if they won the game or not
    //Farheen
    public static void endingMethod(boolean bolWon, byte score)
    {

        //code an if statement to output a message to the user telling them if they won
        if(bolWon == true)
        {

            //output message
            System.out.println("\n\nCongratulations! You won the game!");
            
            //Atiqat
            //updatng the user score to thier profile
            MainMenu.updateScore(score);
            
            //Outputting the score to the user
            System.out.println("Your score is: " + score);

        }
        else
        {

            //output losing message
            System.out.println("You lost the game!");

        }

    }

}
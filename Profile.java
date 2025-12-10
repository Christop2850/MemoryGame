
/**
 * Description: Profile class
 * 
 * This class handles user account management for the game.
 * It provides 3 main feactures:
 * 
 * 1. checker(Player) - checks if a saved profile file exists.
 * 2. Login(Player) - loads a saved Player object from a file.
 * 3. Signup(Player) - saves a new Player object to a file.
 * 
 * This class uses java object serialization to store and 
 * load Player objects. Player profiles are saved as .txt files using
 * ObjectOutputStream and loaded using ObjectInputStream. 
 * The usernames become filenames(e.g,"gamer101.txt").
 *
 * @author (Atiqat Adefioye)
 * @version (December 5th)
 */
//import entire IO library
import java.io.*;

//import Scanner class for input
import java.util.*; 
public class Profile extends Player
{
    
    /**
     * Checks is a profile file exists for the given player
     * returns true if a with the username exists, false otherwise
     */
    public static boolean checker(Player player)
    {
        //create a file object with the players username
        File file = new File(player.getstrUserName()+".txt");
        
        //return weather the file exists
        return file.exists();
    }
    
    
    /**
     * Loads and returns a saved Player object from file.
     * This method reads a serialized Player object
     */
    public static Player Login(Player player)
    {
        try
        {
            
            //declare a variable to store the ObjectInputStream (OIS)
            //called in
            ObjectInputStream in;
            
            // Create an ObjectInputStream to read the Player object
            in = new ObjectInputStream(new FileInputStream(player.getstrUserName()+".txt"));
            
            // Read the Player object from the file
            player = (Player)in.readObject();

            //closing the filereader
            in.close();
                    } 
        catch (ClassNotFoundException e) 
        {
            System.out.println("Error: Object's class does not match");
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: Cannot open file for reading");
            
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot read from file");
            
        }
        //return the loaded Player object
        return player;

    }
    
    
    /**
     * Saves a new Player object to a file using object serialization.
     * This method creates a file "username.txt" and writes the Player to it.
     */
    public static void Signup(Player newPlayer)
    {
        try
        {

            //declare a variable of type OOS - which will write the entire
            //object to the file
            ObjectOutputStream out;

            //calling the overload constructor
            //newPlayer = new Player(newPlayer.getstrUserName(),newPlayer.getstrPassword());

            //build an OOS object and connect it with a FOS to create the txt file
            out = new ObjectOutputStream(new FileOutputStream(newPlayer.getstrUserName()+".txt"));

            //uses the OOS method writeobject to 
            //write the entire Player object to the file
            out.writeObject(newPlayer);

            //close printwriter and filewriter
            out.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: Cannot open file for writing");
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot write to file");
        }
    }
    
    public static void UpdateProfile(Player player)
    {
        try
        {

            //declare a variable of type OOS - which will write the entire
            //object to the file
            ObjectOutputStream out;

            //calling the overload constructor
            //newPlayer = new Player(newPlayer.getstrUserName(),newPlayer.getstrPassword());

            //build an OOS object and connect it with a FOS to create the txt file
            out = new ObjectOutputStream(new FileOutputStream(player.getstrUserName()+".txt"));

            //uses the OOS method writeobject to 
            //write the entire Player object to the file
            out.writeObject(player);

            //close printwriter and filewriter
            out.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: Cannot open file for writing");
        } 
        catch (IOException e) 
        {
            System.out.println("Error: Cannot write to file");
        }
    }
}
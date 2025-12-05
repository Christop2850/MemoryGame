/**
 * Description: This program will populate the user's username and password.
 * It will use instance variables, a main constructor, a default constructor, and
 * an overloaded constructor with getters and setters. 
 *
 * @author (Farheen Almazi)
 * @version (December 4th, 2025)
 */

//import file io
import java.io.*;

public class Player implements java.io.Serializable
{
    
    //code private instance variables of type string for username and password
    private String strUserName, strPassword;
    
    //code an instance variable of type byte for score
    byte bytScore;
    
    //code a construtor to set the username, password, and score for each object
    public Player(String u, String p)
    {
        
        //populate instance variables with parameters of constructors
        this.strUserName = u;
        this.strPassword = p;
        this.bytScore = 0;
        
    }
    
    //default constructor to default variables
    public Player()
    {
        
        //populate instance variables with defaults
        this.strUserName = null;
        this.strPassword = "0";
        this.bytScore = 0;
        
    }
    
    //code an overloaded constructor
    public Player(String u)
    {
        
        //populate username with parameter
        this.strUserName = u;
        
        //default password to zero so user can create their own
        this.strPassword = "0";
        
    }
    
    //code getters for instance variables
    public String getstrUserName()
    {
        return this.strUserName;
    }
    
    public String getstrPassword()
    {
        return this.strPassword;
    }
    
    //code setters for instance variables
    public void setUserName(String u)
    {
        this.strUserName = u;
    }
    
    public void setPassword(String p)
    {
        this.strPassword = p;
    }
    
}

/**
 * Description: this program will set the value of card 14 and output its value
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class C14 extends Cards
{
    
    //code a constructor to populate the cards instance variable for C1 subclass
    public C14()
    {
        
        //set super class variable equal to G for this object
        super('G');
        
    }

    //code a toString that overrides the superclass toString method for output
    @Override
    public String toString()
    {

        return "G";

    }
    
}
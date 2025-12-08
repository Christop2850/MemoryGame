
/**
 * Description: this program will set the value of card 13 and output its value
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class C13 extends Cards
{
    
    //code a constructor to populate the cards instance variable for C1 subclass
    public C13()
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
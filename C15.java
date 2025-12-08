
/**
 * Description: this program will set the value of card 15 and output its value
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class C15 extends Cards
{
    
    //code a constructor to populate the cards instance variable for C1 subclass
    public C15()
    {
        
        //set super class variable equal to H for this object
        super('H');
        
    }

    //code a toString that overrides the superclass toString method for output
    @Override
    public String toString()
    {

        return "H";

    }
    
}
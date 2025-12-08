
/**
 * Description: this program will set the value of card 2 and output its value
 *
 * @author (Farheen Almazi)
 * @version (December 5th, 2025)
 */
public class C2 extends Cards
{
    
    //code a constructor to populate the cards instance variable for C1 subclass
    public C2()
    {
        
        //set super class variable equal to B for this object
        super('B');
        
    }

    //code a toString that overrides the superclass toString method for output
    @Override
    public String toString()
    {

        return "B";

    }
    
}
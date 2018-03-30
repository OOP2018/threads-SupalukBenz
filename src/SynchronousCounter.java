/**
 * A class is subclass of Counter for used add method.
 *
 * @author Suapluk Jaroensuk
 */
public class SynchronousCounter extends Counter{

    /**
     * Add numbers by used add method from superclass.
     * @param amount is number for adding
     */
    @Override
    public synchronized void add(int amount){
        super.add(amount);
    }
}

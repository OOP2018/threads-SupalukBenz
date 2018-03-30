import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A class is subclass of counter and used Lock implementations provide more extensive locking operations
 * than can be obtained using synchronized methods and statements.
 *
 * @author Supaluk Jaroensuk
 */
public class CounterWithLock extends Counter{

    /**
     * Lock interface
     */
    private Lock lock = new ReentrantLock();

    /**
     * Add numbers by used add method from superclass and protected entering a thread.
     * @param amount is number for adding
     */
    public void add(int amount){
        try{
            lock.lock();
            super.add(amount);
        }finally {
            lock.unlock();
        }
    }
}

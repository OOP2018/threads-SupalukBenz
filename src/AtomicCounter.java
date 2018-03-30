import java.util.concurrent.atomic.AtomicLong;

/**
 * AtomicCounter that a long value that may be updated atomically.
 *
 * @author Supaluk Jaroensuk
 */

public class AtomicCounter extends Counter{

    /**
     * AtomicLong class
     */
    private AtomicLong total;

    /**
     * Initialize AtomicLong
     */
    public AtomicCounter() {
        this.total = new AtomicLong();
    }

    /**
     * Atomically adds the given value to the current value.
     * @param amount is number for adding.
     */
    public void add(int amount){
        total.getAndAdd(amount);
    }

    /**
     * Returns the value in the current thread's copy of this thread-local variable.
     * @return value in the current thread.
     */
    public long get(){
        return total.decrementAndGet();
    }
}

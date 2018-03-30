/**
 * AddTask class implements Runnable interface using run method for add number.
 *
 * @author Supaluk Jaroensuk
 */
public class AddTask implements Runnable{
    /**
     * A Counter class
     */
    private Counter counter;

    /**
     * Limit to counter, as an int.
     */
    private int limit;

    /**
     * Initialize counter class and number of limit.
     * @param counter is counter class.
     * @param limit is number of counting limit.
     */
    public AddTask(Counter counter, int limit) {
        this.counter = counter;
        this.limit = limit;
    }

    /**
     * Add numbers until the limit.
     */
    @Override
    public void run() {
        for(int i=1; i<=limit; i++){
            counter.add(i);
        }
        System.out.println("Done "+Thread.currentThread().getName());
    }
}

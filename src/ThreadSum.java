import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadSum is the main class for test using thread.
 *
 * @author Supaluk Jaroensuk
 */
public class ThreadSum {

    public static void main(String[] args) {
        final int LIMIT = 1000000;
        Counter counter = new AtomicCounter();

        runThread(10, counter , LIMIT);
    }

    /**
     * Run thread for testing.
     * @param nthread is amount of thread.
     * @param counter is Counter class.
     * @param limit is limit of counting.
     */
    public static void runThread(int nthread , Counter counter, final int limit){

        ExecutorService executor = Executors.newFixedThreadPool(2*nthread);

        System.out.println("Starting threads");

        long startTime = System.nanoTime();

        for(int k=1; k<=nthread; k++){
            Runnable addTask = new AddTask(counter , limit);
            Runnable subtractTask = new SubtractTask(counter, limit);
            executor.submit(addTask);
            executor.submit(subtractTask);
        }


        double elapse = 1.0E-9*( System.nanoTime() - startTime );

        System.out.printf("Count 1 to %,d in %.6f sec\n", limit, elapse);

        System.out.printf("Counter total is %d\n" , counter.get());
    }
}

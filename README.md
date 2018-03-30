## Threads and Synchronization

This lab illustrates the problem of synchronization when many threads are operating on a shared object.  The general issue is called "thread safety", and it is a major cause of errors in computer software.

## Assignment

To the problems on the lab sheet and record your answers here.

1. Record average run times.
2. Write your explanation of the results.  Use good English and proper grammar.  Also use good Markdown formatting.

## ThreadCount run times

These are the average runtime using 3 or more runs of the application.
The Counter class is the object being shared by the threads.
The threads use the counter to add and subtract values.

| Counter class           | Limit              | Runtime (sec)   |
|:------------------------|:-------------------|-----------------|
| Unsynchronized counter  |     1,000,000      |     0.019579    |
| Using ReentrantLock     |     1,000,000      |     0.075486    |
| Syncronized method      |     1,000,000      |     0.051387    |
| AtomicLong for total    |     1,000,000      |     0.021817    |

## 1. Using unsynchronized counter object

answer the questions (1.1 - 1.3)

1.1 The total has value equals to zero and negative number.
1.2 0.015285
1.3 A program has two parts that can run concurrently so, sometimes thread return concurrent value such as thread1 
return a value and then thread2 will use the value of thread1.
  
## 2. Implications for Multi-threaded Applications

If this behavior used in a Banking application. Command of application will work at the same time such as 
when you withdraw together with your friend transfer money to you so the application may cause a mistake. 
  

## 3. Counter with ReentrantLock

answer questions 3.1 - 3.4

3.1 The total is always zero.
3.2 0.003056
3.3 This way, only a single thread can enter the synchronized block while other threads will block until the first thread exists the block.
3.4 Call to the unlock() method decrements the hold count by 1. When this count reaches zero, the resource is released.

## 4. Counter with synchronized method

answer question 4

4.1 The total is always zero.
4.2 Because a single thread can enter the synchronized section as many times as required, but a new thread can only enter 
    when no other threads are present.
4.3 The synchronized means all about different threads reading.

## 5. Counter with AtomicLong

answer question 5
5.1 While you can almost always do the same synchronization guarantees with long and proper synchronized declarations,
   AtomicLong is that the thread-safety build into the real object itself.
5.2 This works well as it utilizes a direct machine code instruction to set the value with minimum effect on the execution of other threads. The downside is that if it fails to set the value due to a race with another thread,
    it has to try again. Under high contention this can turn into a spin lock, where the thread has to continuously try and set the value in an infinite loop, until it succeeds.

## 6. Analysis of Results

answer question 6
6.1 The fastest is unsynchronized counter and the slowest is using ReentrantLock.
6.2 The application should use AtomicLong because it can be protected application by In a class that can be incremented atomically, 
   so separate threads calling its increment method do not interleave.


## 7. Using Many Threads (optional)
7 The fastest is unsynchronized counter and the slowest is using ReentrantLock.

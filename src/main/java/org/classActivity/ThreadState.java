package org.classActivity;

public class ThreadState implements Runnable{

    public static Thread t1;
    public static ThreadState obj;

    public static void main(String[] args) {
        //creating an object of the class ThreadState
        obj = new ThreadState();
        t1 = new Thread(obj);

        // thread t1 is spawned
        t1.start();

        // thread t1 is moved to the runnable state
        System.out.println("The state of the thread t1 after invoking the method start() on it - "+ t1.getState());
    }

    @Override
    public void run() {
        ThreadStateEx threadStateEx = new ThreadStateEx();
        Thread t2 = new Thread(threadStateEx);

        // thread t2 is created and is currently in the NEW state
        System.out.println("The state of the thread t2 after spawning it "+ t2.getState());

        // thread t2 is moved to the RUNNABLE state
        t2.start();
        System.out.println("The state of thread t2 after calling the method start() on it - "+ t2.getState());

        try {
            // moving the thread  t1to the start TIMED-WAITING
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The state of thread t2 after invoking the method sleep() on it - "+ t2.getState());


        try {
            // waiting for the thread t2 to complete its execution and terminate
            t2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("The state of thread t2 when it has completed it's execution or wait for too long - "+ t2.getState());

    }
}

//    This code demonstrates how different states of threads occur in Java.
//    It creates two classes, ThreadStateEx and ThreadState, where
//    ThreadState handles the main thread operations, and
//    ThreadStateEx shows how a thread (t2) transitions between different states.

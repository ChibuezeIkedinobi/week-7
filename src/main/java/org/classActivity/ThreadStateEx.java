package org.classActivity;

public class ThreadStateEx implements Runnable{

    @Override
    public void run() {

        try {
//      moving thread t2 to the state - timed waiting
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The state of state t1 while it invokes the method join() on thread t2 -" + ThreadState.t1.getState());

        try {
//      moving thread t2 to the state - timed waiting
            Thread.sleep(200);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

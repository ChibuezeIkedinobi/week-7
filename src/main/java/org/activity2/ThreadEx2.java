package org.activity2;

public class ThreadEx2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread is running");
    }

    public static void main(String[] args) {
        ThreadEx2 t2 = new ThreadEx2();
        Thread obj = new Thread(t2);

        obj.start();
    }
}

package org.activity2;

public class ThreadEx1 extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is currently running!");
    }

    public static void main(String[] args) {
        ThreadEx1 obj = new ThreadEx1();

        obj.start();
    }
}

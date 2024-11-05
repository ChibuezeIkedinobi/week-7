package org.activity2;

public class NumberPrinterMain {
    public static void main(String[] args) {
        // create two threads to print numbers concurrently

        Thread t1 = new Thread(new NumberPrinter(1, 5), "Thread -1");
        Thread t2 = new Thread(new NumberPrinter(6, 10), "Thread -2");

        t1.start();
        t2.start();
    }
}

package Joins;

import java.util.*;

public class Thread_5c extends Thread    {
        private String info;
        Vector aVector;

        public Thread_5c (Vector a,String info) {
                this.info = info;
                this.aVector=a;
        }

        public void inProtected () {
           synchronized ( aVector )     {
                System.err.println(info + ": is in protected()");
                try {
                         sleep(100);
                }
                catch (  InterruptedException e ) {
                        System.err.println("Interrupted!");
                }
                System.err.println(info + ": exit run");
           }
        }

        public void run () {
                inProtected();
        }

        public static void main (String args []) {
        	Vector aVector = new Vector();
                Thread_5c aT5_0 = new Thread_5c(aVector, "first");
                aT5_0.start();

        	aVector = new Vector();
                Thread_5c aT5_1 = new Thread_5c(aVector, "second");
                aT5_1.start();
        }
}
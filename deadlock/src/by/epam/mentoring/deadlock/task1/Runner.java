package by.epam.mentoring.deadlock.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yauheni_Kuzmianok on 2/18/2016.
 */
public class Runner
{
    static Object lock1 = new Object();
    static Object lock2 = new Object();

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new ThreadOne());
        Thread t2 = new Thread(new ThreadTwo());
        t1.start();
        t2.start();
    }

    public static class ThreadOne implements Runnable
    {
        @Override
        public void run()
        {
            synchronized (lock1)
            {
                System.out.println("Thread "+Thread.currentThread().getId()+" lock 1 lock");
                synchronized (lock2)
                {
                    System.out.println("Thread "+Thread.currentThread().getId()+" lock 2 lock");
                }
            }
        }
    }
    public static class ThreadTwo implements Runnable
    {
        @Override
        public void run()
        {
            synchronized (lock2)
            {
                System.out.println("Thread "+Thread.currentThread().getId()+" lock 2 lock");
                synchronized (lock1)
                {
                    System.out.println("Thread "+Thread.currentThread().getId()+" lock 1 lock");
                }
            }
        }
    }

}

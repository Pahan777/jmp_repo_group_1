package by.epam.mentoring.deadlock.task3;

/**
 * Created by Yauheni_Kuzmianok on 2/18/2016.
 */
public class Runner
{
    static Object a = new Object();
    static Object b = new Object();
    static Object c = new Object();
    static Object d = new Object();

    public static void main(String[] args)
    {
        Thread t1 = new Thread(new ThreadExample(a,b,1000));
        Thread t2 = new Thread(new ThreadExample(b,c,1000));
        Thread t3 = new Thread(new ThreadExample(c,d,1000));
        Thread t4 = new Thread(new ThreadExample(d,a,1000));
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }

    public static class ThreadExample implements Runnable
    {
        long time;

        Object lock1;
        Object lock2;
        public ThreadExample(Object a, Object b, long i)
        {
            lock1 = a;
            lock2 = b;
            this.time = i;
        }

        @Override
        public void run()
        {
            synchronized (lock1)
            {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Thread "+Thread.currentThread().getId()+" lock 1 lock");
                synchronized (lock2)
                {
                    System.out.println("Thread "+Thread.currentThread().getId()+" lock 2 lock");
                }
            }
        }
    }


}

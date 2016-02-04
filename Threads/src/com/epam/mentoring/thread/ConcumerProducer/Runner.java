package com.epam.mentoring.thread.ConcumerProducer;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 2/3/16
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Runner
{
    public static void main(String[] args)
    {
        Resource resource = new Resource();
        Producer producer = new Producer(resource);
        Consumer consumer = new Consumer(resource,2);
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);


        producerThread.start();
        consumerThread.start();
    }
}

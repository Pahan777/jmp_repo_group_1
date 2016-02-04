package com.epam.mentoring.thread.ConcumerProducer;

import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 2/3/16
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Producer implements Runnable
{
    public Resource resource;

    public Producer(Resource resource)
    {
        this.resource = resource;
    }

    @Override
    public void run()
    {
        Random random = new Random();
        for (int i = 0; i < 2000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            String value = String.valueOf(random.nextInt(5));
            System.out.println("producer put value"+value+" --- "+"message" + String.valueOf(i));
            resource.put("2", "message" + String.valueOf(i));
        }
    }
}

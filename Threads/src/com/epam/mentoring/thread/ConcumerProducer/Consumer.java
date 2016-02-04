package com.epam.mentoring.thread.ConcumerProducer;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 2/3/16
 * Time: 3:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Consumer implements Runnable
{
    public Resource resource;
    public Integer resourceTopicId;

    public Consumer(Resource resource ,Integer id)
    {
        this.resource = resource;
        this.resourceTopicId = id;
    }
    @Override
    public void run()
    {
        for (int i = 0; i < 200; i++) {
            try {
                Thread.sleep(10);
                System.out.println("Concumer get values by:" + resourceTopicId);
                Resource.displayList(resource.get(String.valueOf(resourceTopicId)));
            } catch (InterruptedException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }


        }
    }
}

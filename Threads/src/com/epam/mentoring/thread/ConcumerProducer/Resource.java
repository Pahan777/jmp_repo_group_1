package com.epam.mentoring.thread.ConcumerProducer;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 2/3/16
 * Time: 3:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Resource
{
    public Map<String, List<String>> map = new HashMap<String, List<String>>();

    private Object lock = new Object();

    public void put(String key, String value)
    {
        synchronized (lock)
        {
            if (map.get(key) == null) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(value);
        }
    }

    public List<String> get(String key)
    {
        synchronized (lock)
        {
            List<String> tempLis = map.get(key);
            if(map.get(key) != null)
            {
                map.remove(key);
            }
            return tempLis;
        }
    }

    public static void displayList(List<String> list)
    {
        if (list == null || list.isEmpty()) {
            System.out.println("list is empty");
            return;
        }
        System.out.print("The List is: ");
        for (String str : list) {
            System.out.print(" " + str);
        }
        System.out.println("");
    }
}

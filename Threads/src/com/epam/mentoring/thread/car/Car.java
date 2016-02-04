package com.epam.mentoring.thread.car;

import org.apache.log4j.Logger;

public class Car implements Runnable {

    private static final long MAX_DISTANCE = 10000;

    static Logger log = Logger.getLogger(Car.class);

    private long friction;
    private long distance;
    private Race race;

    public String getName()
    {
        return name;
    }

    private String name;

    public Car(String name, long friction, Race race) {
        this.name = name;
        this.friction = friction;
        this.race = race;
    }

    @Override
    public void run() {
        try {
            while (distance < MAX_DISTANCE) {
                Thread.sleep(friction);
                distance += 100;
                log.info(name + " " + distance);
            }
            race.setRaceOver(this);
        } catch (InterruptedException e) {
            log.error(e);
        }
    }

    public synchronized static void setWinner(String name)
    {
        log.info(name + " is Winner");
    }
}
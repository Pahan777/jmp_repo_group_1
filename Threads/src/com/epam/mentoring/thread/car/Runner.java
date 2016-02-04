package com.epam.mentoring.thread.car;

import org.apache.log4j.Logger;

public class Runner
{
    /** Jakarta log4j Logging instance. */
    private static final Logger LOG = Logger.getLogger(Runner.class);
    public static void main(String[] args) throws InterruptedException
    {
        Race race = new Race();
        race.addCar(new Car("car 1", 100, race));
        race.addCar(new Car("car 2", 200, race));
        race.startAllCar();
        race.disqualifySomeCar();
    }

}

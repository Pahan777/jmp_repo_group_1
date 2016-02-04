package com.epam.mentoring.thread.car;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Yauheni_Kuzmianok
 * Date: 2/3/16
 * Time: 12:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Race
{
    static Logger log = Logger.getLogger(Car.class);
    private boolean raceOver = false;

    List<Car> carList = new ArrayList<Car>();
    List<Thread> threadList = new ArrayList<Thread>();

    public void addCar(Car car)
    {
        carList.add(car);
    }

    public void startAllCar()
    {
        for (Car car : carList) {
            Thread thread = new Thread(car);
            threadList.add(thread);
            thread.start();
        }
    }
    public synchronized void setRaceOver(Car car)
    {
        if (!raceOver){
            raceOver = true;
            log.info("Winner is " + car.getName());
        }
    }
    public void disqualifySomeCar() throws InterruptedException
    {
        Thread.sleep(5000);
        Random random = new Random();
        Integer index = random.nextInt(carList.size());
        threadList.get(index).interrupt();
        log.info("com.epam.mentoring.thread.car.Car is Stopped" + carList.get(index).getName());
    }
}

package com.javarush.test.level14.lesson08.home01;

/**
 * Created by serge on 14.12.2015.
 */
public class WaterBridge implements Bridge
{
    int CarsCount = 0;
    @Override
    public int getCarsCount()
    {
        CarsCount = 15;
        return CarsCount;
    }
}

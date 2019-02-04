package com.javarush.test.level14.lesson08.home01;

/**
 * Created by serge on 14.12.2015.
 */
public class SuspensionBridge implements Bridge
{
    int CarsCount = 0;
    @Override
    public int getCarsCount()
    {
        CarsCount = 20;
        return CarsCount;
    }
}

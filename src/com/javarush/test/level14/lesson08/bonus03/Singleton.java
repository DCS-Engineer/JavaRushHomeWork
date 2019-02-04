package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by serge on 20.12.2015.
 */
public class Singleton
{
    private static Singleton ourInstance = new Singleton();

    public static Singleton getInstance()
    {
        return ourInstance;
    }

    private Singleton()
    {
    }
}

package com.javarush.test.level14.lesson08.home05;

/**
 * Created by serge on 14.12.2015.
 */
public class Keyboard implements CompItem
{
    @Override
    public String getName()
    {
        return getClass().getSimpleName();
    }
}

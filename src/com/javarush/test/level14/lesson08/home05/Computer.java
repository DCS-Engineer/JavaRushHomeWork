package com.javarush.test.level14.lesson08.home05;

/**
 * Created by serge on 14.12.2015.
 */
public class Computer
{
    private Keyboard keyboard;
    private Mouse mouse;
    private Monitor monitor;

    public Computer()
    {
        this.keyboard = new Keyboard();
        this.monitor = new Monitor();
        this.mouse = new Mouse();
    }

    public Computer(Keyboard keyboard, Mouse mouse, Monitor monitor)
    {
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.monitor = monitor;
    }

    public Keyboard getKeyboard()
    {
        return keyboard;
    }

    public Mouse getMouse()
    {
        return mouse;
    }

    public Monitor getMonitor()
    {
        return monitor;
    }
}

package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

public class Beach implements Comparable<Beach>{
        private String name;      //название
        private float distance;   //расстояние
        private int quality;    //качество

    @Override
    public synchronized int compareTo(Beach o)
    {
        return (int) (10000 * (getQuality() - o.getQuality()) + 1000 * (getDistance() - o.getDistance()) + getName().compareTo(o.getName()));
    }

    public Beach(String name, float distance, int quality) {
        synchronized (this)
        {
            this.name = name;
            this.distance = distance;
            this.quality = quality;
        }
    }

    public String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }
}

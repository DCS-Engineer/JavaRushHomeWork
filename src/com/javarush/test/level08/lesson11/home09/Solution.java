package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.print(isDateOdd("JANUARY 2 2020"));
    }

    public static boolean isDateOdd(String date)
    {
        Date beginYear = new Date("DECEMBER 31 2019");
        Date now = new Date(date);
        long mseconds = now.getTime() - beginYear.getTime();
        long days = mseconds/1000/60/60/24;
        if (days % 2 ==0)
            return false;
        else
            return true;
    }
}

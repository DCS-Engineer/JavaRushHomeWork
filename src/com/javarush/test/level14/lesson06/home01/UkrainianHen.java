package com.javarush.test.level14.lesson06.home01;

/**
 * Created by serge on 14.12.2015.
 */
public class UkrainianHen extends Hen
{
    int CountOfEggsPerMonth = 15;
    @Override
    int getCountOfEggsPerMonth()
    {
        return CountOfEggsPerMonth;
    }

    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + CountOfEggsPerMonth + " яиц в месяц.";
    }
}

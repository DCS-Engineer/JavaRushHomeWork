package com.javarush.test.level14.lesson06.home01;

/**
 * Created by serge on 14.12.2015.
 */
public class MoldovanHen extends Hen
{
    int CountOfEggsPerMonth = 18;
    @Override
    int getCountOfEggsPerMonth()
    {
        return CountOfEggsPerMonth;
    }

    @Override
    String getDescription()
    {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + CountOfEggsPerMonth + " яиц в месяц.";
    }
}

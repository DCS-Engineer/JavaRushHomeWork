package com.javarush.test.level04.lesson13.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем линии
Используя цикл for вывести на экран:
- горизонтальную линию из 10 восьмёрок
- вертикальную линию из 10 восьмёрок.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        String eight = "8";
        for (int n = 0; n < 10; n++)
            System.out.print(eight);
        System.out.println();
        for (int m = 0; m < 10; m++)
            System.out.println(eight);
        //Напишите тут ваш код

    }
}

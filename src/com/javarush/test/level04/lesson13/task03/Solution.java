package com.javarush.test.level04.lesson13.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем треугольник
Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
Пример:
8
88
888
...
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int a = 10;
        int b = 0;
        String eight = "8";
        for (a = a + 1;a > 0 && b < 11; a--)
        {
            b++;
            for (int i = 1; i < b; i++)
                System.out.print(eight);
            System.out.println();
        }
        //Напишите тут ваш код

    }
}

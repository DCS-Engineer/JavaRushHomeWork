package com.javarush.test.level04.lesson13.task02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Рисуем прямоугольник
Ввести с клавиатуры два числа m и n.
Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
Пример: m=2, n=4
8888
8888
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str_m = reader.readLine();
        int m = Integer.parseInt(str_m);
        String str_n = reader.readLine();
        int n = Integer.parseInt(str_n);
        String eight = "8";
        for (; m > 0; m--)
        {
            int i = n;
            for (; i > 0; i--)
                System.out.print(eight);
            System.out.println();
        }
        //Напишите тут ваш код

    }
}

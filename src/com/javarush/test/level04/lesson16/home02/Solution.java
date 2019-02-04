package com.javarush.test.level04.lesson16.home02;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        int n = 3;
        int[] mass = new int[n];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 3; i++)
        {
            mass[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = 0; j < i; j++)
            {
                if (mass[j] > mass[j+1])
                {
                    int tmp = mass[j];
                    mass[j] = mass[j+1];
                    mass[j+1] = tmp;
                }
            }
        }
        System.out.println(mass[1]);
        //Напишите тут ваш код
    }
}

package com.javarush.test.level05.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Написать программу, которая:
1. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите здесь ваш код
        int n = 0;
        int[] mass;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        mass = new int[n];
        for (int i = 0; i < n; i++)
            mass[i] = Integer.parseInt(reader.readLine());
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
        int maximum = mass[n-1];
        System.out.println(maximum);
    }
}

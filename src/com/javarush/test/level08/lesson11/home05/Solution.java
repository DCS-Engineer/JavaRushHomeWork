package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String[] mass = s.split(" ");
        for (int i = 0; i < mass.length; i++)
        {
            if (!mass[i].isEmpty())
            {
                String str1 = mass[i].substring(0, 1);
                String str2 = mass[i].substring(1, mass[i].length());
                str1 = str1.toUpperCase();
                mass[i] = str1 + str2;
            }
        }
        for (String temp : mass)
            System.out.print(temp+" ");
    }


}

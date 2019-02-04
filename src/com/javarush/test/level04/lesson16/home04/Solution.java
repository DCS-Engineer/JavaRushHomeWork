package com.javarush.test.level04.lesson16.home04;

/* Меня зовут 'Вася'...
Ввести с клавиатуры строку name.
Ввести с клавиатуры дату рождения (три числа): y, m, d.
Вывести на экран текст:
«Меня зовут name
Я родился d.m.y»
Пример:
Меня зовут Вася
Я родился 15.2.1988
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mass = new int[3];
        String name = reader.readLine();
        for (int i = 0; i < 3; i++)
            mass[i] = Integer.parseInt(reader.readLine());
        System.out.println("Меня зовут " + name);
        System.out.print("Я родился " + mass[2] + "." + mass[1] + "." + mass[0]);
        //Напишите тут ваш код
    }
}

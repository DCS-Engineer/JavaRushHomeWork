package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int[] mass_print = {0, 0, 0};
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str_a = reader.readLine();
        int a = Integer.parseInt(str_a);
        String str_b = reader.readLine();
        int b = Integer.parseInt(str_b);
        String str_c = reader.readLine();
        int c = Integer.parseInt(str_c);
        if (a > b)
        {
            if (a > c)
            {
                mass_print[0] = a;
                if (b > c)
                {
                    mass_print[1] = b;
                    mass_print[2] = c;
                }
                else
                {
                    mass_print[1] = c;
                    mass_print[2] = b;
                }
            }
            else
            {
                mass_print[0] = c;
                mass_print[1] = a;
                mass_print[2] = b;
            }

        }
        else
        {
            if (b > c)
            {
                mass_print[0] = b;
                if (a > c)
                {
                    mass_print[1] = a;
                    mass_print[2] = c;
                }
                else
                {
                    mass_print[1] = c;
                    mass_print[2] = a;
                }
            }
            else
            {
                mass_print[0] = c;
                mass_print[1] = b;
                mass_print[2] = a;
            }
        }
        for (int i=0;i < 3;i++)
            System.out.println(mass_print[i]);
        //Напишите тут ваш код
    }
}

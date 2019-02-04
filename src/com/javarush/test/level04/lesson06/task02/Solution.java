package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //Напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str_a = reader.readLine();
        int a = Integer.parseInt(str_a);
        String str_b = reader.readLine();
        int b = Integer.parseInt(str_b);
        String str_c = reader.readLine();
        int c = Integer.parseInt(str_c);
        String str_d = reader.readLine();
        int d = Integer.parseInt(str_d);
        if (a > b && a > c && a > d)
            System.out.println(a);
        if (b > a && b > c && b > d)
            System.out.println(b);
        if (c > a && c > b && c > d)
            System.out.println(c);
        if (d > a && d > b && d > c)
            System.out.println(d);

    }
}

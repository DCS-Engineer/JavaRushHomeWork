package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        // напишите тут ваш код
        ArrayList<Integer> evenNumbers = new ArrayList<Integer>();
        BufferedReader keyboardread = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(new FileInputStream(keyboardread.readLine()));
        while (sc.hasNextInt())
        {
            int i = sc.nextInt();
            if (i % 2 == 0) evenNumbers.add(i);
        }
        Collections.sort(evenNumbers);
        for (Integer tmp : evenNumbers)
        {
            System.out.println(tmp.intValue());
        }
        keyboardread.close();
        sc.close();
    }
}

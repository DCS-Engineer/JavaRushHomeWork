package com.javarush.test.level08.lesson08.task02;

import java.util.*;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //Напишите тут ваш код
        HashSet<Integer> set = new HashSet<Integer>();
        Collections.addAll(set, 4, 15, 23, 2, 9, 46, 22, 11, 6, 7, 14, 31, 29, 17, 18, 1, 3, 25, 26, 8);
        return set;
    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        //Напишите тут ваш код
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext())
        {
            Integer x = iterator.next();
            if (x > 10)
                iterator.remove();
        }
        return set;
    }
}

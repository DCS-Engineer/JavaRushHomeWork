package com.javarush.test.level08.lesson11.home01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        Set<Cat> cats = createCats();

        //напишите тут ваш код. пункт 3
        Iterator<Cat> iter = cats.iterator();
        Cat catt = iter.next();
        iter.remove();

        printCats(cats);
    }

    public static Set<Cat> createCats()
    {
        //напишите тут ваш код. пункт 2
        HashSet<Cat> set = new HashSet<Cat>();
        for (int i = 0; i < 3; i++)
            set.add(new Cat());
        return set;
    }

    public static void printCats(Set<Cat> cats)
    {
        // пункт 4
        for (Cat temp : cats)
        {
            System.out.println(temp);
        }
    }

    // пункт 1
    public static class Cat
    {

    }
}

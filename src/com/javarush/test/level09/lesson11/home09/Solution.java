package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        //напишите тут ваш код
        Map<String, Cat> map = new HashMap<String, Cat>();
        map.put("Васька", new Cat("Васька"));
        map.put("Барсик", new Cat("Барсик"));
        map.put("Мурзик", new Cat("Мурзик"));
        map.put("Котофей", new Cat("Котофей"));
        map.put("Снежок", new Cat("Снежок"));
        map.put("Пушок", new Cat("Пушок"));
        map.put("Жорик", new Cat("Жорик"));
        map.put("Кузя", new Cat("Кузя"));
        map.put("Тимофей", new Cat("Тимофей"));
        map.put("Саня", new Cat("Саня"));
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        //напишите тут ваш код
        Set<Cat> set = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair : map.entrySet())
        {
            set.add(pair.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }

    public static class Cat
    {
        private String name;

        public Cat(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}

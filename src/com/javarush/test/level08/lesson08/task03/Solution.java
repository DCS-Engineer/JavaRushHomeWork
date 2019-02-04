package com.javarush.test.level08.lesson08.task03;

import java.util.*;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //Напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Александр");
        map.put("Соболев", "Сергей");
        map.put("Грачев", "Сергей");
        map.put("Петров", "Иван");
        map.put("Запорожец", "Александр");
        map.put("Пушной", "Александр");
        map.put("Королев", "Валерий");
        map.put("Беляев", "Олег");
        map.put("Фоминых", "Максим");
        map.put("Терентьев", "Игорь");
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        int count = 0;
        while (iter.hasNext())
        {
            Map.Entry<String, String> pair = iter.next();
            String s = pair.getValue();
            if (s.equals(name))
                count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, String>> iter = map.entrySet().iterator();
        int count = 0;
        while (iter.hasNext())
        {
            Map.Entry<String, String> pair = iter.next();
            String s = pair.getKey();
            if (s.equals(familiya))
                count++;
        }
        return count;
    }
}

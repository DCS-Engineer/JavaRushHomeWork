package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
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

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //Напишите тут ваш код
        ArrayList<String> list = new ArrayList<String>();
        for (Map.Entry<String, String> pair: map.entrySet())
            list.add(pair.getValue());
        int count;
        for (int i = 0; i < list.size();)
        {
            count = 0;
            for (int j = 0; j < list.size(); j++)
            {
                if (list.get(i) == list.get(j))
                    count++;
            }
            if (count > 1)
            {
                removeItemFromMapByValue(map, list.get(i));
                i++;
            }
            else
                i++;
        }

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    /*//главный метод main
     public static void main(String[] args) throws Exception
    {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);
        for (Map.Entry<String, String> pair : map.entrySet())
        {
            String s = pair.getKey();
            String s2 = pair.getValue();
            System.out.println(s+"-"+s2);
        }
    }*/
}

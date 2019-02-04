package com.javarush.test.level08.lesson08.task04;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Сталлоне", new Date("JUNE 1 1980"));

        //Напишите тут ваш код
        map.put("Шварценеггер", new Date("JULY 30 1971"));
        map.put("Уиллис", new Date("MARCH 19 1971"));
        map.put("Мур", new Date("NOVEMBER 11 1971"));
        map.put("Катчер", new Date("FEBRUARY 7 1971"));
        map.put("Диаз", new Date("AUGUST 30 1971"));
        map.put("Круз", new Date("JULY 3 1971"));
        map.put("Питт", new Date("DECEMBER 18 1971"));
        map.put("Клуни", new Date("MAY 6 1971"));
        map.put("Депп", new Date("SEPTEMBER 9 1971"));
        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        //Напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
        int count = 0;
        while (iter.hasNext())
        {
            Map.Entry<String, Date> pair = iter.next();
            int month = pair.getValue().getMonth();
            if (month > 4 && month < 8 )
                iter.remove();
        }
    }

    /*public static void main(String[] args) throws Exception
    {
        HashMap<String, Date> map = createMap();
        removeAllSummerPeople(map);
        for (Map.Entry<String, Date> pair : map.entrySet())
        {
            String s = pair.getKey();
            Date date = pair.getValue();
            System.out.println(s+"-"+date);
        }
    }*/
}

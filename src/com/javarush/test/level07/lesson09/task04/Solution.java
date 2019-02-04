package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
1. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.1. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list.add("лепих");

        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }

    }

    public static ArrayList<String> fix(ArrayList<String> list)
    {
        //add your code here -  добавь код тут
        int f1, f2;
        String tmp = "";
        for (int i = 0; i < list.size();)
        {
            f1 = 0;
            f2 = 0;
            if (tmp.equals(list.get(i)))
                i++;
            else
            {
                for (int j = 0; j < list.get(i).length(); j++)
                {
                    if (list.get(i).charAt(j) == 'р')
                        f1 = f1 + 1;
                    if (list.get(i).charAt(j) == 'л')
                        f2 = f2 + 1;
                }
            }
            if (f1 > 0 && f2 == 0) list.remove(i);
            if (f2 > 0 && f1 == 0)
            {
                tmp = list.get(i);
                list.add(i, tmp);
                i = i + 2;
            }
            if (f1 == 0 && f2 == 0) i++;
            if (f1 > 0 && f2 > 0) i++;
        }
        return list;
    }
}
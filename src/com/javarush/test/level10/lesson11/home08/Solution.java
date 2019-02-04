package com.javarush.test.level10.lesson11.home08;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* Массив списков строк
Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<String>[] arrayOfStringList =  createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList()
    {
        //напишите тут ваш код
        ArrayList<String> list1 = new ArrayList<String>();
        Collections.addAll(list1, "dsf", "lkljk", "sadc", "dsfveww");
        ArrayList<String> list2 = new ArrayList<String>();
        Collections.addAll(list2, "sdfbg", "eegg", "aacff", "vbnfd");
        ArrayList<String>[] array = new ArrayList[] {list1, list2};
        return array;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList)
    {
        for (ArrayList<String> list: arrayOfStringList)
        {
            for (String s : list)
            {
                System.out.println(s);
            }
        }
    }
}
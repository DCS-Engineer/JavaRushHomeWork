package com.javarush.test.level14.lesson08.bonus01;


import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try
        {
            float i = 1 / 0;

        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        //Add your code here
        try
        {
            int[] a = {1};
            a[12] = 56;
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = null;
            byte[] a = s.getBytes();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = "";
            int a = Integer.parseInt(s);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object str[] = new String[10];
            str[0] = new Character('*');
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            Object sst = new Character('*');
            System.out.println((Byte)sst);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            int[] arr = new int[-9];
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String str = "bhd";
            char ch = str.charAt(5);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            String s = "ssssssssss";
            Date d = new Date(s);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }

        try
        {
            InputStream stream = new FileInputStream("test");
            stream.close();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
    }
}

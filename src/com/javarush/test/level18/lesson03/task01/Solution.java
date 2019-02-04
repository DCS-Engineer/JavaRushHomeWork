package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        int maxByte = 0;
        int tempByte = 0;
        FileInputStream inputStream = new FileInputStream(consolereader.readLine());
        consolereader.close();
        while (inputStream.available() > 0){
            tempByte = inputStream.read();
            if (tempByte > maxByte)
                maxByte = tempByte;
        }
        inputStream.close();
        System.out.print((byte)maxByte);
    }
}

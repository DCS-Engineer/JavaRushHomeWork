package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        int minByte = 255;
        int tempByte = 0;
        FileInputStream inputStream = new FileInputStream(consolereader.readLine());
        consolereader.close();
        while (inputStream.available() > 0){
            tempByte = inputStream.read();
            if (tempByte < minByte)
                minByte = tempByte;
        }
        System.out.print((byte)minByte);
        inputStream.close();
    }
}

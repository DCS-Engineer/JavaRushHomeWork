package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        List<Byte> listOfBytes = new ArrayList<Byte>();
        FileInputStream inputStream = new FileInputStream(consolereader.readLine());
        while (inputStream.available() > 0){
            int byteOfData = inputStream.read();
            if (!listOfBytes.contains((byte)byteOfData))
                listOfBytes.add((byte)byteOfData);
        }
        consolereader.close();
        inputStream.close();
        Collections.sort(listOfBytes);
        for (Byte temp : listOfBytes)
            System.out.print(temp + " ");
        }
}

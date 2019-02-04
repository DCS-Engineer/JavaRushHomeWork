package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> mapOfBytes = new HashMap<Integer, Integer>();
        int maxCount = 0;
        FileInputStream inputStream = new FileInputStream(consolereader.readLine());
        while (inputStream.available() > 0){
            int byteOfData = inputStream.read();
            if (mapOfBytes.containsKey(byteOfData))
                mapOfBytes.put(byteOfData, mapOfBytes.get(byteOfData) + 1);
            else
                mapOfBytes.put(byteOfData, 1);
        }
        consolereader.close();
        inputStream.close();
        for (Map.Entry<Integer, Integer> entry : mapOfBytes.entrySet()){
            int temp = entry.getValue();
            if(maxCount < temp)
                maxCount = temp;
        }
        for (Map.Entry<Integer, Integer> entry : mapOfBytes.entrySet()){
            if (entry.getValue() == maxCount)
                System.out.print(entry.getKey() + " ");
        }

    }
}

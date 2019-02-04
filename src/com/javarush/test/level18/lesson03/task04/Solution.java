package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> mapOfBytes = new HashMap<Integer, Integer>();
        int maxCount = 1;
        int minCount = 0;
        FileInputStream inputStream = new FileInputStream(consolereader.readLine());
        while (inputStream.available() > 0){
            int byteOfData = inputStream.read();
            if (mapOfBytes.containsKey(byteOfData))
            {
                maxCount = mapOfBytes.get(byteOfData) + 1;
                mapOfBytes.put(byteOfData, maxCount);
            }
            else
                mapOfBytes.put(byteOfData, 1);
        }
        if (mapOfBytes.size() == 0) maxCount = 0;
        consolereader.close();
        inputStream.close();
        minCount = maxCount;
        for (Map.Entry<Integer, Integer> entry : mapOfBytes.entrySet()){
            int temp = entry.getValue();
            if(minCount > temp)
                minCount = temp;
        }
        for (Map.Entry<Integer, Integer> entry : mapOfBytes.entrySet()){
            if (entry.getValue() == minCount)
                System.out.print(entry.getKey() + " ");
        }
    }
}

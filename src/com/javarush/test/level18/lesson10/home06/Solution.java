package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            Map<Integer, Integer> mapOfBytes = new HashMap<Integer, Integer>();
            FileInputStream inputStream = new FileInputStream(args[0]);

            while (inputStream.available() > 0)
            {
                int byteOfData = inputStream.read();
                if (mapOfBytes.containsKey(byteOfData))
                    mapOfBytes.put(byteOfData, mapOfBytes.get(byteOfData) + 1);
                else
                    mapOfBytes.put(byteOfData, 1);
            }
            inputStream.close();
            mapOfBytes = new TreeMap<>(mapOfBytes);
            for (Map.Entry<Integer, Integer> entry : mapOfBytes.entrySet()){
                System.out.println((char) ((int)entry.getKey()) + " " + entry.getValue());
            }
        }
        catch (IOException e){}
    }
}

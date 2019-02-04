package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        try
        {
            Map<String, Double> stringDoubleMap = new TreeMap<String, Double>();
            BufferedReader inputStream = new BufferedReader(new FileReader(args[0]));
            String line = "";
            double maxValue = 0.0;
            while ((line = inputStream.readLine()) != null){
                String[] tmpArray = line.split(" ");
                if (stringDoubleMap.containsKey(tmpArray[0])){
                    double temp = stringDoubleMap.get(tmpArray[0]) + Double.parseDouble(tmpArray[1]);
                    stringDoubleMap.put(tmpArray[0], temp);
                }
                else stringDoubleMap.put(tmpArray[0], Double.parseDouble(tmpArray[1]));
            }
            inputStream.close();
            for (Map.Entry<String,Double> entry : stringDoubleMap.entrySet()){
                if (entry.getValue() > maxValue) maxValue = entry.getValue();
            }
            for (Map.Entry<String,Double> entry : stringDoubleMap.entrySet())
            {
                if (entry.getValue() == maxValue) System.out.println(entry.getKey());
            }
        }
        catch (IOException e){}
    }
}

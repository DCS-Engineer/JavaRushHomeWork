package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            FileInputStream inputStream = new FileInputStream(args[0]);
            int letterAlphabetCount = 0;
            while (inputStream.available() > 0){
                int tmp = inputStream.read();
                if(tmp >= 65 && tmp <= 90 || tmp >= 97 && tmp <= 122)
                    letterAlphabetCount++;
            }
            System.out.print(letterAlphabetCount);
            inputStream.close();
        }
        catch (FileNotFoundException e){}
        catch(IOException e){}
    }
}

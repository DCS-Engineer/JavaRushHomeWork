package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        int decimalCount = 0;
        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        try
        {
            FileInputStream inputStream = new FileInputStream(consolereader.readLine());
            consolereader.close();
            if (inputStream.available() > 0){
                byte[] arrayOfBytes = new byte[inputStream.available()];
                int temp = inputStream.read(arrayOfBytes);
                for (int i = 0; i < arrayOfBytes.length; i++){
                    if (arrayOfBytes[i] == 44) decimalCount++;
                }
            }
            inputStream.close();
            System.out.print(decimalCount);
        }
        catch (IOException e){}

    }
}

package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = consolereader.readLine();
            String file2 = consolereader.readLine();
            consolereader.close();
            FileInputStream inputStream = new FileInputStream(file1);
            FileOutputStream outputStream = new FileOutputStream(file2);

            if (inputStream.available() > 0)
            {
                byte[] array = new byte[inputStream.available()];
                int count = inputStream.read(array);
                for (int i = array.length - 1; i >= 0; i--)
                    outputStream.write(array[i]);
            }
            inputStream.close();
            outputStream.close();
        }
        catch (IOException e){}
    }
}

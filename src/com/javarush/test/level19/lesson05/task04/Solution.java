package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = consolereader.readLine();
            String file2 = consolereader.readLine();
            consolereader.close();
            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2);
            while (fileReader.ready()){
                int data = fileReader.read();
                if (data == 46) data = 33;
                fileWriter.write(data);
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (IOException e){}
    }
}

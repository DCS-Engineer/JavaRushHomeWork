package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
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
            int count = 0;
            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2);
            while (fileReader.ready()){
                int data = fileReader.read();
                count++;
                if (count % 2 == 0) fileWriter.write(data);
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (IOException e){}
    }
}

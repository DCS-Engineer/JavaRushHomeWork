package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
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
            FileInputStream inputStream1 = new FileInputStream(file1);
            FileInputStream inputStream2 = new FileInputStream(file2);
            byte[] bufferCommon = new byte[inputStream1.available() + inputStream2.available()];
            int count1 = 0;
            if (inputStream2.available() > 0)
            {
                count1 = inputStream2.read(bufferCommon);
            }
            inputStream2.close();
            int count2 = 0;
            if (inputStream1.available() > 0)
            {
                count2 = inputStream1.read(bufferCommon, count1, inputStream1.available());
            }
            inputStream1.close();
            FileOutputStream outputStream = new FileOutputStream(file1);
            outputStream.write(bufferCommon);
            outputStream.close();
        }
        catch (IOException e){}
    }
}

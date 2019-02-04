package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
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
            String file3 = consolereader.readLine();
            consolereader.close();
            FileOutputStream outputStream = new FileOutputStream(file1);
            FileInputStream inputStream1 = new FileInputStream(file2);
            FileInputStream inputStream2 = new FileInputStream(file3);
            if (inputStream1.available() > 0)
            {
                byte[] buffer = new byte[inputStream1.available()];
                int count = inputStream1.read(buffer);
                outputStream.write(buffer);
            }
            inputStream1.close();
            if (inputStream2.available() > 0)
            {
                byte[] buffer = new byte[inputStream2.available()];
                int count = inputStream2.read(buffer);
                outputStream.write(buffer);
            }
            inputStream2.close();
            outputStream.close();
        }
        catch (IOException e){}
    }
}

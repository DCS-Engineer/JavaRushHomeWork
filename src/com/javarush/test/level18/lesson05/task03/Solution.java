package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
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
            FileInputStream inputStream = new FileInputStream(file1);
            FileOutputStream outputStream1 = new FileOutputStream(file2);
            FileOutputStream outputStream2 = new FileOutputStream(file3);

            if (inputStream.available() > 0)
            {
                byte[] array = new byte[inputStream.available()];
                int count = inputStream.read(array);
                if (count % 2 == 0){
                    outputStream1.write(array, 0, count / 2);
                    outputStream2.write(array, count / 2, count / 2);
                }
                else {
                    outputStream1.write(array, 0, (count / 2) + 1);
                    outputStream2.write(array, (count / 2) + 1, count / 2);
                }
            }
            inputStream.close();
            outputStream1.close();
            outputStream2.close();
        }
        catch (IOException e){}

    }
}

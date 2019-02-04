package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
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
            BufferedReader inputStream = new BufferedReader(new FileReader(file1));
            String[] arrayStrings = inputStream.readLine().split(" ");
            inputStream.close();
            for (int i = 0; i < arrayStrings.length; i++)
                arrayStrings[i] = String.valueOf((int)Math.round(Double.parseDouble(arrayStrings[i])));
            BufferedWriter outputStream = new BufferedWriter(new FileWriter(file2));
            String outString = "";
            for (int i = 0; i < arrayStrings.length; i++)
                outString = outString + arrayStrings[i] + " ";
            outputStream.write(outString, 0, outString.length());
            outputStream.close();
        }
        catch (IOException e){}
    }
}

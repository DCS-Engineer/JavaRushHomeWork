package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = consolereader.readLine();
            String file2 = consolereader.readLine();
            consolereader.close();
            String line = "";
            Pattern p = Pattern.compile("[0-9]+");
            BufferedReader fileReader = new BufferedReader(new FileReader(file1));
            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
            while ((line = fileReader.readLine()) != null){
                String[] arrayTemp = line.split(" ");
                for (String temp : arrayTemp){
                    Matcher m = p.matcher(temp);
                    if (m.matches()) fileWriter.write(temp + " ");
                }
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (IOException e){}
    }
}

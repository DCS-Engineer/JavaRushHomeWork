package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(args[1]));
            String line = "";
            String writeLine = "";
            while ((line = bufferedFileReader.readLine()) != null){
                String[] tmpArray = line.split(" ");
                for (String temp : tmpArray)
                    if (temp.length() > 6) writeLine += temp + ",";
            }
            writeLine = writeLine.substring(0, writeLine.length() - 1);
            bufferedFileWriter.write(writeLine);
            bufferedFileReader.close();
            bufferedFileWriter.close();
        }
        catch (IOException e){}
    }
}

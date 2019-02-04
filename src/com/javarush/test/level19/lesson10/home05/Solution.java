package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try
        {
            String line = "";
            String writeLine = "";
            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter bufferedFileWriter = new BufferedWriter(new FileWriter(args[1]));
            Pattern p = Pattern.compile(".?[0-9].?");
            Matcher m;
            while ((line = bufferedFileReader.readLine()) != null){
                String[] tmpArray = line.split(" ");
                for (String temp : tmpArray)
                {
                    m = p.matcher(temp);
                    if (m.find()) writeLine += temp + " ";
                }
            }
            bufferedFileWriter.write(writeLine);
            bufferedFileReader.close();
            bufferedFileWriter.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }
}

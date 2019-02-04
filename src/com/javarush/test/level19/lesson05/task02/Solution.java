package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            String file = consolereader.readLine();
            consolereader.close();
            String line = "";
            int countMatches = 0;
            Pattern p = Pattern.compile("(world)");
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            while ((line = fileReader.readLine()) != null){
                String[] tmpArray = line.split("[., !?;:-]");
                for (String tmp : tmpArray){
                    Matcher m = p.matcher(tmp);
                    if (m.matches()) countMatches++;
                }
            }
            fileReader.close();
            System.out.print(countMatches);
        }
        catch (IOException e){}
    }
}

package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
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
            String file1 = consolereader.readLine();
            String file2 = consolereader.readLine();
            consolereader.close();
            Pattern p = Pattern.compile("\\p{Punct}|(\\u000A)");
            FileReader fileReader = new FileReader(file1);
            FileWriter fileWriter = new FileWriter(file2);
            while (fileReader.ready()){
                int data = fileReader.read();
                Matcher m = p.matcher(String.valueOf((char) data));
                if (m.matches()) continue;
                fileWriter.write(data);
            }
            fileReader.close();
            fileWriter.close();
        }
        catch (IOException e){}
    }
}

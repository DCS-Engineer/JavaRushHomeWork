package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = "c:/Tests/1.txt"; //consoleReader.readLine();
            consoleReader.close();
            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));

            Pattern p = Pattern.compile("(<[s][p][a][n]>(\\p{Graph}|\\p{Space})+</[s][p][a][n]>)");
            Matcher m;
            String line = "";
            String completeString = "";
            while ((line = bufferedFileReader.readLine()) != null){
                completeString = completeString + line;
            }
            bufferedFileReader.close();
            m = p.matcher("<span><span>Turanga Leela</span></b></span><span>Super</span><span>girl</span>");
            m.find();
            for (int i = 0; i < m.groupCount(); i++) System.out.println(m.group(i));
            System.out.println(m.groupCount());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}

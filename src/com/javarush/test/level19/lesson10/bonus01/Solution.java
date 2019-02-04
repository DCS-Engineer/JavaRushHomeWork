package com.javarush.test.level19.lesson10.bonus01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Отслеживаем изменения
Считать в консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
Пример:
оригинальный   редактированный    общий
file1:         file2:             результат:(lines)

строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
строка4                           REMOVED строка4
строка5        строка5            SAME строка5
               строка0            ADDED строка0
строка1        строка1            SAME строка1
строка2                           REMOVED строка2
строка3        строка3            SAME строка3
               строка5            ADDED строка5
строка4        строка4            SAME строка4
строка5                           REMOVED строка5
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        try
        {
            List<String> listOfFile1 = new ArrayList<String>();
            List<String> listOfFile2 = new ArrayList<String>();
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            String file1 = "d:/1.txt"; //consoleReader.readLine();
            String file2 = "d:/2.txt"; //consoleReader.readLine();
            consoleReader.close();
            BufferedReader bufferedFile1Reader = new BufferedReader(new FileReader(file1));
            BufferedReader bufferedFile2Reader = new BufferedReader(new FileReader(file2));
            while (bufferedFile1Reader.ready()){
                listOfFile1.add(bufferedFile1Reader.readLine());
            }
            bufferedFile1Reader.close();
            while (bufferedFile2Reader.ready()){
                listOfFile2.add(bufferedFile2Reader.readLine());
            }
            bufferedFile2Reader.close();
            int i = 0;
            int j = 0;
            for (; j < listOfFile1.size();){
                if (i == listOfFile2.size()){
                    lines.add(new LineItem(Type.REMOVED, listOfFile1.get(j)));
                    j++;
                }
                else
                {
                    if (listOfFile1.get(j).equals(listOfFile2.get(i)))
                    {
                        lines.add(new LineItem(Type.SAME, listOfFile1.get(j)));
                        i++;
                        j++;
                        continue;
                    } else if (!listOfFile1.get(j).equals(listOfFile2.get(i)))
                    {
                        if (!listOfFile1.get(j).equals(listOfFile2.get(i + 1)))
                        {
                            lines.add(new LineItem(Type.REMOVED, listOfFile1.get(j)));
                            j++;
                            continue;
                        } else if (listOfFile1.get(j).equals(listOfFile2.get(i + 1)))
                        {
                            lines.add(new LineItem(Type.ADDED, listOfFile2.get(i)));
                            i++;
                            continue;
                        }
                    }
                }
            }
            for (LineItem temp: lines) System.out.println(temp.type + " " + temp.line);
        }
        catch (IOException e){}
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}

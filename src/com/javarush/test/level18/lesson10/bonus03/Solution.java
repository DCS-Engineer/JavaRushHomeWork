package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        try{
            int id = 0;
            String line = null;
            StringBuilder sb = new StringBuilder();
            Pattern p = Pattern.compile("^(\\uFEFE)?(\\d+)");

            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = consolereader.readLine();
            consolereader.close();

            if ("-u".equals(args[0])){
                BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
                while ((line = inputStream.readLine()) != null){
                    int tempID = 0;
                    Matcher m = p.matcher(line);
                    boolean find = m.find();
                    if (find){
                        tempID = Integer.parseInt(line.substring(m.start(), m.end()));
                        if (tempID == Integer.parseInt(args[1])){
                            sb.append(args[1]);
                            if (args[1].length() < 8)
                                for (int i = 0; i < (8 - args[1].length()); i++)
                                    sb.append(" ");
                            if (args[2].length() < 30)
                            {
                                sb.append(args[2]);
                                for (int i = 0; i < (30 - args[2].length()); i++)
                                    sb.append(" ");
                            }
                            else if (args[2].length() >= 30)
                                sb.append(args[2].substring(0, 30));
                            sb.append(args[3]);
                            if (args[3].length() < 8)
                                for (int i = 0; i < (8 - args[3].length()); i++)
                                    sb.append(" ");
                            sb.append(args[4]);
                            if (args[4].length() < 4)
                                for (int i = 0; i < (4 - args[4].length()); i++)
                                    sb.append(" ");
                            sb.append("\n");
                        }
                        else sb.append(line + "\n");
                    }
                }
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(fileName);
                outputStream.write(sb.toString().getBytes());
                outputStream.close();
            }

            if ("-d".equals(args[0])){
                BufferedReader inputStream = new BufferedReader(new FileReader(fileName));
                while ((line = inputStream.readLine()) != null){
                    int tempID = 0;
                    Matcher m = p.matcher(line);
                    boolean find = m.find();
                    if (find){
                        tempID = Integer.parseInt(line.substring(m.start(), m.end()));
                        if (tempID != Integer.parseInt(args[1]))sb.append(line + "\n");
                    }
                }
                inputStream.close();
                FileOutputStream outputStream = new FileOutputStream(fileName);
                outputStream.write(sb.toString().getBytes());
                outputStream.close();
            }
        }
        catch (IOException e){}
    }
}

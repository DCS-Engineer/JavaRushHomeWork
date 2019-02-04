package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

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
    public static void main(String[] args) throws Exception {
        int maxID = 0;
        StringBuilder lineToWrite = new StringBuilder(50);
        String line = null;

        BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = consolereader.readLine();
        consolereader.close();

        Pattern p = Pattern.compile("^(\\uFEFE)?(\\d+)");
        BufferedReader inputStream = new BufferedReader(new FileReader(fileName));

        while ((line = inputStream.readLine()) != null){
            Matcher m = p.matcher(line);
            int tempID = 0;
            boolean find = m.find();
            if (find){
                tempID = Integer.parseInt(line.substring(m.start(), m.end()));
                if (maxID < tempID) maxID = tempID;
            }
        }
        inputStream.close();


        if ("-c".equals(args[0])){
            String idString = String.valueOf(++maxID);
            lineToWrite.append(idString);
            if (idString.length() < 8)
                for (int i = 0; i < (8 - idString.length()); i++)
                    lineToWrite.append(" ");
            if (args[1].length() < 30)
            {
                lineToWrite.append(args[1]);
                for (int i = 0; i < (30 - args[1].length()); i++)
                    lineToWrite.append(" ");
            }
            else if (args[1].length() >= 30)
                lineToWrite.append(args[1].substring(0, 30));
            lineToWrite.append(args[2]);
            if (args[2].length() < 8){
                for (int i = 0; i < (8 - args[2].length()); i++)
                    lineToWrite.append(" ");
            }
            lineToWrite.append(args[3]);
            if (args[3].length() < 4){
                for (int i = 0; i < (4 - args[3].length()); i++)
                    lineToWrite.append(" ");
            }
            lineToWrite.append("\n");
        }
        FileOutputStream outputStream = new FileOutputStream(fileName, true);
        outputStream.write(lineToWrite.toString().getBytes());
        outputStream.close();
    }
}

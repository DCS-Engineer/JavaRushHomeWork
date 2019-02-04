package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void main(String[] args) {
        try
        {
            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            FileInputStream inputStream = null;
            byte[] buffer = null;
            List<String> fileList = new ArrayList<String>();
            String inputString = "";
            String fileOutputName = null;
            while (!("end".equals(inputString = consolereader.readLine())))
            {
                fileList.add(inputString);
                if (fileOutputName == null)
                {
                    fileOutputName = inputString;
                }
            }
            consolereader.close();
            Collections.sort(fileList, new Comparator<String>()
            {
                @Override
                public int compare(String o1, String o2)
                {
                    Pattern p = Pattern.compile("\\d+$");
                    Matcher m1 = p.matcher(o1);
                    m1.find();
                    Matcher m2 = p.matcher(o2);
                    m2.find();
                    int o1num = Integer.parseInt(o1.substring(m1.start(), m1.end()));
                    int o2num = Integer.parseInt(o2.substring(m2.start(), m2.end()));
                    if (o1num < o2num) return -1;
                    else if ((o1num > o2num)) return 1;
                    return 0;
                }
            });
            File commonFile = new File(fileOutputName.substring(0, fileOutputName.indexOf(".part")));
            commonFile.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(commonFile);
            for (int i = 0; i < fileList.size(); i++){
                inputStream = new FileInputStream(fileList.get(i));
                if (inputStream.available() > 0){
                    buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    outputStream.write(buffer);
                }
            }
            outputStream.close();
            inputStream.close();
        }
        catch (IOException e){}
    }
}

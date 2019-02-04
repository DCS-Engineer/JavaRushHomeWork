package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;


public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader keyboardread = new BufferedReader(new InputStreamReader(System.in));
        String fileName = keyboardread.readLine();
        OutputStream writestream = new FileOutputStream(fileName);
        Boolean exit = false;
        while (!exit)
        {
            String tmp = keyboardread.readLine();
            if (tmp.equals("exit"))
            {
               exit = true;
            }
            String lineseparator = System.getProperty("line.separator");
            tmp = tmp + lineseparator;
            writestream.write(tmp.getBytes());

        }
        writestream.close();
        keyboardread.close();
    }
}

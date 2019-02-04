package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    private static boolean isExit = false;
    public static void main(String[] args) {
        try
        {
            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            while (!isExit)
            {
                String fileName = consolereader.readLine();
                File file = new File(fileName);
                if (!file.exists()){
                    System.out.print(fileName);
                    throw new FileNotFoundException();
                }
            }
            consolereader.close();
        }
        catch (FileNotFoundException e){
            isExit = true;
        }
        catch (IOException e){}
    }
}

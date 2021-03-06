package com.javarush.test.level19.lesson10.home08;

/* Перевертыши
1 Считать с консоли имя файла.
2 Для каждой строки в файле:
2.1 переставить все символы в обратном порядке
2.2 вывести на экран
3 Закрыть потоки. Не использовать try-with-resources

Пример тела входного файла:
я - программист.
Амиго

Пример результата:
.тсиммаргорп - я
огимА
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            bufferedReader.close();
            BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
            String outLine = "";
            String line = "";
            while ((line = bufferedFileReader.readLine()) != null){
                outLine = new StringBuffer(line).reverse().toString();
                System.out.println(outLine);
            }
            bufferedFileReader.close();
        }
        catch (IOException e){}
    }
}

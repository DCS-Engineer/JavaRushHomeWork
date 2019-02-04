package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //add your code here
        try {
            ArrayList<String> tmpList = new ArrayList<String>();
            ArrayList<String> parameters = new ArrayList<String>();
            String[] str;
            BufferedReader keyboardread = new BufferedReader(new InputStreamReader(System.in));
            String s = keyboardread.readLine();
            int n = s.indexOf("?");
            s = s.substring(n + 1);
            for (String tmp: s.split("&"))
                tmpList.add(tmp);
            for (int i = 0; i < tmpList.size();i++){
                str = tmpList.get(i).split("=");
                if (str[0].equals("obj"))
                {
                    System.out.print(str[0] + " ");
                    parameters.add(str[1]);
                }
                else System.out.print(str[0] + " ");
            }
            System.out.println();
            for (int i = 0; i < parameters.size();i++){
                try
                {
                    alert(Double.parseDouble(parameters.get(i)));
                }
                catch (NumberFormatException e){
                    alert(parameters.get(i));
                }
            }
        }
        catch (IOException e){

        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}

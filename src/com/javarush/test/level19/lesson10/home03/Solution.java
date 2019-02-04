package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try
        {
            BufferedReader inputStream = new BufferedReader(new FileReader(args[0]));
            String line = "";
            while ((line = inputStream.readLine()) != null){
                String[] parArray = line.split(" ");
                String name = "";
                for (int i = 0; i < (parArray.length - 3 ); i++) name += parArray[i] + " ";
                name = name.substring(0, name.length() - 1);
                int YEAR = Integer.parseInt(parArray[parArray.length - 1]);
                int MONTH = Integer.parseInt(parArray[parArray.length - 2]);
                int DAY = Integer.parseInt(parArray[parArray.length - 3]);
                Calendar calendar = new GregorianCalendar(YEAR, MONTH - 1, DAY);
                PEOPLE.add(new Person(name, calendar.getTime()));
            }
            inputStream.close();
        }
        catch (IOException e){}
    }

}

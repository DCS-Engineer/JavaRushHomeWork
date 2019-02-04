package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
        try
        {
            FileInputStream inputStream = new FileInputStream(args[1]);
            FileOutputStream outputStream = new FileOutputStream(args[2]);
            int numberConst = 22;
            if ("-e".equals(args[0])){
                while (inputStream.available() > 0){
                    int readByte = inputStream.read() + numberConst;
                    outputStream.write(readByte);
                }
            }
            else if ("-d".equals(args[0])){
                while (inputStream.available() > 0){
                    int readByte = inputStream.read() - numberConst;
                    outputStream.write(readByte);
                }
            }
            inputStream.close();
            outputStream.close();
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
    }

}

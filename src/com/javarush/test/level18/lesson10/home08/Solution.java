package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        try
        {
            BufferedReader consolereader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = "";
            while (!(fileName = consolereader.readLine()).equals("exit")){
                new ReadThread(fileName).start();
            }
            consolereader.close();
        }
        catch (IOException e){}

    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run()
        {
            try
            {
                Map<Integer, Integer> mapOfBytes = new HashMap<Integer, Integer>();
                int maxCount = 0;
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0){
                    int byteOfData = inputStream.read();
                    if (mapOfBytes.containsKey(byteOfData))
                        mapOfBytes.put(byteOfData, mapOfBytes.get(byteOfData) + 1);
                    else
                        mapOfBytes.put(byteOfData, 1);
                }
                inputStream.close();
                for (Map.Entry<Integer, Integer> entry : mapOfBytes.entrySet()){
                    int temp = entry.getValue();
                    if(maxCount < temp)
                        maxCount = temp;
                }
                for (Map.Entry<Integer, Integer> entry : mapOfBytes.entrySet()){
                    if (entry.getValue() == maxCount)
                        synchronized (this)
                        {
                            resultMap.put(fileName, entry.getKey());
                        }
                }
            }
            catch (FileNotFoundException e){}
            catch (IOException e){}
        }
    }
}

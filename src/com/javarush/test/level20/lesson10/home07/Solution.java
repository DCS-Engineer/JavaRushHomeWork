package com.javarush.test.level20.lesson10.home07;

import java.io.*;

/* Переопределение сериализации в потоке
Сериализация/десериализация Solution не работает.
Исправьте ошибки не меняя сигнатуры методов и класса.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать экземпляр класса Solution
2) записать в него данные  - writeObject
3) сериализовать класс Solution  - writeObject(ObjectOutputStream out)
4) десериализовать, получаем новый объект
5) записать в новый объект данные - writeObject
6) проверить, что в файле есть данные из п.2 и п.5
*/
public class Solution implements Serializable, AutoCloseable {
    transient private FileOutputStream stream;
    private String fileName;

    public static void main(String args[]) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("c://Tests/2.txt");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);

        Solution tempSolution = new Solution("c://Tests/1.txt");
        tempSolution.writeObject("javarush");
        outputStream.writeObject(tempSolution);

        outputStream.close();
        fileOutputStream.close();

        FileInputStream fileInputStream = new FileInputStream("c://Tests/2.txt");
        Solution deserializedSolution = null;

        ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
        deserializedSolution = (Solution) inputStream.readObject();
        deserializedSolution.writeObject("it is working");

        inputStream.close();
        fileInputStream.close();
    }
    public Solution(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.stream = new FileOutputStream(fileName);
    }
    public Solution(){
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(this.fileName);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream((String) in.readObject(),true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }
}

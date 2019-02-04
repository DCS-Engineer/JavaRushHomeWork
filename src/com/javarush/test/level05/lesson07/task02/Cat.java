package com.javarush.test.level05.lesson07.task02;

/* Создать класс Cat
Создать класс Cat (кот) с пятью инициализаторами:
- Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст неизвестны, это бездомный кот)
- вес, цвет, адрес ( чужой домашний кот)
Задача инициализатора – сделать объект валидным. Например, если вес неизвестен, то нужно указать какой-нибудь средний вес. Кот не может ничего не весить. То же касательно возраста. А вот имени может и не быть (null). То же касается адреса: null.
*/

public class Cat
{
    //Напишите тут ваш код
    public int weight = 10;
    public int age = 4;
    public String name = null;
    public String address = null;

    public void initialize(String name)
    {

    }

    public void initialize(String name,int weight, int age)
    {

    }

    public void initialize(String name, int age)
    {

    }

    public void initialize(int weight, String color)
    {

    }

    public void initialize(int weight, String color, String address)
    {

    }
}

package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        ArrayList<Human> empty = new ArrayList<Human>();
        Human child1 = new Human("Василий", true, 5, empty);
        Human child2 = new Human("Жанна", false, 8, empty);
        Human child3 = new Human("Дмитрий", true, 12, empty);
        ArrayList<Human> children = new ArrayList<Human>();
        Collections.addAll(children, child1, child2, child3);

        Human father = new Human("Борис", true, 30, children);
        Human mother = new Human("Виктория", false, 28, children);
        ArrayList<Human> parent1 = new ArrayList<Human>();
        parent1.add(father);
        ArrayList<Human> parent2 = new ArrayList<Human>();
        parent2.add(mother);
        Human grandfather1 = new Human("Александр", true, 59, parent1);
        Human grandmother1 = new Human("Тамара", false, 58, parent1);
        Human grandfather2 = new Human("Прохор", true, 61, parent2);
        Human grandmother2 = new Human("Галина", false, 60, parent2);

        System.out.println(grandfather1.toString());
        System.out.println(grandfather2.toString());
        System.out.println(grandmother1.toString());
        System.out.println(grandmother2.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
    }

    public static class Human
    {
        //напишите тут ваш код
        public String name;
        public Boolean sex;
        public int age;
        public ArrayList<Human> children;

        public Human(String name, Boolean sex, int age, ArrayList<Human> children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}

package com.javarush.test.level08.lesson08.task01;

import java.util.*;

/* 20 слов на букву «Л»
Создать множество строк (Set<String>), занести в него 20 слов на букву «Л».
*/

public class Solution
{
    public static HashSet<String> createSet()
    {
        //Напишите тут ваш код
        HashSet<String> set = new HashSet<String>();
        Collections.addAll(set, "лук", "лимон", "лес", "лояльность", "лето", "ласты", "лента", "ланч", "лира", "лоб", "лик", "леопард", "лиса", "лист", "луч", "ларец", "лото", "луна", "люк", "ларек");
        return set;
    }
}

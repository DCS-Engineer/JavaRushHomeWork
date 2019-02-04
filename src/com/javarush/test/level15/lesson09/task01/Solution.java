package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 1
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(3.14, "Pi");
        labels.put(9.8, "Uskorenie svobodnogo padeniya");
        labels.put(1.23, "dfdf");
        labels.put(6.45, "gahkdkdj");
        labels.put(4.1, "aassssa");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}

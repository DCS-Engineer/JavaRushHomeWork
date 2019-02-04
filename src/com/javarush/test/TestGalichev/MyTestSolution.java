package com.javarush.test.TestGalichev;

/**
 * Created by zgsv02 on 17.05.2016.
 */
public class MyTestSolution
{
    public static void main(String[] args){
        byte[] bytesOfNum = "+38(050)123-45-67".getBytes();
        String number = "";
        for (byte tmp : bytesOfNum){
            if(tmp >= 48 && tmp <= 57)
                number += (char) tmp;
        }
        System.out.println(number);
    }
}

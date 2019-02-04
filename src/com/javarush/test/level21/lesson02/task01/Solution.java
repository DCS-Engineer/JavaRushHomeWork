package com.javarush.test.level21.lesson02.task01;

/* Определяем адрес сети
1) Даны IP-адрес и маска подсети, необходимо вычислить адрес сети - метод getNetAddress.
Используйте операцию поразрядной конъюнкции (логическое И).
Пример:
IP-адрес:       11000000 10101000 00000001 00000010 (192.168.1.2)
Маска подсети:  11111111 11111111 11111110 00000000 (255.255.254.0)
Адрес сети:     11000000 10101000 00000000 00000000 (192.168.0.0)
2) Реализовать метод print, который выведет в консоль данные в двоичном коде
3) Метод main не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        return new byte[]{(byte)(ip[0] & mask[0]), (byte)(ip[1] & mask[1]), (byte)((int) ip[2] & (int) mask[2]), (byte)((int) ip[3] & (int) mask[3])};
    }

    public static void print(byte[] bytes) {
        for (int i = 0; i < bytes.length; i++){
            String binaryString = Integer.toBinaryString(bytes[i]);
            if (binaryString.length() >= 8) System.out.print(binaryString.substring(binaryString.length() - 8, binaryString.length()) + " ");
            else if (binaryString.length() < 8){
                String temp = "";
                for (int j = 0; j < 8 - binaryString.length(); j++) temp += "0";
                System.out.print(temp + binaryString + " ");
            }
        }
        System.out.println();
    }
}

package com.javarush.task.task21.task2101;

/* 
Определяем адрес сети
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
        byte[] netAddress = new byte[4];
        for (int i = 0; i < 4; i++) {
            netAddress[i] = (byte) (ip[i] & mask[i]);
        }
        return netAddress;
    }

    public static void print(byte[] bytes) {
        String res = "";
        for (int i = 0; i < 4; i++) {
            StringBuilder temp = new StringBuilder("");
            byte tmp = bytes[i], tmpp;
            for (int j = 0; j < 8; j++) {
                tmpp = (byte) (tmp & 1);
                temp.append(tmpp);
                tmp = (byte) (tmp >> 1);
            }
            temp.reverse();
            res = res + temp.toString() + " ";
        }
        System.out.println(res);
    }
}

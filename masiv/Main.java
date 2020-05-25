package com.masiv;


import com.masiv.util.PrintArray;

public class Main {

    public static void main(String[] args)  {

        Prime p = new Prime();
        p.findPrimos(1000);
        PrintArray pa= new PrintArray(10,10);
        pa.printData(p.getPrimos());

    }



}

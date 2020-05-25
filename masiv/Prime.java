package com.masiv;

import com.masiv.util.PrintArray;

public class Prime {

    private boolean prime;
    private int ord;
    private int squere;
    private int n =0;

    private static int primos[];
    private static int multiplos[];

    public void findPrimos(int firstsPrimes){
        primos = new int[firstsPrimes+1];
        int numero=1;
        int index=1;
        primos[1] = 2;
        ord = 2;
        squere = 9;
        Integer initMultiplos=  (int) Math.ceil(firstsPrimes*0.03);
        multiplos = new int[initMultiplos];
        while (index < firstsPrimes) {
            do {
            numero += 2;
            getMultipleSquare(primos,numero);
            n =2;
            prime=true;
                isPrime(primos, multiplos,numero);
            } while (!prime);
            index++;
            primos[index]=numero;
        }

    }
    
    /**
     * calcula los multiplos por si mismo (el cuadrado)
     */
    
    private void getMultipleSquare(int[] p, int num) {
        if( num == squere) {
            ord++;
            squere= p[ord]* p[ord];
            multiplos[n]=num;
        }
    }

     /**
     * valida si es primo
     */

    private void isPrime(int[] p, int[]  mult, int numero) {
        while (n < ord && prime) {
            getMultiple(p,numero);
            if (mult[n] == numero)
                prime=false;
            n++;
        }
    }

    /**
     * agrega los numeros multiplos al arreglo de multiplos
     */
    
    private void getMultiple(int[] p, int j) {
        while (multiplos[n]<j)
            multiplos[n] += 2 *  p[n];
    }


    public static int[] getPrimos() {
        return primos;
    }

}

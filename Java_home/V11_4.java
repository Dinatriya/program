package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//        x = Math.toRadians(x);
        double a, b=1, z=1;
        int n=0;

        Scanner in = new Scanner(System.in);
        System.out.print("Введите x (Значение): ");
        double x = in.nextDouble();
        //System.out.printf("Your number: %f \n", x);
        System.out.print("Введите e (Точность): ");
        double e = in.nextDouble();
        //System.out.printf("Your number: %f\n", e);
        in.close();


        a=(Math.exp(x)+ Math.exp(-x))/2;
        do{
            z*=(x*x)/((2*n + 1)*(2*n + 2));
            b+=z;
            n++;
        }while(Math.abs(a-b) > e);
        System.out.print("Решение по написанной функции: \n");
        System.out.println(a);
        System.out.println("Решение по встроенной функции Math.cosh(" + x + ")=\n" + Math.cosh(x));

        /*

        double x, a, e, b=1, z=1;
        int n=0;
        Scanner in = new Scanner(System.in);
        x= in.nextDouble();
        e= in.nextDouble();
        a=(Math.exp(x)+ Math.exp(-x))/2;
        do{
            z*=(x*x)/((2*n + 1)*(2*n + 2));
            b+=z;
            n++;
        }while(Math.abs(a-b) > e);
        System.out.println(a);
        System.out.println(b);
        System.out.println(n);

        */

    }
}

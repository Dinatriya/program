/*Задана строка символов.
Требуется удалить из нее повторяющиеся символы и все пробелы.
Например, если введена строка "ввв_арр_рбд",
то должна получиться новая строка "варбд" */

package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String str = "ggg hhh fff";
        String newStr = str.replace(" ", "");
        System.out.println(newStr);
        int i;
        StringBuilder sb = new StringBuilder(newStr);
        char c1;
        char c2;
        for (i = 0; i < sb.length(); i++) {
            c1 = sb.charAt(i);
            for (int j = sb.length() - 1; j > i; j--) {
                c2 = sb.charAt(j);
                if (c1 == c2) {
                    sb.deleteCharAt(j);
                }
            }
        }
        System.out.println("Результат: "+sb.toString());
    }
}

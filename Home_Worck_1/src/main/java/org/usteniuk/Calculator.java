package org.usteniuk;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        double firstVar = Double.parseDouble(new String(scanner.next()));
        System.out.print("Введите второе число: ");
        int secondVar = Integer.parseInt(new String(scanner.next()));

        System.out.println("Сумма этих двух чисел = "+ (firstVar + secondVar));
        System.out.println("Разность этих двух чисел = " + (firstVar - secondVar));
        System.out.println("Произведение этих двух чисел = "+ (firstVar * secondVar));
        System.out.println("Частное этих двух чисел = "+ (firstVar / secondVar));
        System.out.println("Остаток от деления этих двух чисел = "+ (firstVar % secondVar));


    }

}

package org.usteniuk;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NewCalc {

    public static Scanner scanner = new Scanner(System.in);
    public static List<String> result = new ArrayList<String>();

    public static void main(String[] args) {
        fillingList();

        int firstVar = Integer.parseInt(result.get(0));
        int secondVar = Integer.parseInt(result.get(2));
        int act = action(firstVar, secondVar, result.get(1));

        System.out.println(String.format("Результат: " + " %d %s %d = %d", firstVar, result.get(1), secondVar, act));
    }

    private static String getValueFromConsole() {
        return scanner.next();
    }

    public static void fillingList() {
        System.out.print("Введите первое число:");
        result.add(getValueFromConsole());
        System.out.print("Введите операнд:");
        String answer = scanner.next();
        System.out.print("Введите второй число:");
        result.add(getValueFromConsole());
    }

    public static int action(int fOp, int sOp, String act) {
        switch (act) {
            case "+":
                return fOp + sOp;
            case "-":
                return fOp - sOp;
            case "*":
                return fOp * sOp;
            case "/": {
                if (sOp == 0) {
                    System.out.println("На ноль делить нельзя!!");
                    return -1;
                } else {
                    return fOp / sOp;
                }
            }
            case "%": {
                if (sOp == 0) {
                    System.out.println("На ноль делить нельзя!!");
                    return -1;
                } else {
                    return fOp % sOp;
                }
            }
            default:
                return -1;
        }
    }
}
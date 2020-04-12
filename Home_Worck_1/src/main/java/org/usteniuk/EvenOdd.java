package org.usteniuk;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenOdd {

    public static Scanner scanner = new Scanner(System.in);
    private static int size;
    private static List<Integer> collection = new ArrayList<>();
    private static List<Integer> evenCollection = new ArrayList<>();
    private static List<Integer> oddCollection = new ArrayList<>();


    public static void main(String[] args) {

        System.out.print("Введите размер коллекции(в разумных приделах): ");
        size = new Integer(scanner.next());
        fillingCollection();
        System.out.print("Коллекция:");
        showCollection(collection);
        evenCollection();
        System.out.print("Четные:");
        showCollection(evenCollection);
        oddCollection();
        System.out.print("Нечетные:");
        showCollection(oddCollection);

    }

    public static void fillingCollection() {

        for (int i = 0; i < size; i++) {
            int random = (int) ((Math.random() * 19) - 9);
            collection.add(i, random);
        }

    }

    public static void evenCollection() {

        for (int i = 0; i< size ; i++) {
            int result = collection.get(i) % 2;
            if (result == 0) {
                evenCollection.add(collection.get(i));
            }
        }
    }

    public static void oddCollection() {

        for (int i = 0;i < size ; i++) {
            int result = collection.get(i) % 2;
            if (result > 0 || result < 0) {
                oddCollection.add(collection.get(i));
            }
        }
    }

    public static void showCollection(List<Integer> collect){
        int i = 0;
        while (i < collect.size()){
            if (i < collect.size() - 1) {
                System.out.print(collect.get(i) + ", ");
            }
            else {
                System.out.print(collect.get(i) + "\n");
            }
            i++;
        }
    }
}



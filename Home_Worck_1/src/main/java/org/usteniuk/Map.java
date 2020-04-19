package org.usteniuk;

import java.util.HashMap;
import java.util.Scanner;

public class Map {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Integer, String> myHashMap = new HashMap<>();

        mapCreature(myHashMap);

        System.out.print("По какому параметру вы хотите проводить поиск(id/name)");
        String parametre = scanner.next();
        if (parametre.contains("id")) {
            searchByID(myHashMap);
        } else if (parametre.contains("name")) {
            searchByName(myHashMap);
        } else System.out.println("Значение неизвестно!!!");
    }

    public static void mapCreature(HashMap<Integer, String> map) {
        String answer = null;
        int id;

        do {
            System.out.print("Введите ID:");
            id = Integer.parseInt(scanner.nextLine());
            System.out.print("Введите имя и фамилию:");
            map.put(id, scanner.nextLine());
            System.out.print("Продолжить ввод?(y/n)");
            answer = scanner.nextLine();
        } while (answer.contains("y"));


    }

    public static void searchByID(HashMap<Integer, String> map) {
        System.out.print("Введите нужный ID:");
        int id = Integer.parseInt(scanner.next());
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getKey().equals(id)) {
                System.out.println(entry.getKey() + " --> " + entry.getValue());
            }
        }
    }

    private static void searchByName(HashMap<Integer, String> map) {
        System.out.print("Введите нужное имя или фамилию:");
        String name = scanner.next();
        for (HashMap.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().contains(name)) {
                System.out.println(entry.getKey() + " --> " + entry.getValue());
            }
        }
    }
}
package org.usteniuk;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MapFile {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<Integer, HashMap<String, String>> myHashMap = new HashMap<>();
        HashMap<Integer, String> myHashMap2 = new HashMap<>();
        mapCreature(myHashMap);

        System.out.print("По какому параметру вы хотите проводить поиск(id/name)");
        String parametre = scanner.next();
        if (parametre.contains("id")) {
            searchByID(myHashMap);
        } else if (parametre.contains("name")) {
            searchByName(myHashMap);
        } else System.out.println("Значение неизвестно!!!");


    }

    public static void mapCreature(HashMap<Integer, HashMap<String, String>> map) {

        File mapFile = new File("C:\\Users\\Roma\\IdeaProjects\\Home_Worck_1\\src\\main\\file\\map.txt");
        List<String> mapList = null;

        try {
            mapList = Files.readAllLines(mapFile.toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : mapList) {
            String[] split = s.split(",");
            HashMap<String, String> value = new HashMap<>();
            String[] split1 = split[1].split(" ");
            value.put("firstName", split1[0]);
            value.put("lastName", split1[1]);
            map.put(Integer.parseInt(split[0]), value);
        }
    }

    public static void searchByID(HashMap<Integer, HashMap<String, String>> map) {
        System.out.print("Введите нужный ID:");
        int id = Integer.parseInt(scanner.next());
        for (HashMap.Entry<Integer, HashMap<String, String>> entry : map.entrySet()) {
            if (entry.getKey().equals(id)) {
                System.out.println(entry.getKey() + " --> " + entry.getValue().get("firstName") + " " + entry.getValue().get("lastName"));
            }
        }
    }

    private static void searchByName(HashMap<Integer, HashMap<String, String>> map) {
        System.out.print("Введите нужное имя или фамилию:");
        String name = scanner.next();
        for (HashMap.Entry<Integer, HashMap<String, String>> entry : map.entrySet()) {
            if (entry.getValue().get("firstName").contains(name) || entry.getValue().get("lastName").contains(name)) {
                System.out.println(entry.getKey() + " --> " + entry.getValue().get("firstName") + " " + entry.getValue().get("lastName"));
            }
        }
    }
}



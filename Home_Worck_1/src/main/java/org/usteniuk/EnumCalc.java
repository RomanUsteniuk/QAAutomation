package org.usteniuk;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumCalc {

    public static List<String> calc = new ArrayList<>();

    public static void main(String[] args) {

        fillingList();
        int firstVar = Integer.parseInt(calc.get(0));
        int secondVar = Integer.parseInt(calc.get(2));

        action(firstVar, secondVar, calc.get(1));
    }


    public static void fillingList() {

        File calcF = new File("C:\\Users\\Roma\\IdeaProjects\\Home_Worck_1\\src\\main\\file\\calc.txt");
        List<String> calcL = null;

        try {
            calcL = Files.readAllLines(calcF.toPath(), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : calcL) {
            calc = Arrays.asList(s.split(","));
        }
    }

    public static void action(int fOp, int sOp, String action) throws ZeroException {
        switch (action) {
            case "+": {
                Operation operation = Operation.SUM;
                operation.action(fOp, sOp, action);
                break;
            }
            case "-": {
                Operation operation = Operation.MINUS;
                operation.action(fOp, sOp, action);
                break;
            }
            case "*": {
                Operation operation = Operation.MULT;
                operation.action(fOp, sOp, action);
                break;
            }
            case "/": {
                Operation operation = Operation.DIV;
                operation.action(fOp, sOp, action);
                break;
            }
            case "%": {
                Operation operation = Operation.REM;
                operation.action(fOp, sOp, action);
                break;
            }
        }
    }
}





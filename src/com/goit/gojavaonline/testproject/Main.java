package com.goit.gojavaonline.testproject;


public class Main {


    public static String calculateUserFormula(String userInput) {
        String result;
        double calc;
        try {
            FormulaParser parser = new FormulaParser(userInput);
            Function function = parser.parse();
            calc = function.calculate();
            result = Double.toString(calc);
        }
        catch (Exception e) {
           return "Некоректный ввод";
        }

        return result;
    }
}

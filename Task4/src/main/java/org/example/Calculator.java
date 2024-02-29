package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {
    private double result = 0;
    private boolean error = false;

    public void runCalculator() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите математическое выражение: ");
        String expression = reader.readLine();
        if (checkExpression(expression)) {
            result = calculate(expression);
            if (!error) {
                System.out.print("Результат: ");
                System.out.printf("%.2f", result);
                System.out.println();
            }
        }
    }

    public double calculate(String expression) {
        ArrayList<String> list = new ArrayList<>();

        if (expression.contains("+")) expression = expression.replace("+", " + ");
        if (expression.contains("-")) expression = expression.replace("-", " - ");
        if (expression.contains("*")) expression = expression.replace("*", " * ");
        if (expression.contains("/")) expression = expression.replace("/", " / ");
        if (expression.contains("(")) expression = expression.replace("(", " ( ");
        if (expression.contains(")")) expression = expression.replace(")", " ) ");

        if (expression.contains(",")) expression = expression.replace(",", ".");

        String finalExpression[] = expression.split(" ");
        for (String element : finalExpression) {
            if (!element.equals("")) list.add(element);
        }


        ArrayList<String> secondExpression = new ArrayList<>();

        while (true) {
            int startPoint = 0;
            int endPoint = 0;
            if (list.contains("(")) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("(")) {
                        startPoint = i;

                        for (int j = i + 1; j < list.size(); j++) {
                            if (!list.get(j).equals(")")) {
                                secondExpression.add(list.get(j));
                            } else if (list.get(j).equals(")")) {
                                endPoint = j;
                                operations(secondExpression);
                                break;
                            }
                        }

                        for (int k = endPoint; k < list.size(); k--) {
                            if (k >= startPoint) {
                                list.remove(k);
                                if (k == startPoint) break;
                            }
                        }

                        list.add(i, String.valueOf(result));
                        if (i != 0) {
                            if (!list.get(i - 1).equals("+") && !list.get(i - 1).equals("-") && !list.get(i - 1).equals("*") && !list.get(i - 1).equals("/"))
                                list.add(i, "*");
                        }
                    }
                }
                operations(list);
            } else {
                operations(list);
            }
            break;
        }
        return result;
    }

    public void operations(ArrayList<String> list) {
        boolean exit = false;
        while (true) {
            if (list.contains("*") || list.contains("/")) {
                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).equals("*")) {
                        result = Double.parseDouble(list.get(i - 1)) * Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                        break;
                    }
                    if (list.get(i).equals("/")) {
                        try {
                            if (Double.parseDouble(list.get(i + 1)) == 0) {
                                error = true;
                                throw new ArithmeticException();
                            } else {

                            }
                        } catch (ArithmeticException e) {
                            System.err.println("Нельзя поделить на ноль");
                            System.exit(0);
                        }
                        result = Double.parseDouble(list.get(i - 1)) / Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                        break;
                    }
                }
            } else break;
        }
        while (true) {
            if (list.contains("+") || list.contains("-")) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("+")) {
                        result = Double.parseDouble(list.get(i - 1)) + Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                        break;
                    }
                    if (list.get(i).equals("-")) {
                        result = Double.parseDouble(list.get(i - 1)) - Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                        break;
                    }
                }
            } else break;
        }
    }
    public boolean checkExpression(String expression) {

        String regex = "[0-9+\\-=*/,.()]+";
        boolean checking = expression.matches(regex);
        try {
            if (!checking) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            System.err.println("Введены неверные данные, попробуй еще раз");
            System.exit(0);
        }
        return expression.matches(regex);
    }
}

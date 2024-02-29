package org.example;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Base {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            System.out.println("Введите 1 или 2: ");
            int mode = scanner.nextInt();

            switch (mode) {
                case 1:

                    System.out.print("Введите первое дробное число: ");
                    double number1 = scanner.nextDouble();

                    System.out.print("Введите второе дробное число: ");
                    double number2 = scanner.nextDouble();

                    System.out.println("Введите математическое действие (+, -, * или /): ");
                    char operation = scanner.next().charAt(0);
                    double result;

                    switch (operation) {
                        case '+':
                            result = number1 + number2;
                            break;
                        case '-':
                            result = number1 - number2;
                            break;
                        case '*':
                            result = number1 * number2;
                            break;
                        case '/':
                            result = number1 / number2;
                            break;
                        default:
                            System.out.println("Ошибка, введите корректный оператор");
                            return;
                    }

                    System.out.printf("Результат операции = " + "%.4f", result);
                    break;
                case 2:
                    System.out.print("Введите длину массива: ");
                    int size = scanner.nextInt();
                    String[] myArray = new String[size];

                    System.out.println("Введите слова для массива: ");

                    for (int i = 0; i < size; i++) {
                        System.out.printf("\n%d: \n", i + 1);
                        myArray[i] = scanner.next();
                    }

                    int maxlen = 0;

                    for (int i = 0; i < myArray.length; i++){
                        if (myArray[i].length() > maxlen)
                        {
                            maxlen = myArray[i].length();
                        }
                    }


                    for (int i = 0; i < size; i++){
                        if (myArray[i].length() == maxlen);
                       {
                           System.out.println("Самое длинное слово: " + myArray[i]);
                       }
                    }
                    break;
                default:
                    System.out.println("Введите только 1 или 2!");
                    break;
            }
        }
    }


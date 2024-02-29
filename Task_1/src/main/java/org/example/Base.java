
package org.example;
import java.util.Scanner;
public class Base {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое дробное число: "); // Пользователь вводит одно дробное число
        double number1 = scanner.nextDouble();

        System.out.print("Введите второе дробное число: "); // Пользователь вводит другое дробное число
        double number2 = scanner.nextDouble();

        double result = number1 + number2;
        System.out.printf("Результат операции = " + "%.4f",result); // Результат сложения с округлением до 4 знаков после ,

    }
}

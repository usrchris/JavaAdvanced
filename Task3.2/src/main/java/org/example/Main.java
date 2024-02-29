package org.example;

import sweets.Candy;
import sweets.Chocolate;
import sweets.Jellybean;
import sweets.Sweets;

import java.util.Arrays;
public class Main {
    public static void main(String[] args) {

        Candy candy1 = new Candy("Вафельные батончики", 120, 89, "Красный");
        Jellybean jellyBean1 = new Jellybean("Харибо", 90, 110, "мишки");
        Chocolate chocolate1 = new Chocolate("Милка", 95, 90.99, "плитка");

        Sweets[] gift = {candy1, jellyBean1, chocolate1};

        int totalWeight = 0;
        double totalPrice = .0;

        for(Sweets sweet : gift){
            totalWeight += sweet.getWeight();
            totalPrice += sweet.getPrice();
        }

        for (Sweets someSweets: gift) {
//            System.out.println(someSweets.toString());
        }
        System.out.println("Собран сладкий подарок: \n" + Arrays.toString(gift));
        System.out.printf("Общий вес подарка: " + totalWeight + " грамм\n" + "Общая стоимость подарка: " + totalPrice + " рублей");

    }
}
package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] myArray = new int[20];

        for (int i = 0; i < myArray.length; i++) {

            if (i == 0) {
                myArray[i] = ((int) (Math.random() * 21) - 10);
            }
            else {
                boolean match;
                do {
                    match  = false;
                    myArray[i] = ((int) (Math.random() * 21) - 10);

                    for (int j = 0; j < i; j++) {
                        match = myArray[i] == myArray[j];
                        if (match) break;
                    }
                }
                while(match);
            }

        }
        System.out.println("Получился массив: " + Arrays.toString(myArray));

        int minIndex = 0;
        int maxIndex = 0;
        int buffer = 0;
        int min = 10;
        int max = -10;

        for (int i = 0; i < myArray.length; i++) {

            if (myArray[i] >= 0)  {
                if (myArray[i] < min) {
                    min = myArray[i];
                    minIndex = i;
                }
            }
            else {
                if (myArray[i] > max) {
                    max = myArray[i];
                    maxIndex = i;
                }
            }
        }

        buffer = myArray[minIndex];
        myArray[minIndex] = myArray[maxIndex];
        myArray[maxIndex] = buffer;

        System.out.println(max);
        System.out.println(min);
        System.out.println("Получился массив: " + Arrays.toString(myArray));
    }
}
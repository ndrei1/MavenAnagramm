package com.andrei.anagram;

import java.util.Scanner;

public class Application {
    private static final String EXIT_WORD = "exit";

    public static void main(String[] args) {
        System.out.println("Enter text for reverse or type 'exit': ");
        Scanner read = new Scanner(System.in);
        Anagram reverse = new Anagram(); 

        while (read.hasNext()) {
            String inputText = read.nextLine();
            if (EXIT_WORD.equals(inputText.toLowerCase())) {
                break;
            }
            String reverseText = reverse.process(inputText);
            System.out.println(reverseText);
        }
        read.close();
    }
}


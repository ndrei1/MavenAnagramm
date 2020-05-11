package com.andrei.anagram;
import java.util.StringJoiner;

public class Anagram {

    public String process(String inputText) {
        if (inputText == null) {  
            throw new IllegalArgumentException("Input text is null");
        }
        if (inputText.trim().isEmpty()) {
            return inputText;
        }

        StringJoiner joiner = new StringJoiner(" ");
        for (String word : inputText.split(" ")) {
            joiner.add(reverseWord(word));
        }
        return joiner.toString();
    }

    private String reverseWord(String word) {
        char[] symbols = word.toCharArray();
        for (int leftIndex = 0, rightIndex = word.length() - 1; leftIndex <= rightIndex;) {
            if (Character.isLetter(symbols[leftIndex]) && Character.isLetter(symbols[rightIndex])) {
                char bufferChar = symbols[leftIndex];
                symbols[leftIndex] = symbols[rightIndex];
                symbols[rightIndex] = bufferChar;
                leftIndex++;
                rightIndex--;
            } else {
                if (!Character.isLetter(symbols[leftIndex])) {
                    leftIndex++;
                }
                if (!Character.isLetter(symbols[rightIndex])) {
                    rightIndex--;
                }
            }
        }

        return new String(symbols);
    }
}

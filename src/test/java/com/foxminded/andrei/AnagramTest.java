package com.foxminded.andrei;

import com.andrei.anagram.Anagram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestAnagram {
    private Anagram anagram = new Anagram();

    @Test
    void processShouldThrowExceptionWhenInputIsNull() {
        String nullString = null;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> anagram.process(nullString));
    }

    @Test
    public void processShouldReturnEmptyStringWhenInputIsEmptyString() {
        String expected = "";
        String actual = anagram.process(expected);
        assertEquals(actual, expected);
    }

    @Test
    public void processShouldReturnSpaceWhenInputIsSpace() {
        String expected = " ";
        String actual = anagram.process(expected);
        assertEquals(actual, expected);
    }

    @Test
    public void processShouldReturnSomeSpaceWhenInputIsSomeSpace() {
        String expected = "  ";
        String actual = anagram.process(expected);
        assertEquals(actual, expected);
    }

    @Test
    public void processShouldReturnSameLetterWhenInputIsOneLetter() {
        String expected = "d";
        String actual = anagram.process("d");
        assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnSameLettersWhenInputIsTheSameLetter() {
        String expected = "ddddd";
        String actual = anagram.process("ddddd");
        assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnReverseWordmWhenInputIsWord() {
        String expected = "text";
        String actual = anagram.process("txet");
        assertEquals(expected, actual);
    }

    @Test
    public void processShouldReverseLettersWhenBothRegisterProvided() {
        String expected = "TeXt";
        String actual = anagram.process("tXeT");
        assertEquals(expected, actual);
    }

    @Test
    public void processShouldNotReverseAnySymbolWhenInputContainsOnlyNonLetters() {
        String expected = "1111";
        String actual = anagram.process("1111");
        assertEquals(expected, actual);
    }

    @Test
    public void processShouldReturnAnagramWhenInputIsTheSameTextWithLettersAndNumeral() {
        String expected = "11t1ext11";
        String actual = anagram.process("11t1xet11");
        assertEquals(expected, actual);
    }

    @Test
    public void ShouldReverseWordsIndependentlyWhenGivenTwoWordsWithAnySymbols() {
        String expected = "d1cba hgf!e";
        String actual = anagram.process("a1bcd efg!h");
        assertEquals(expected, actual);
    }

}
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ThirdTaskTest {
    ThirdTask thirdTask = new ThirdTask();

    //=======================================The length of the shortest word============================================
    static Stream<Arguments> lengthOfShortestWordTest() {
        return Stream.of(
                arguments("Five", 4),
                arguments("Five one two", 3),
                arguments("Five, one-two!", 3),
                arguments("Five, one-two!a Tree onE", 1),
                arguments("Five, one-two!3 Tree one 1", 3),
                arguments("Five, one-two!Eight nine twenty too to five", 2),
                arguments("RESPONSE @ ACCEPT ... SELECT ! QUEUE_  ", 6)
        );
    }

    @ParameterizedTest(name = "The length of the shortest word. Input data is {0}, {1}")
    @MethodSource("lengthOfShortestWordTest")
    void lengthOfShortestWordTest_1(String str, int expected) {
        int actual = thirdTask.lengthOfShortestWord(str);
        assertEquals(expected, actual);
    }

    @Test
    void lengthOfShortestWordTest_exception() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thirdTask.lengthOfShortestWord("   ,,, ,,, |||/// /// !");
        }, "String cannot be without words.");
    }

    @Test
    void lengthOfShortestWordTest_exception_0() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thirdTask.lengthOfShortestWord("");
        }, "String cannot be without words.");
    }

    @Test
    void lengthOfShortestWordTest_exception_1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thirdTask.lengthOfShortestWord("123456789 9999 99");
        }, "String cannot be without words.");
    }

    @Test
    void lengthOfShortestWordTest_exception_2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thirdTask.lengthOfShortestWord("123456789 , 999 9900 908097 ,,,, 9990");
        }, "String cannot be without words.");
    }

    //===========================================Count words at string==================================================
    static Stream<Arguments> countWordsAtStringTest() {
        return Stream.of(
                arguments("", 0),
                arguments("Five", 1),
                arguments("Five one two", 3),
                arguments("Five, one-two!", 3),
                arguments("Five, one-two!3 Tree onE", 5),
                arguments("Five, one-two!3 Tree one 1", 5),
                arguments("Five, one-two!Eight nine twenty too to five", 9),
                arguments("123456789", 0),
                arguments("12345678910 , 1234567890", 0),
                arguments("RESPONSE @ ACCEPT ... SELECT ! QUEUE_  ", 4)
        );
    }

    @ParameterizedTest(name = "Count words at string. Input data is {0}, {1}")
    @MethodSource("countWordsAtStringTest")
    void countWordsAtStringTest_1(String str, int expected) {
        int actual = thirdTask.countWordsAtArray(str);
        assertEquals(expected, actual);
    }

    //===========================================Delete last word=======================================================
    static Stream<Arguments> deleteLastWordTest() {
        return Stream.of(
                arguments("", ""),
                arguments("Five", ""),
                arguments("Five one two", "Five one "),
                arguments("Five, one-two!", "Five, "),
                arguments("Five, one-two!3 Tree onE", "Five, one-two!3 Tree "),
                arguments("Five, one-two!3 Tree one 1", "Five, one-two!3 Tree one "),
                arguments("Five, one-two!Eight nine twenty too to five", "Five, one-two!Eight nine twenty too to "),
                arguments("123456789", ""),
                arguments("12345678910 , 1234567890", "12345678910 , "),
                arguments("*/*/-/-/-/ ///*-", "*/*/-/-/-/ "),
                arguments("RESPONSE @ ACCEPT ... SELECT ! QUEUE_  ", "RESPONSE @ ACCEPT ... SELECT ! ")
        );
    }

    @ParameterizedTest(name = "Delete last word. Input data is {0}, {1}")
    @MethodSource("deleteLastWordTest")
    void deleteLastWordTest_1(String str, String expected) {
        String actual = thirdTask.deleteLastWord(str);
        assertEquals(expected, actual);
    }

    //=================================================_ADD_$$$_========================================================
    static Stream<Arguments> add$Test() {
        String[] strArr = {"Tre"};
        String[] strArr_0 = {"$$$"};
        String[] strArr1 = {"Tre", "five", "hundred"};
        String[] strArr1_0 = {"Tre", "f$$$", "hundred"};
        String[] strArr2 = {"Tre", "five", "hundreds", "fifteen"};
        String[] strArr2_0 = {"Tre", "five", "hundreds", "fift$$$"};
        String[] strArr3 = {"Tre", "five", "hundred", "fifteen", "two"};
        String[] strArr3_0 = {"$$$", "five", "hundred", "fifteen", "$$$"};
        String[] strArr4 = {"Tre", "five", "hundred", "fifteen", "two"};
        String[] strArr4_0 = {"Tre", "five", "hund$$$", "fift$$$", "two"};
        return Stream.of(
                arguments(strArr, strArr_0, 3),
                arguments(strArr1, strArr1_0, 4),
                arguments(strArr2, strArr2_0, 7),
                arguments(strArr3, strArr3_0, 3),
                arguments(strArr4, strArr4_0, 7)
        );
    }

    @ParameterizedTest(name = "Add $$$. Input data is {0}, {1}")
    @MethodSource("add$Test")
    void add$Test_1(String[] str, String[] expected, int wordLength) {
        String[] actual = thirdTask.add$(str, wordLength);
        assertArrayEquals(expected, actual);
    }

    @Test
    void add$Test_exception_1() {
        String[] strArr = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thirdTask.add$(strArr, 4);
        }, "Array cannot be empty.");
    }

    @Test
    void add$Test_exception_2() {
        String[] strArr = {"Two", "five", "fifty"};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            thirdTask.add$(strArr, 10);
        }, "In this array no word with specified length.");
    }
    //=================================================Add space after symbol===========================================

//    static Stream<Arguments> addSpaceAfterSymbolTest() {
//        return Stream.of(
//                arguments("", ""),
//                arguments("Five", "Five"),
//                arguments("Five one two", "Five one two"),
//                arguments("Five,one-two!", "Five, one- two! "),
//                arguments("Five, one-two!3 Tree onE", "Five, one-two! 3 Tree onE"),
//                arguments("Five, one-two!3 Tree,one 1", "Five, one-two! 3 Tree, one 1"),
//                arguments("Five, one-two!Eight nine twenty too to five,", "Five, one-two! Eight nine twenty too to five, "),
//                arguments("1234,56789", "1234, 56789"),
//                arguments("12345678910 ,1234567890", "12345678910 , 1234567890"),
//                arguments("/,.';:!?@#$%^&*","/ , . ' ; : ! ? @ # $ % ^ & * "),
//                arguments("RESPONSE @ ACCEPT ... SELECT ! QUEUE_  ", "RESPONSE @ ACCEPT ... SELECT ! ")
//        );
//    }
//    @ParameterizedTest(name = "Add space after symbol. Input data is {0}, {1}")
//    @MethodSource("addSpaceAfterSymbolTest")
//    void addSpaceAfterSymbolTest_1(String str, String expected) {
//        String actual = thirdTask.addSpaceAfterSymbol(str);
//        assertEquals(expected, actual);
//    }

}

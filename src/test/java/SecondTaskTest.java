import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class SecondTaskTest {
    SecondTask secondTask = new SecondTask();

    //=================================================Itn to string====================================================
    static Stream<Arguments> intToStringTest() {
        return Stream.of(
                arguments(0, "0"),
                arguments(1, "1"),
                arguments(-5, "-5"),
                arguments(-188, "-188"),
                arguments(-15, "-15"),
                arguments(10, "10"),
                arguments(5, "5"),
                arguments(1000, "1000"),
                arguments(1011, "1011"),
                arguments(19999, "19999"),
                arguments(2, "2")
        );
    }

    @ParameterizedTest(name = "Itn to string. Input data is {0}, {1}")
    @MethodSource("intToStringTest")
    void intToStringTest_1(int num, String expected) {
        String actual = secondTask.intToString(num);
        assertEquals(expected, actual);
    }

    //=================================================Double to string=================================================
    static Stream<Arguments> doubleToStringTest() {
        return Stream.of(
                arguments(0, "0.0"),
                arguments(0.1, "0.1"),
                arguments(-0.1, "-0.1"),
                arguments(-0.2, "-0.2"),
                arguments(-4.2, "-4.2"),
                arguments(0.2, "0.2"),
                arguments(4.7, "4.7")
        );
    }

    @ParameterizedTest(name = "Double to string. Input data is {0}, {1}")
    @MethodSource("doubleToStringTest")
    void doubleToStringTest_1(double dou, String expected) {
        String actual = secondTask.doubleToString(dou);
        assertEquals(expected, actual);
    }

    //=================================================String to Int====================================================
    static Stream<Arguments> strToIntTest() {
        return Stream.of(
                arguments("0", 0),
                arguments("1", 1),
                arguments("2", 2),
                arguments("10", 10),
                arguments("100", 100),
                arguments("-18", -18),
                arguments("-1", -1),
                arguments("-150", -150),
                arguments("1015", 1015),
                arguments("19563", 19563)
        );
    }

    @ParameterizedTest(name = "String to Int. Input data is {0}, {1}")
    @MethodSource("strToIntTest")
    void strToIntTest_1(String str, int expected) {
        int actual = secondTask.strToInt(str);
        assertEquals(expected, actual);
    }
    //=================================================String to double====================================================

    static Stream<Arguments> strToDoubleTest() {
        return Stream.of(
                arguments("0.0", 0.0),
                arguments("0.1", 0.1),
                arguments("-0.1", -0.1),
                arguments("-3.1", -3.1),
                arguments("-100.1", -100.1),
                arguments("0.2", 0.2),
                arguments("3.0", 3.0),
                arguments("5.5", 5.5),
                arguments("100.02", 100.02),
                arguments("10.00005", 10.00005)
        );
    }

    @ParameterizedTest(name = "String to double. Input data is {0},{1}")
    @MethodSource("strToDoubleTest")
    void strToDoubleTest_1(String str, double expected) {
        double actual = secondTask.strToDouble(str);
        assertEquals(expected, actual);
    }

}

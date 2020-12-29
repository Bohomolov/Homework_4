import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTaskTest {
    FirstTask firstTask = new FirstTask();

    @Test
    public void firstTaskMethodTest() {
        String actual = firstTask.firstMethod();
        String expected = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        assertEquals(expected, actual);
    }

    @Test
    public void secondMethodTest() {
        String expected = "zyxwvutsrqponmlkjihgfedcba";
        String actual = firstTask.secondMethod();
        assertEquals(expected, actual);
    }

    @Test
    public void thirdMethodTest() {
        String expected = "абвгдежзийклмнопрстуфхцчшщъыьэюя";
        String actual = firstTask.thirdMethod();
        assertEquals(expected, actual);
    }

    @Test
    public void forthMethodTest() {
        String expected = "0123456789";
        String actual = firstTask.forthMethod();
        assertEquals(expected, actual);
    }

    @Test
    public void fifthMethodTest() {
        String expected = " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        String actual = firstTask.fifthMethod();
        assertEquals(expected, actual);
    }
}

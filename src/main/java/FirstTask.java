public class FirstTask {
    public String firstMethod() {
        String result = "";
        for (char i = 'A'; i <= 'Z'; i++) {
            result += i;
        }
        return result;
    }

    public String secondMethod() {
        String result = "";
        for (char i = 'z'; i >= 'a'; i--) {
            result += i;
        }
        return result;
    }

    public String thirdMethod() {
        String result = "";
        for (char i = 'а'; i <= 'я'; i++) {
            result += i;
        }
        return result;
    }

    public String forthMethod() {
        String result = "";
        for (int i = 0; i <= 9; i++) {
            result += i;
        }
        return result;
    }

    public static String fifthMethod() {
        String result = "";
        for (char i = 32; i < 127; i++) {
            result += i;
        }
        return result;
    }
}

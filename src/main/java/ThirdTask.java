public class ThirdTask {
    //=======================================The length of the shortest word============================================
    public int lengthOfShortestWord(String str) {
        String[] array = str.replaceAll("\\d", "").split("\\W");
        if (array.length == 0 || array[0].equals("")) {
            throw new IllegalArgumentException("String cannot be without words.");
        }
        int result = array[0].length();
        for (int i = 0; i < array.length; i++) {

            if (!array[i].equals("")) {
                if (result > array[i].length()) {
                    result = array[i].length();
                }
            }
        }
        return result;
    }
    //===========================================Count words at string==================================================

    public int countWordsAtArray(String str) {
        int result = 0;
        String[] array = str.replaceAll("\\d", "").split("\\W");
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("")) {
                result++;
            }
        }
        return result;
    }
    //===========================================Delete last word=======================================================

    public String deleteLastWord(String str) {
        String[] array = str.split(" ");
        str = "";
        for (int i = 0; i < array.length - 1; i++) {
            if (!array[i].equals("")) {
                str += array[i] + " ";
            }
        }
        return str;
    }

    //=================================================_ADD_$$$_========================================================
    public String[] add$(String[] strArray, int wordLength) {
        if (strArray.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
        int count = 0;
        for (int i = 0; i < strArray.length; i++) {
            if (strArray[i].length() == wordLength) {
                String tmpString = strArray[i].replaceAll("...$", "\\$\\$\\$");
                strArray[i] = tmpString;
                count++;
            } else if (i == strArray.length - 1 && count == 0) {
                throw new IllegalArgumentException("In this array no word with specified length.");
            }
        }
        return strArray;
    }
}

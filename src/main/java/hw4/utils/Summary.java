package hw4.utils;

public class Summary {

    private Summary() {
    }

    public static String summ(String valueOne, String valueTwo) {
        return String.valueOf(Integer.parseInt(valueOne) + Integer.parseInt(valueTwo));
    }
}

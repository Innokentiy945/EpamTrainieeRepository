package hw4.utils;

import java.util.ArrayList;
import java.util.List;

public class Summary {

    private Summary() {
    }

    public static String summ(String valueOne, String valueTwo) {
        return String.valueOf(Integer.parseInt(valueOne) + Integer.parseInt(valueTwo));
    }
}

package hw4.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class DataOpener {

    public static String read(String property) {

        try (InputStream input = new FileInputStream("src/test/resources/hw4/Properties/Test_data_for_hw4.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(property));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

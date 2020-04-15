package hw5.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesOpener {

    public static String read(String property) {

        try (InputStream input = new FileInputStream("src/test/resources/hw5/utils/data_properties_for_hw3")) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(property));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}

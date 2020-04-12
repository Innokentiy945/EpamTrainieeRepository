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

    public static String readFirstNumber(String property) {
        try (InputStream input = new FileInputStream("src/test/resources/hw4/Properties/Test_data_for_second_test_hw4")) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(String.valueOf(property)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String readSecondNumber(String property) {
        try (InputStream input = new FileInputStream("src/test/resources/hw4/Properties/Test_data_for_second_test_hw4")) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(String.valueOf(property)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String readElements(String property) {
        try (InputStream input = new FileInputStream("src/test/resources/hw4/Properties/Test_data_for_second_test_hw4")) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(String.valueOf(property)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String readColors(String property) {
        try (InputStream input = new FileInputStream("src/test/resources/hw4/Properties/Test_data_for_second_test_hw4")) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(String.valueOf(property)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String readMetals(String property) {
        try (InputStream input = new FileInputStream("src/test/resources/hw4/Properties/Test_data_for_second_test_hw4")) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(String.valueOf(property)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String readVegetables(String property) {
        try (InputStream input = new FileInputStream("src/test/resources/hw4/Properties/Test_data_for_second_test_hw4")) {
            Properties prop = new Properties();
            prop.load(input);
            return (prop.getProperty(String.valueOf(property)));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }




}

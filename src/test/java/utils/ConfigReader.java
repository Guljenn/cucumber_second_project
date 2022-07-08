package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    // this helps us to load the file that we have and read it. It loads all the information to properties.

    static {

        try {
            FileInputStream fileInputStream = new FileInputStream("configuration.properties");
            properties.load(fileInputStream);
            fileInputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}

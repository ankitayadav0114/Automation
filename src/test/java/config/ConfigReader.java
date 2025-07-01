package config;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    public static Properties getProperties() {
        if (properties == null) {
            try {
                FileInputStream file = new FileInputStream(""
                		+ "src/test/java/Resources/config.properties");
                properties = new Properties();
                properties.load(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return properties;
    }

    public static String get(String key) {
        return getProperties().getProperty(key);
    }
}

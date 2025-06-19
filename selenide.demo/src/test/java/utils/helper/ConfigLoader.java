package utils.helper;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
	public static void loadConfig() {
		Properties config = new Properties();
        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            config.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("X Failed to load config.properties file", e);
        }
    }
}

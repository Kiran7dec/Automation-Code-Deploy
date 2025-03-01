package com.tietoevry.selenium.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try {
            // Load properties from the file
            FileInputStream fis = new FileInputStream("src/resources/config.properties");
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }

    public String getUrl() {
        return properties.getProperty("url");
    }
}
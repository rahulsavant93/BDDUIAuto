package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop = null;

    public static Properties initProperties() {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream ip = new FileInputStream("C:/Rahul/UIAutomation/src/main/java/com/utils/config.properties");
                prop.load(ip);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}

package com.star.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    /**
     * properties object initiated to access load(), getProperty() methods
     * it has to be "private static" to restrict access and will be used in static method
     */

    private static Properties properties = new Properties();


/**
 * a static block is being used to run ONCE BEFORE anything else
 * a try/catch block to handle checked exceptions caused by methods
 */

    static {
        try {
            // FileInputStream will help to open the file as a stream in Java memory
            FileInputStream file = new FileInputStream("config.properties");

            // Now it is possible to load the properties object using FileInputStream
            properties.load(file);

            // closing the file after loading is best practice to avoid memory usage in the computer
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * this is a purpose of creating this class, a bridge between classes
     * this method allows us to read file from the configuration.properties file
     *
     * @param keyword --> key name in configuration.properties file
     * @return --> value of the key and null if it's not found
     * driver.get(ConfigurationReader.getProperty("env"))
     */

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}

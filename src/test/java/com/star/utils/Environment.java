package com.star.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Environment {

    public static final String URL;
    public static final String BASE_URL;
    public static final String DB_USERNAME;
    public static final String DB_PASSWORD;
    public static final String DB_URL;
    public static final String ROLE1_EMAIL;
    public static final String ROLE1_PASSWORD;
    public static final String ROLE2_EMAIL;
    public static final String ROLE2_PASSWORD;
    public static final String ROLE3_EMAIL;
    public static final String ROLE3_PASSWORD;


    static {
        Properties properties = null;
        String environment = System.getProperty("environment") != null ? environment = System.getProperty("environment") : ConfigurationReader.getProperty("environment");


        try {

            String path = System.getProperty("user.dir") + "/src/test/resources/Environments/" + environment + ".properties";

            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        URL = properties.getProperty("url");
        BASE_URL = properties.getProperty("base_url");
        DB_USERNAME = properties.getProperty("dbUsername");
        DB_PASSWORD = properties.getProperty("dbPassword");
        DB_URL = properties.getProperty("dbUrl");
        ROLE1_EMAIL = properties.getProperty("role1_email");
        ROLE1_PASSWORD = properties.getProperty("role1_password");
        ROLE2_EMAIL = properties.getProperty("role2_email");
        ROLE2_PASSWORD = properties.getProperty("role2_password");
        ROLE3_EMAIL = properties.getProperty("role3_email");
        ROLE3_PASSWORD = properties.getProperty("role3_password");


    }


}
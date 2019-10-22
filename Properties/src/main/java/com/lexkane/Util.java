package com.lexkane;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.io.BufferedInputStream;
import java.io.FileInputStream;



public class Util {
    public String getPropertyValue(String propertyName) throws IOException {
        String propertyValue = "";
        Properties properties = new Properties();
        FileInputStream fstream = new FileInputStream("src"+ File.separator+"resources"+File.separator+"application.properties");
        BufferedInputStream bstream = new BufferedInputStream(fstream);
        try {
            properties.load(bstream);
            propertyValue = properties.getProperty(propertyName);

        } catch (IOException e) {
            System.out.println(e);
        } finally {
            bstream.close();
            fstream.close();
        }

        return propertyValue;
    }
}
package com.it_academy.rest_api.property;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class PropertiesReader {
    private static final String ENDPOINTS_PROPERTY_FILE = "/endpoints.properties";
    private static final String GRID_PROPERTY_FILE = "/grid.properties";
    private static final Properties ENDPOINTS_PROPERTIES = new Properties();

    public static URL getGridUrl (String url){
        try {
            return new URL(getGridProperty(url));
        }catch (MalformedURLException e){
            throw new IllegalArgumentException("Incorrect URL");
        }
    }

    public static String getGridProperty(String property){
        return ENDPOINTS_PROPERTIES.getProperty(GRID_PROPERTY_FILE, property);
    }

    static {
        initProperties(ENDPOINTS_PROPERTIES, ENDPOINTS_PROPERTY_FILE);
        initProperties(ENDPOINTS_PROPERTIES, GRID_PROPERTY_FILE);
    }

    public static String getEndpointProperty(String property) {
        return ENDPOINTS_PROPERTIES.getProperty(ENDPOINTS_PROPERTY_FILE, property);
    }

    private static synchronized void initProperties(Properties properties, String fileName) {
        try (InputStream inputStream = PropertiesReader.class.getResourceAsStream(fileName)) {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new IllegalArgumentException("Unable to load properties from file: " + fileName);
        }
    }
}

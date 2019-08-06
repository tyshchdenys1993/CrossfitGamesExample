package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static PropertiesUtil util;

    private PropertiesUtil() {
    }

    public static synchronized PropertiesUtil getInstance(){
        if (util==null){
            util = new PropertiesUtil();
        }
        return util;
    }

    private String readProperty(String fileName, String id){
        Properties properties = new Properties();
        try {
        InputStream inputStream = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
            return  properties.getProperty(id);
        } catch (IOException e) {
            throw new RuntimeException("Cannot readPropert properties", e);
        }
    }

    public String get(String property, String title){
        return readProperty(property,title);
    }

}

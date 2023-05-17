package org.QA.utils;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
public class Config {
    private static Properties properties;

    static {
        try {
            FileInputStream in = new FileInputStream("src/main/resources/config.properties");
            properties = new Properties();
            properties.load(in);
            in.close();
        } catch (IOException e) {
            System.out.println("Error reading config.properties");
        }
    }
    public static String getBaseUrl() {
        String language = getLanguage();
        String baseurl="";
        switch (language)
        {
            case "en": baseurl = properties.getProperty("EnBaseUrl");
                break;
            default:baseurl = properties.getProperty("ArBaseUrl");
        }
        return baseurl;
    }

    public static String getChromeDriver() {
        return properties.getProperty("ChromeDriver");
    }

    public static int getTimeOut() {
        return Integer.parseInt(properties.getProperty("TimeOut"));
    }

    public static String getLanguage(){
        return properties.getProperty("Language");
    }

    public static String getDataFile(){
        String language = getLanguage();
        String path="";
        switch (language)
        {
            case "en": path = properties.getProperty("EnData");
            break;
            default:path = properties.getProperty("ArData");
        }
        return path;
    }
}
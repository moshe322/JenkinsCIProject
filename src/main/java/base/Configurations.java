package base;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configurations {

    protected static final Logger LOGGER = LogManager.getLogger(Configurations.class);

    private static final Properties GLOB_PROPERTIES;
    public static final String ADMIN_NAME;
    public static final String PASSWORD;
    public static final String URL;
    public static final String BROWSER;
    public static final String HUB_URL;
    public static final String DRIVER_STRATEGY;


    static {
        GLOB_PROPERTIES = new Properties();
        InputStream inputStream = Configurations.class.getResourceAsStream("/jenkins.properties");
        try {
            GLOB_PROPERTIES.load(inputStream);
        } catch (IOException e) {
            LOGGER.error("Can't load properties", e);
        }
        DRIVER_STRATEGY = StringUtils.isNotEmpty(System.getProperty("strategy")) ? System.getProperty("strategy").toUpperCase() : get("Strategy").toUpperCase();
        ADMIN_NAME = StringUtils.isNotEmpty(System.getProperty("name")) ? System.getProperty("name") : get("AdminName");
        PASSWORD = StringUtils.isNotEmpty(System.getProperty("password")) ? System.getProperty("password") : get("UserPassword");
        URL = StringUtils.isNotEmpty(System.getProperty("url")) ? System.getProperty("url") : get("Url");
        BROWSER = StringUtils.isNotEmpty(System.getProperty("browser")) ? System.getProperty("browser") : get("BrowserName");
        HUB_URL = StringUtils.isNotEmpty(System.getProperty("huburl")) ? System.getProperty("huburl") : get("GridUrl");
    }

    private static String get(String propertyName) {
        return GLOB_PROPERTIES.getProperty(propertyName);
    }

}
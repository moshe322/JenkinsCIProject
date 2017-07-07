package webdriver;


import base.Configurations;
import helpers.TimeoutConstants;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.*;

import java.net.MalformedURLException;
import java.net.URL;

public class GridWebDriverStrategy implements WebDriverStrategy{
    protected static final Logger LOGGER = LogManager.getLogger(GridWebDriverStrategy.class);

    @Override
    public void setStrategy() {
        Configuration.browser = Configurations.BROWSER;
        Configuration.baseUrl = Configurations.URL;
        Configuration.dismissModalDialogs = true;
        Configuration.timeout = TimeoutConstants.SHORT_TIMEOUT;
        DesiredCapabilities caps = new DesiredCapabilities();
        switch (Configurations.BROWSER){
            case "firefox":
                caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                caps.setBrowserName(BrowserType.FIREFOX);
                caps.setCapability("nativeEvents", false);
                break;
            case "ie":
                caps.setBrowserName(BrowserType.IE);
                break;
            case "chrome":
                caps.setBrowserName(BrowserType.CHROME);
            default:
                caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                caps.setBrowserName(BrowserType.FIREFOX);
                caps.setCapability("nativeEvents", false);
                break;
        }
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(Configurations.HUB_URL), caps);

            //set directory for grid strategy
            ((RemoteWebDriver) driver).setFileDetector(new LocalFileDetector());
        }catch (MalformedURLException e){
            LOGGER.error(String.format("Not correct url - %s",Configurations.HUB_URL));
            throw new IncorrectHubUrlException();
        }
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }
}

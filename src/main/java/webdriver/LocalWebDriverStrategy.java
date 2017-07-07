package webdriver;


import base.Configurations;
import helpers.TimeoutConstants;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class LocalWebDriverStrategy implements WebDriverStrategy {
    @Override
    public void setStrategy() {
        Configuration.browser = Configurations.BROWSER;
        Configuration.baseUrl = Configurations.URL;
        Configuration.dismissModalDialogs = true;
        Configuration.timeout = TimeoutConstants.SHORT_TIMEOUT;
        DesiredCapabilities caps = new DesiredCapabilities();
        WebDriver driver = null;
        switch (Configurations.BROWSER){
            case "firefox":
                caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                caps.setCapability("nativeEvents", false);
                driver = new FirefoxDriver(caps);
                break;
            case "chrome":
                driver = new ChromeDriver(caps);
                break;
            case "ie":
                driver = new InternetExplorerDriver();
                break;
            default:
                caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
                caps.setCapability("nativeEvents", false);
                driver = new FirefoxDriver(caps);
                break;
        }
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);
    }

}

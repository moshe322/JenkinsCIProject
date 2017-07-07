package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import webdriver.GridWebDriverStrategy;
import webdriver.WebDriverContext;
import webdriver.LocalWebDriverStrategy;
import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;


public class TestBase {

	protected static final Logger LOGGER = LogManager.getLogger(TestBase.class);

	@BeforeSuite(alwaysRun = true)
	public void oneTimeSetUp() {
		setWebDriverStrategy();
	}

	@BeforeMethod(alwaysRun = true)
	public void openURL() {
		open(Configurations.URL);
	}


	@AfterMethod(alwaysRun = true)
	public void shutdown(){
		close();
	}

	protected static void setWebDriverStrategy(){
		switch (Configurations.DRIVER_STRATEGY.toUpperCase()){
			case "GRID":
				WebDriverContext.setWebDriverStrategy(new GridWebDriverStrategy());
				break;
			case "LOCAL":
				WebDriverContext.setWebDriverStrategy(new LocalWebDriverStrategy());
				break;
			default:
				WebDriverContext.setWebDriverStrategy(new LocalWebDriverStrategy());
				break;
		}
	}

}
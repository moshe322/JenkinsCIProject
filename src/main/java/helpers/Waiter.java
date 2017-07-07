package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Waiter {

    private static int afterWaitSleep = 1000;

    @SuppressWarnings("unchecked assignment")
    public static void waitFor(ExpectedCondition condition) {
        new WebDriverWait(getWebDriver(), 60).until(condition);
        sleep(afterWaitSleep);
    }

    public static void waitForPageToLoad() {
        waitFor(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                return ((String) executeJavaScript("return document.readyState")).equalsIgnoreCase("complete");
            }
        });
        sleep(afterWaitSleep);
    }
}

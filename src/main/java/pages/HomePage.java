package pages;

import base.PageBase;
import helpers.Waiter;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by ViktorTyulikov on 7/7/2017.
 */
public class HomePage extends PageBase {

    private static final By TOP_BUTTON = By.cssSelector("#menus a[href*='/top-games/']");

    public static void goToTopPage(){
        $(TOP_BUTTON).click();
    }
}

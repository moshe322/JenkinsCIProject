package pages;

import base.PageBase;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by ViktorTyulikov on 7/7/2017.
 */
public class TopPage extends PageBase {

    private static final By FIRST_BOARDGAME = By.cssSelector(".content > p > a:first-of-type");

    public static void clickOnFirstBoardgame(){
        $(FIRST_BOARDGAME).click();
    }
}

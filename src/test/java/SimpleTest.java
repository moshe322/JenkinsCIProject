import base.TestBase;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.TopPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.TestCaseId;

/**
 * Created by ViktorTyulikov on 7/6/2017.
 */
public class SimpleTest extends TestBase {

    @Test
    @Features("Top page test")
    @TestCaseId("1.1.1")
    public void topPageTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage.goToTopPage();
        TopPage.clickOnFirstBoardgame();
        softAssert.assertFalse(true, "This is not top game");
        softAssert.assertAll();
    }
}

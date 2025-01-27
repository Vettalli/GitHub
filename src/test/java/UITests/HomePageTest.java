package UITests;

import Base.BaseTest;
import PageObjects.HomePage;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(description = "Test check main elements on GitHub home page")
    public void homePageTest() {
        HomePage homePage = new HomePage();
        homePage.checkHomePageBackGroundPresent();
        homePage.checkMainElementsPresent();
    }

    //ToDo: send locale as parameter to test (relevant for all tests)
    //ToDo: tests with different localisation
}

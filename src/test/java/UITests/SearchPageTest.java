package UITests;

import Base.BaseTest;
import Core.UserData;
import PageObjects.HomePage;
import PageObjects.SearchPage;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {

    @Test(description = "Search valid account test")
    public void homePageSearchValidAccountTest() {
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        homePage.checkHomePageBackGroundPresent();
        homePage.checkMainElementsPresent();
        homePage.sendTextToSearchField(UserData.LOGIN_NAME);
        searchPage.goToUsersTab();
        searchPage.findElementByText(UserData.LOGIN_NAME);
    }

    @Test(description = "Search empty string test")
    public void homePageSearchEmptyStringTest() {
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        homePage.checkHomePageBackGroundPresent();
        homePage.checkMainElementsPresent();
        homePage.sendTextToSearchField("");
        searchPage.checkPageAfterSearchingEmptyStringPresent();
    }

    @Test(description = "Issues tab with valid account test")
    public void homePageSearchIssuesWithValidAccountTest() {
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        homePage.checkHomePageBackGroundPresent();
        homePage.checkMainElementsPresent();
        homePage.sendTextToSearchField(UserData.LOGIN_NAME);
        searchPage.goToUsersTab();
        searchPage.findElementByText(UserData.LOGIN_NAME);
        searchPage.goToIssuesTab();
        searchPage.checkTabWithResultsOpened();
    }

    @Test(description = "Repositories tab with valid account test")
    public void homePageSearchRepoWithValidAccountTest() {
        HomePage homePage = new HomePage();
        SearchPage searchPage = new SearchPage();
        homePage.checkHomePageBackGroundPresent();
        homePage.checkMainElementsPresent();
        homePage.sendTextToSearchField(UserData.LOGIN_NAME);
        searchPage.goToUsersTab();
        searchPage.findElementByText(UserData.LOGIN_NAME);
        searchPage.goToRepositoriesTab();
        searchPage.checkTabWithResultsOpened();
    }
}

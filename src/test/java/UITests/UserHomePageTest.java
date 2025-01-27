package UITests;

import Base.BaseTest;
import Core.UserData;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.UserHomePage;
import org.testng.annotations.Test;

public class UserHomePageTest extends BaseTest {

    @Test(description = "Check repository's main tabs valid account test")
    public void CheckRepositoryMainTabValidAccountTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        UserHomePage userHomePage = new UserHomePage();
        homePage.checkHomePageBackGroundPresent();
        homePage.clickSingInButton();
        loginPage.fillSignInForm(UserData.LOGIN_NAME, UserData.LOGIN_PASSWORD);
        loginPage.clickSubmitButton();
        userHomePage.checkUserName(UserData.LOGIN_NAME);
        userHomePage.openUserMenuAndGoToTab(UserData.LOGIN_NAME, "Your repositories");
        userHomePage.checkMainElementsOnUserPage();
    }

    @Test(description = "Check repository's main tabs valid account test")
    public void createNewIssueValidAccountTest() {
        String newIssueTitle = "Test Issue";
        String newIssueText = "Test Text";
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        UserHomePage userHomePage = new UserHomePage();
        homePage.checkHomePageBackGroundPresent();
        homePage.clickSingInButton();
        loginPage.fillSignInForm(UserData.LOGIN_NAME, UserData.LOGIN_PASSWORD);
        loginPage.clickSubmitButton();
        userHomePage.checkUserName(UserData.LOGIN_NAME);
        userHomePage.openUserMenuAndGoToTab(UserData.LOGIN_NAME, "Your repositories");
        userHomePage.goToRepo("GitHubTest");
        userHomePage.goToTab("Issues");
        userHomePage.clickNewIssueButton();
        userHomePage.fillNewIssuesFields(newIssueTitle, newIssueText);
        userHomePage.checkNewIssuePresent(newIssueTitle);
    }

    //ToDo: delete issue test
}

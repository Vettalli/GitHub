package UITests;

import Base.BaseTest;
import Core.UserData;
import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.ResetPasswordPage;
import PageObjects.UserHomePage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final String ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD = "Incorrect username or password";

    @Test(description = "Log in to Github with valid data")
    public void loginWithValidDataTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        UserHomePage userHomePage = new UserHomePage();
        homePage.checkHomePageBackGroundPresent();
        homePage.clickSingInButton();
        loginPage.fillSignInForm(UserData.LOGIN_NAME, UserData.LOGIN_PASSWORD);
        loginPage.clickSubmitButton();
        userHomePage.checkUserName(UserData.LOGIN_NAME);
    }

    @Test(description = "Log in to Github with invalid password")
    public void loginWithInvalidPasswordTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.checkHomePageBackGroundPresent();
        homePage.clickSingInButton();
        loginPage.fillSignInForm(UserData.LOGIN_NAME, "test");
        loginPage.clickSubmitButton();
        loginPage.checkText(ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD);
    }

    @Test(description = "Log in to Github with invalid login")
    public void loginWithInvalidLoginTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.checkHomePageBackGroundPresent();
        homePage.clickSingInButton();
        loginPage.fillSignInForm("test", UserData.LOGIN_PASSWORD);
        loginPage.clickSubmitButton();
        loginPage.checkText(ERROR_MESSAGE_INVALID_USERNAME_OR_PASSWORD);
    }

    @Test(description = "Log in to Github with empty fields")
    public void loginWithEmptyFieldsTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        homePage.checkHomePageBackGroundPresent();
        homePage.clickSingInButton();
        loginPage.fillSignInForm("", UserData.LOGIN_PASSWORD);
        loginPage.clickSubmitButton();
        loginPage.checkFormValidation();
    }

    @Test(description = "Forget password test")
    public void forgetPasswordTest() {
        HomePage homePage = new HomePage();
        LoginPage loginPage = new LoginPage();
        ResetPasswordPage resetPasswordPage = new ResetPasswordPage();
        homePage.checkHomePageBackGroundPresent();
        homePage.clickSingInButton();
        loginPage.clickForgotPasswordButton();
        resetPasswordPage.checkResetPasswordPagePresent();
        resetPasswordPage.checkMainElementsPresent();
    }
}
